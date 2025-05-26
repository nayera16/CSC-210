
public class UsingEnum {
	
	public enum Season { WINTER, SPRING, SUMMER, FALL};
	
	public static void main(String[] args) {
		Season mySeason = Season.SUMMER;
		
		
		for (Season s : Season.values()) {
			System.out.println(s);
		}
		
		if (mySeason.equals(Season.FALL)) System.out.println("It's fall!");
		
		// or use switch case
		
		switch(mySeason) {
		case WINTER:
			System.out.println("It's winter!");
			break; // without break, it runs all cases after the match
		
		case SPRING:
			System.out.println("It's spring!");
			break;
		
		case SUMMER:
			System.out.println("It's summer!");
			break;
		
		case FALL:
			System.out.println("It's fall!");
			break;
		}
		
		
	}

}
