package studentTeacher.protocols

object StudentProtocol {
	
	/*
     * Driver App发出此信号来询问StudentActor来发送信息给TeacherActor
     *
     */
	case class InitSignal()
	
}