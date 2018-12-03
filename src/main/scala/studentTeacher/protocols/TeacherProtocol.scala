package studentTeacher.protocols

object TeacherProtocol {
	
	/*
	 * StudentActor用来给TeacherActor发送消息
	 *
	 */
	case class QuoteRequest()
	
	/*
	 * TeacherActor以此消息对象响应Student
	 *
	 */
	case class QuoteResponse(quoteString: String)
	
}