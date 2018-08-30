package requestResponse

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorLogging, ActorRef}
import studentTeacher.protocols.StudentProtocol.InitSignal
import studentTeacher.protocols.TeacherProtocol.{QuoteRequest, QuoteResponse}

import scala.concurrent.duration.Duration

class StudentDelayedActor(teacherActorRef: ActorRef) extends Actor with ActorLogging {
	
	def receive = {
		
		/*
		 * This InitSignal is received from the DriverApp.
		 * On receipt and after 5 seconds, the Student sends a message to the Teacher actor.
		 * The teacher actor on receipt of the QuoteRequest responds with a QuoteResponse
		 */
		case InitSignal => {
			import context.dispatcher
			context.system.scheduler.schedule(Duration.Zero, Duration(5, TimeUnit.SECONDS), teacherActorRef, QuoteRequest)
			// teacherActorRef ! QuoteRequest
		}
		
		case QuoteResponse(quoteString) => {
			log.info("接收到来自Teacher的QuoteResponse")
			log.info(s"打印Student接收到的Quote字符串：$quoteString")
		}
		
	}
	
}