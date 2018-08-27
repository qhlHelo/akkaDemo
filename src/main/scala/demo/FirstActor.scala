package demo

import akka.actor.{Actor, Props}

object FirstActor extends Actor {
	val child = context.actorOf(Props[MyActor], name = "MyChild")
	
	def receive: Receive = {
		case x => sender() ! x
	}
}
