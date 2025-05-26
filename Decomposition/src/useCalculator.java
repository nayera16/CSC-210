import java.util.Scanner;

public class useCalculator {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
	    double num1 = input.nextDouble();
	    
	    System.out.println("Enter second number: ");
        double num2 = input.nextDouble();

        System.out.println("Enter operation (+, -, *, /): ");
        char operation = input.next().charAt(0);
        
	   
		boolean keep_running = true;
			while (keep_running) {
				Calculator calc = new Calculator(num1, num2, operation);
			System.out.println("Result: " + calc.getResult());
	        System.out.println("Do you want to continue? (yes/no): ");
	        String choice = input.next();
	        if (choice.equalsIgnoreCase("no")) {
	            keep_running = false;
	        }
		}
		
	}

}
