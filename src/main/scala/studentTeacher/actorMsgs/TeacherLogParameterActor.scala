package studentTeacher.actorMsgs

import akka.actor.{Actor, ActorLogging}
import studentTeacher.protocols.TeacherProtocol.{QuoteRequest, QuoteResponse}

class TeacherLogParameterActor(quotes: List[String]) extends Actor with ActorLogging {
	
	lazy val _quotes = quotes
	
	def receive = {
		
		case QuoteRequest => {
			
			import util.Random
			
			// get a random element (for now)
			val quoteResponse = QuoteResponse(_quotes(Random.nextInt(_quotes.size)))
			log.info(quoteResponse.toString())
			// log.info("Quote printed") //This message is just to assert from the testcase
		}
		
	}
	
	def quoteList = _quotes
	
}
