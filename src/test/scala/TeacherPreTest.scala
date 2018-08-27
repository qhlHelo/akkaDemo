
import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, TestActors, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import studentTeacher.TeacherLogActor

class TeacherPreTest extends TestKit(ActorSystem("UniversityMessageSystem"))
	//	with ImplicitSender
	with WordSpecLike
	with Matchers
	with BeforeAndAfterAll {
	
	override def afterAll: Unit = {
		TestKit.shutdownActorSystem(system)
	}
	
	"A teacher with ActorLogging" must {
		
		"log a quote when a QuoteRequest message is sent" in {
			
			val teacherRef = TestActorRef[TeacherLogActor]
			
			teacherRef ! "hello world"
			
			// 断言收到消息
			expectMsg("hello world")
		}
	}
}
