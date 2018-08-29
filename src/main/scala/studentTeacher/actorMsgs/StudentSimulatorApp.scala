package studentTeacher.actorMsgs

import akka.actor.{ActorSystem, Props}
import studentTeacher.protocols.TeacherProtocol.QuoteRequest

object StudentSimulatorApp extends App {
	// 初始化ActorSystem
	val actorSystem = ActorSystem("UniversityMessageSystem")
	// 创建Teacher Actor Ref
	val teacherRef = actorSystem.actorOf(Props[TeacherLogActor])
	// 发送消息给TeacherActor
	teacherRef ! QuoteRequest
	// 等待2s
	Thread.sleep(2000)
	// 关闭ActorSystem
//	actorSystem.stop(teacherRef)
	actorSystem.terminate()
}
