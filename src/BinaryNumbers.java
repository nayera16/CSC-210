import java.util.ArrayList;

public class BinaryNumbers {

	public static void main(String[] args) {
		ArrayList<String> solutions = new ArrayList<>();
		ArrayList<Integer> dicerollResult = new ArrayList<Integer>();
		getBinary(3, "");
		getDecimals(2, "0.", solutions);
		System.out.print(solutions);
		diceSum(2, dicerollResult, 7);

	}
	
	public static void getBinary(int bits, String solution) {
		if (bits == 0) System.out.println(solution);
		else { 
			getBinary(bits - 1, solution + "0");
			getBinary(bits - 1, solution + "1");
		}
		
	}
	
	public static void getDecimals(int n, String solution, ArrayList<String> allSol) {
		if (n == 0) System.out.println(solution);
		// have to add something here to add objs to array
		else {
			for (int i = 0; i <= 9; i++) {
				getDecimals(n - 1, solution + i, allSol);
			}	
		}
	}
	
	public static void diceSum(int numDice, ArrayList<Integer> solution, int targetSum) {
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		
		if (numDice == 0) {
			if (sumDice(solution) == targetSum) {
				System.out.println(solution);
			}
		}

		else {
			for (int i = 1; i <= 6; i++) {
				solution.add(i);
				diceSum(numDice - 1, solution, targetSum);
				solution.remove(solution.size() - 1);
			}
		}
	}
	
	public static int sumDice(ArrayList<Integer> allDice) {
		int sum = 0;
		for (int d : allDice) sum += d;
		return sum;
	}

}
