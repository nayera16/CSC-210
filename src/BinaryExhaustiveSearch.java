
public class BinaryExhaustiveSearch {
	
	public static String binaryNums(int numDigits, String number) {
		String num = "";
		if (numDigits == 0) System.out.println(number);
		else {
			binaryNums(numDigits - 1, number + "0");
			binaryNums(numDigits - 1, number + "1");
		}
		
		
		
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryNums(5,"");
	}

}
