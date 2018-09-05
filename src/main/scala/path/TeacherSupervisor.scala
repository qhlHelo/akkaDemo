package path

import akka.actor.{Actor, ActorLogging, Props}
import requestResponse.TeacherActor

class TeacherSupervisor extends Actor with ActorLogging{
	val teacherActor = context.actorOf(Props[TeacherActor], "teacherActor")
	
	def receive: Receive = {
		case "teacherActor" => println(teacherActor.path)
	}
}
