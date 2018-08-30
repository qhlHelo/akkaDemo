package lifeCycle

import akka.actor.{Actor, ActorLogging}
import akka.event.LoggingReceive

/**
  * Actor与Servlet生命周期非常类似
  * Servlet生命周期：1）初始化阶段，调用init()方法；2）响应客户请求，调用service()方法；3）终止阶段，调用destroy()方法
  * 但是与Servlets不同，Actors可以在构造函数内部访问ActorContext
  */
class BasicLifecycleLoggingActor extends Actor with ActorLogging {
	
	log.info("Constructor中")
	// 打印ActorRef
	log.info("BasicLifecycleLoggingActor的地址(锚)："+ context.self.toString())
	
	override def preStart() = {
		log.info("PreStart方法中")
	}
	
	def receive = LoggingReceive {
		case "hello" => log.info("处理响应：hello-lifecycle")
	}
	
	override def postStop() = {
		log.info("PostStop方法中")
	}
	
}
