import java.util.ArrayList;

public class FactorialArray {
	
	public static ArrayList<Integer> factorial(int n){
		ArrayList<Integer> factorialList = new ArrayList<>();
		int nextNum = 1;
		factorialList.add(nextNum);
		
		for (int i = 1; i <= n; i++) {
			nextNum *= i;
			factorialList.add(nextNum);
		}
		return factorialList;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
		

	}

}
