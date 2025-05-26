import java.util.ArrayList;

public class CalcFactorial {
	
	public static ArrayList<Integer> factorial(int num) {
		ArrayList<Integer> factorial = new ArrayList<Integer>();
		
		
		int result = 1;
		
		for (int i = 1; i <= num; i++) {
			result *= i;
			factorial.add(result);
			
		}
		
		return factorial;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> factorial = factorial(6);
		System.out.println(factorial);
		
		ArrayList<String> names = new ArrayList<String>();
		//.add()
		//.set()
		//.get()
		//.remove()
		names.add("Nayera");
		names.add("Abdessalam");
		System.out.print(names);
		
		
	}

}
