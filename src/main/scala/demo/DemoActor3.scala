package demo

import akka.actor.{Actor, ActorLogging}

object DemoActor3 {
	
	case class Greeting(from: String)
	
	case object Goodbye
	
}

class DemoActor3 extends Actor with ActorLogging {
	
	import DemoActor3._
	
	def receive = {
		case Greeting(greeter) ⇒ log.info(s"I was greeted by $greeter.")
		case Goodbye ⇒ log.info("Someone said goodbye to me.")
	}
}