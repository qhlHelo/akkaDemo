package requestResponse

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorLogging, ActorRef}
import studentTeacher.protocols.StudentProtocol.InitSignal
import studentTeacher.protocols.TeacherProtocol.{QuoteRequest, QuoteResponse}

import scala.concurrent.duration.Duration

class StudentDelayedActor(teacherActorRef: ActorRef) extends Actor with ActorLogging {
	
	def receive = {
		
		/*
		 * 接收来自DriverApp初始信号
		 * 接收到信号5秒后,StudentActor发送一条消息给TeacherActor
		 * TeacherActor在接收到QuoteRequest后给予QuoteResponse响应
		 */
		case InitSignal => {
			import context.dispatcher
			/*
			 * 接收4个参数：
			 * 1、在第一次运行的时候需要等待多少时间；
			 * 2、频率；
			 * 3、发送消息的目标ActorRef ；
			 * 4、消息
			 */
			context.system.scheduler.schedule(Duration.Zero, Duration(5, TimeUnit.SECONDS), teacherActorRef, QuoteRequest)
			// teacherActorRef ! QuoteRequest
		}
		
		case QuoteResponse(quoteString) => {
			log.info("接收到来自Teacher的QuoteResponse")
			log.info(s"打印Student接收到的Quote字符串：$quoteString")
		}
		
	}
	
}