package lifeCycle

import akka.actor.{ActorSystem, DeadLetter, Props}

object LifecycleApp2 extends App {
	
	val actorSystem = ActorSystem("LifecycleActorSystem2")
	val lifecycleActor = actorSystem.actorOf(Props[BasicLifecycleLoggingActor], "lifecycleActor")
	
	// 创建DeadLetterListenerActor
	val deadLetterListener = actorSystem.actorOf(Props[MyDeadLetterListener])
	// 订阅DeadLetterListenerActor的EventStream，订阅者是ActorRef
	actorSystem.eventStream.subscribe(deadLetterListener, classOf[DeadLetter])
	
	// DeadLetter Actor处理其邮箱中的消息，将每条消息包装为DeadLetter并将其发布到EventStream。
	// 另一个名为DeadLetterListener的Actor消费所有DeadLetter并将其作为日志消息发布出去。
	// 在谈到日志记录时，所有日志消息都发布到EventStream，并且我们可以自由订阅该EventStream，订阅者也需要是一个Actor。
	
	lifecycleActor ! "hello"
	lifecycleActor ! "stop"
	lifecycleActor ! "hello"
	
	// 打印如下日志
	// FROM LISTENER： DeadLetter(hello,Actor[akka://LifecycleActorSystem2/deadLetters],Actor[akka://LifecycleActorSystem2/user/lifecycleActor#-730043212])
}