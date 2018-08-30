package lifeCycle

import akka.actor.{ActorSystem, Props}

object LifecycleApp extends App {
	
	val actorSystem = ActorSystem("LifecycleActorSystem")
	val lifecycleActor = actorSystem.actorOf(Props[BasicLifecycleLoggingActor], "lifecycleActor")
	
	lifecycleActor ! "hello"
	
	Thread.sleep(2000)
	
	actorSystem.terminate()
	
}