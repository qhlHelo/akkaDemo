package studentTeacher

import akka.actor.{Actor, ActorLogging}
import akka.event.Logging
import studentTeacher.TeacherProtocol._

class TeacherActor extends Actor{
	
//	override val log = Logging.getLogger(context.system,this)
	
	val quotes = List(
		"Moderation is for cowards",
		"Anything worth doing is worth overdoing",
		"The trouble is you think you have time",
		"You never gonna know if you never even try"
	)
	
	def receive: Receive = {
		case QuoteRequest => {
			import util.Random
			// 从List获取一个随机的quote，并构造一个QuoteResponse
			val quoteResponse = QuoteResponse(quotes(Random.nextInt(quotes.size)))
			println(quoteResponse.toString)
		}
	}
}
