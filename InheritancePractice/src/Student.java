import java.time.LocalDate;

public class Student extends Person{
	private int admissionYear;
	private int graduationYear;
	private String major;
	private String email;
	
	public Student(String first, String last, int admisY, int gradY, String major, String email) {
		super(first,last);
		LocalDate today = LocalDate.now();
		if (admissionYear > 1900 && admissionYear <= today.getYear()) {
			admissionYear = admisY;
		}
		
		graduationYear = gradY;
		this.major = major;
		this.email = email;
		
	}
	
	public int getAdmission() {
		return admissionYear;
	}
	
	@Override public void print() {
		super.print();
		System.out.println("Admitted in " + admissionYear);
	}
}
