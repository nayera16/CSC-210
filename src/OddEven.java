import java.util.Scanner;

public class OddEven {
		
	public static boolean isOdd(int number) {
	    return number % 2 == 1;
	}
	    
	public static boolean isEven(int number) {
	    return number % 2 == 0;
	}


	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a number: ");
		
		int number = scnr.nextInt();
		scnr.close();
		
		if (isOdd(number)){
			System.out.println(number + " is odd.");
		}
		if (isEven(number)) {
			System.out.println(number + " is even.");
		}
	}
}



