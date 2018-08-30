package requestResponse

import akka.actor.{Actor, ActorLogging, ActorRef}
import studentTeacher.protocols.StudentProtocol.InitSignal
import studentTeacher.protocols.TeacherProtocol.{QuoteRequest, QuoteResponse}

class StudentActor(teacherActorRef: ActorRef) extends Actor with ActorLogging {
	def receive: Receive = {
		/*
		 * 此初始信号接收自DriverApp
		 * 接收后，Student会发送信息给TeacherActor
		 * TeacherActor接收到QuoteRequest后会通过QuoteResponse予以响应
		 */
		case InitSignal => {
			teacherActorRef ! QuoteRequest
		}
		
		/*
		 * Student接收来自TeacherActor的quote并记录日志
		 *
		 */
		case QuoteResponse(quoteString) => {
			log.info("接收到来自Teacher的QuoteResponse")
			log.info(s"打印Student接收到的Quote字符串：$quoteString")
		}
	}
}
