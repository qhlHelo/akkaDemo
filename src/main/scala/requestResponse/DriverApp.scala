package requestResponse

import akka.actor.{ActorSystem, Props}
import studentTeacher.protocols.StudentProtocol.InitSignal

object DriverApp extends App {
	// 初始化ActorSystem
	val system = ActorSystem("UniversityMessageSystem")
	// 创建TeacherActor
	val teacherRef = system.actorOf(Props[TeacherActor],"teacherActor")
	// 创建StudentActor，使用TeacherActorRef作为构造参数
	val studentRef = system.actorOf(Props(new StudentDelayedActor(teacherRef)), "studentActor")
	// 发送一条消息给StudentActor
	studentRef ! InitSignal
	// 等待30秒
	Thread.sleep(30000)
	// 关闭ActorSystem
	system.terminate()
}
