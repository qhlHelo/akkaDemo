package studentTeacher.actorMsgs

import akka.actor.{Actor, ActorLogging}
import akka.event.Logging
import studentTeacher.protocols.TeacherProtocol._

/**
  * Log Actor
  * @param quotes
  */
class TeacherLogActor(quotes: List[String]) extends Actor with ActorLogging {
	
	override val log = Logging.getLogger(context.system, this)
	
	lazy val _quotes = quotes
	
	def receive: Receive = {
		
		case QuoteRequest => {
			import util.Random
			
			// 从List获取一个随机的quote，并构造一个QuoteResponse
			val quoteResponse = QuoteResponse(_quotes(Random.nextInt(_quotes.size)))
			
			log.info(quoteResponse.toString)
		}
	}
	
	def quoteList=quotes
}
