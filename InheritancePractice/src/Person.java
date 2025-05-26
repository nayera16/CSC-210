import java.time.LocalDate;
public class Person {
	
	private String firstName;
	private String lastName;
	private int year;
	private int month;
	private int day;
	
	public Person (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	public void setBirthday(int year, int month, int day) {
		LocalDate today = LocalDate.now();
		if (year >= 1900 && year <= today.getDayOfYear()) this.year = year;
		if (month >= 1 && month <= 12) this.month = month;
		if (day >= 1 && day <= 31) this.day = day;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;

	}
	
	public String getFirstName() {
		return firstName;
		
	}
	public String getLastName() {
		return lastName;
		
	}
	public String getBirthday() {
		String birthday = "";
		birthday += year + "/";
		birthday += month + "/";
		birthday += day + "/";
		return birthday;
		
		
	}
	public void print() {
        System.out.print(firstName + " " + lastName);
        System.out.println(" born on " + getBirthday());
    }
	

}
