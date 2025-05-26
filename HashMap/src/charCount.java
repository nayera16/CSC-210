import java.util.HashMap;

public class charCount {
	
	public static HashMap<Character, Integer> toHashMap(String word) {
		HashMap<Character, Integer> letterVals = new HashMap <Character, Integer>();
		
		for (int i = 0; i < word.length(); i++) {
			char key = word.charAt(i);
			
			Integer current = letterVals.get(key);
			
			if (current == null) current = 0;
			letterVals.put(key, current + 1);
		}
		
		return letterVals;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toHashMap("nayera abdessalam"));
	}

}
