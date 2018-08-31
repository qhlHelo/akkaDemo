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
	log.info("BasicLifecycleLoggingActor的地址(锚)：" + context.self.toString())
	
	// 在actor实例化后执行，重启时不会执行
	// preRestart：在actor异常重启前保存当前状态
	override def preStart() = {
		log.info("PreStart方法中")
	}
	
	def receive = LoggingReceive {
		case "hello" => log.info("处理响应：hello-lifecycle")
		case "stop" => context.stop(self)
	}
	
	// 在actor正常终止后执行，异常重启时不会执行
	// postRestart：在actor异常重启后恢复重启前保存的状态。当异常引起了重启，新actor的postRestart方法被触发，默认情况下preStart方法被调用
	override def postStop() = {
		log.info("PostStop方法中")
	}
	
}
