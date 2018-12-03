package studentTeacher.actorMsgs

import akka.actor.{ActorSystem, Props}
import studentTeacher.protocols.TeacherProtocol.QuoteRequest

import akka.pattern.ask


object StudentSimulatorApp extends App {
	// 初始化ActorSystem
	val actorSystem = ActorSystem("UniversityMessageSystem")
	// 创建Teacher Actor Ref
	val teacherRef = actorSystem.actorOf(Props[TeacherActor])
	// 发送消息给TeacherActor
	teacherRef ! QuoteRequest
	teacherRef ? "hello"
	// 等待2s
	Thread.sleep(2000)
	// 关闭ActorSystem
	//	actorSystem.stop(teacherRef)
	actorSystem.terminate()
}