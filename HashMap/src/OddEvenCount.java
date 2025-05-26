import java.util.HashMap;

public class OddEvenCount {
	
	public static HashMap<String, Integer> countNumbers(String[] numbers) {
		HashMap<String, Integer> counts = new HashMap <String, Integer>();
		int oddCount = 0;
		int evenCount = 0;
		
		counts.put("Even", evenCount);
		counts.put("Odd", oddCount);
		
		for (String s : numbers) {
			int n = Integer.valueOf(s);
			if (n % 2 == 0) counts.put("Even", counts.get("Even") + 1);
			else counts.put("Odd", counts.get("Odd") + 1);
		}
		
		return counts;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
