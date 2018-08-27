package studentTeacher

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActors, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

//class TeacherPreTest() extends TestKit(ActorSystem("UniversityMessageSystem"))
//	with WordSpecLike
//	with MustMatchers
//	with BeforeAndAfterAll {
//
//}

class TeacherPreTest extends TestKit(ActorSystem("TeacherPreTest")) with ImplicitSender
	with WordSpecLike with Matchers with BeforeAndAfterAll {
	
	def afterAll: Unit = {
		TestKit.shutdownActorSystem(system)
	}

	"An Echo actor" must {

		"send back messages unchanged" in {
			val echo = system.actorOf(TestActors.echoActorProps)
			echo ! "hello world"
			expectMsg("hello world")
		}

	}
}
