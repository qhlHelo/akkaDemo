package path

import akka.actor.{ActorSystem, Props}
import lifeCycle.BasicLifecycleLoggingActor

/**
  * ActorSystem.actorOf用于创建ActorSystem的Top-Level Actor；ActorContext.actorOf则可以创建普通Actor的子Actor
  */

object PathDemo extends App {
	val actorSystem = ActorSystem("SupervisionActorSystem") // root
	//	val actorRef = actorSystem.actorOf(Props[BasicLifecycleLoggingActor])
	//	println("actorRef's address：" + actorRef.path) // akka://SupervisionActorSystem/user/$a，其中：$a是系统默认为你生成的actor的名字
	val teacherSupervisionActor = actorSystem.actorOf(Props[BasicLifecycleLoggingActor], "teacherSupervisionActor")
	println("top-level actor: " + teacherSupervisionActor.path) // akka://SupervisionActorSystem/user/teacherSupervisionActor
}
