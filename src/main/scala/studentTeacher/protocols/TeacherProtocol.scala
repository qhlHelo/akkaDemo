package studentTeacher.protocols

object TeacherProtocol {
	
	/*
	 * Student发送消息用以请求Quotation
	 *
	 */
	case class QuoteRequest()
	
	/*
	 * TeacherActor以此消息对象返回给Student
	 * 实际的quote字符串在此response被覆盖
	 *
	 */
	case class QuoteResponse(quoteString: String)
	
}
