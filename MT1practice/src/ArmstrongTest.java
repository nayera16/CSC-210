
public class ArmstrongTest {
	
	public static boolean armstrongTest(int n) {
		int firstDigit = n / 100;
		int secDigit = (n % 100) / 10;
		int thirdDigit = (n % 10);
		
		return cubed(firstDigit) + cubed(secDigit) + cubed(thirdDigit) == n;
	}
	
	public static int cubed(int n) {
		return n * n *n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(armstrongTest(152));

	}

}
