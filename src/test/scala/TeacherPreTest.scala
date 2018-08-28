
import actor.TeacherLogActor
import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import studentTeacher.TeacherProtocol.QuoteRequest
import studentTeacher.{TeacherActor, TeacherLogActor}

class TeacherPreTest extends TestKit(ActorSystem("UniversityMessageSystem"))
	//	with ImplicitSender
	with WordSpecLike
	with Matchers
	with BeforeAndAfterAll {

	override def afterAll: Unit = {
		TestKit.shutdownActorSystem(system)
	}

	// 1. Sends message to the Print Actor(TeacherActor).
	"A teacher" must {

		"print a quote when a QuoteRequest message is sent" in {

			val teacherRef = TestActorRef[TeacherActor]
			teacherRef ! QuoteRequest
		}
	}

	// 2. Sends message to the Log Actor(TeacherLogActor).
	"A teacher with ActorLogging" must {

		"log a quote when a QuoteRequest message is sent" in {

			val teacherRef = TestActorRef[TeacherLogActor]

			teacherRef ! "hello world"

			// 断言：收到消息
			expectMsg("hello world")
		}
	}
}
