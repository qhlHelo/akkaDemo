package requestResponse

import akka.actor.{ActorSystem, Props}

object DriverApp extends App {
	// 初始化ActorSystem
	val system = ActorSystem("UniversityMessageSystem")
	// 创建TeacherActor
	val teacherRef = system.actorOf(Props[TeacherActor],"teacherActor")
	// 创建StudentActor，使用TeacherActorRef作为构造参数
	val studentRef = system.actorOf(Props(new StudentActor(teacherRef)), "studentActor")
	
}
