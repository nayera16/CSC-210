
public class Student {
	public EnrollmentStatus status;
	private enum EnrollmentStatus{ ENROLLED, DROPPED };
	
	public Student() {
		status = EnrollmentStatus.ENROLLED;
	}
	
	public EnrollmentStatus getStatus() {
		return status;
	}
	
	public void setStatus(EnrollmentStatus status) {
		this.status = status;
	}
}
