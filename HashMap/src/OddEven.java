
public class OddEven {
	
	    public static boolean isEven(int n) {
	        return n % 2 == 0;
	    }
	    
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        int number = Integer.valueOf(args[0]);
	        if (isEven(number)) {
	            System.out.println("Even");
	        } else {
	            System.out.println("Odd");
	        }

	    }

}
