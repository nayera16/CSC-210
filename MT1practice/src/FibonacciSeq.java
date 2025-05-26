import java.util.ArrayList;

public class FibonacciSeq {
	public static ArrayList<Integer> fibonacci(int k){
		ArrayList<Integer> result = new ArrayList<>();
		
		result.add(1);
		result.add(1);
		
		for (int i = 1; i < k-1; i++) {
			int term = result.get(i) + result.get(i-1);
			result.add(term);
		}
		
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(8));

	}

}
