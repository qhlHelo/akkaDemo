package lifeCycle

import akka.actor.{ActorSystem, Kill, PoisonPill, Props}

object LifecycleApp extends App {
	
	val actorSystem = ActorSystem("LifecycleActorSystem")
	val lifecycleActor = actorSystem.actorOf(Props[BasicLifecycleLoggingActor], "lifecycleActor")
	
	lifecycleActor ! "hello"
	
	Thread.sleep(2000)
	
	actorSystem.terminate()
	// 一、PostStop何时被调用？ActorSystem被关闭的时候，有如下几种方法
	// 1.actorSystem.stop(lifecycleActor)
	// 2.发消息来停止ActorContext
	lifecycleActor ! "stop"
	// 3.akka.actor.PoisonPill：用于发送给目标Actor
	lifecycleActor ! PoisonPill
	// 4.也可以代替发送PoisonPill，发送kill消息给目标Actor
	lifecycleActor ! Kill
	
	// 二、PoisonPill和Kill的区别：
	// 1，PoisonPill会给所有的watchers发送terminated消息
	// 2，Kill会抛出ActorKilledException并传播到它的监管者
	
	lifecycleActor ! "hello" // 发送消息给已经被stop的Actor，此消息为DeadLetter
	// 提示如下信息：
	// [INFO ] akka.actor.RepointableActorRef - Message [akka.actor.Kill$] without sender to\
	// Actor[akka://LifecycleActorSystem/user/lifecycleActor#361061603] was not delivered. [1] dead letters encountered.
	
}