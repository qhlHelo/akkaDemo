package com.actordemo;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * 创建Actor，extends AbstractActor来实现
 */
public class DemoActor1 extends AbstractActor {
	
	private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
	
	/**
	 * createReceive方法用于设置初始化行为
	 * createReceive方法无参并返回AbstractActor.Receive，定义了Actor可以处理哪些消息，以及如何处理消息的实现
	 * 可以通过ReceiveBuilder构建你的行为，这个构建在AbstractActor中有一个方便的工厂方法叫做receiveBuilder
	 *
	 * @return AbstractActor.Receive
	 */
//	public Receive createReceive() {
//		return receiveBuilder()
//				// 由于Akka Actor的消息循环是详尽无遗的，所以需要提供模式匹配用于所有消息
//				.match(String.class, s -> {
//					log.info("Received String message: {}", s);
//				})
//				.matchAny(o -> log.info("received unknown message"))
//				.build();
//	}
	
	// Props是一个配置类，用于指定创建的Actor的部署信息（如使用哪个调度程序），它是不可变并可自由共享的
	// 推荐为每个Actor提供静态工厂方法
	
//	static Props(Integer magicNum) {
//		return Props.create(DemoActor1.class, () -> new DemoActor1(magicNum));
//	}
//
//	private final Integer magicNum;
//
//	public DemoActor1(Integer magicNum) {
//		this.magicNum = magicNum;
//	}
	
	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(Integer.class, i -> {
					getSender().tell(i, getSelf());
				})
				.build();
	}
}
