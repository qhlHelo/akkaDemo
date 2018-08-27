package demo

import akka.actor.{Actor, Props}

object DemoActor {
	def props(magicNum: Int): Props = Props(new DemoActor(magicNum))
}

class DemoActor(magicNum: Int) extends Actor {
	def receive: Receive = {
		case x: Int => sender() ! (x + magicNum)
	}
}

class DemoActor2 extends Actor {
	context.actorOf(DemoActor.props(42),"demo")
	
	def receive: Receive = null
}