package studentTeacher

import akka.actor.{Actor, ActorLogging}
import akka.event.Logging
import studentTeacher.TeacherProtocol._

class TeacherActor extends Actor with ActorLogging{
	
	override val log = Logging.getLogger(context.system,this)
	
	val quotes = List(
		"语文需要理解文章含义",
		"数学需要头脑灵活",
		"英语需要勤学多练"
	)
	
	def receive: Receive = {
		case QuoteRequest => {
			import util.Random
			// 从List获取一个随机的quote，并构造一个QuoteResponse
			val quoteResponse = QuoteResponse(quotes(Random.nextInt(quotes.size)))
			log.info(quoteResponse.toString)
		}
	}
}
