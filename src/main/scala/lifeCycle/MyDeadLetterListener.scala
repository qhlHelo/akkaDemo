package lifeCycle

import akka.actor.{Actor, DeadLetter}

class MyDeadLetterListener extends Actor {
	def receive = {
		case deadLetter: DeadLetter => println(s"FROM LISTENER： $deadLetter")
	}
}