package demo

import akka.actor.{Actor, ActorLogging}

/**
  * Actor为Base Trait，定义Actor需要实现receive方法，并通过模式匹配定义一系列case语句
  */
object MyActor {
	
	case class Greeting(from: String)
	
	case object GoodBye
	
}

class MyActor extends Actor with ActorLogging {
	
	import MyActor._
	
	// Akka Actor的消息循环是详尽无遗的，所以需要提供模式匹配用于所有消息
	def receive: Receive = {
		case Greeting(greeter) => log.info(s"I was greeted by $greeter.")
		case GoodBye => log.info("Someone said goodbye to me.")
	}
}
