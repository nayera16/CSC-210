import java.util.ArrayList;

public class FizzBuzzArray {
	
	public static ArrayList<String> fizzBuzz(int k){
		ArrayList<String> result = new ArrayList<String>();
	
		for (int i = 0; i <= k; i++) {
			String word = "";
			if (i % 3 == 0) word += "Fizz";
			if (i % 5 == 0) word += "Buzz";
			if (word.length() == 0) word += i;
			result.add(word);
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fizzBuzz(15));
	}

}
