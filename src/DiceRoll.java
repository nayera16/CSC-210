import java.util.ArrayList;

public class DiceRoll {
	
	public static void diceSum(int numDice, ArrayList<Integer> solution, int targetSum,
								ArrayList<ArrayList<Integer>> myResults) {
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		
		if (numDice == 0) {
			if (sumDice(solution) == targetSum) {
				ArrayList<Integer> myCopy = new ArrayList<Integer>(solution);
				myResults.add(myCopy);
				}
		}
		
		else if (sumDice(solution) + 1 * numDice > targetSum || sumDice(solution) + 6 * numDice < targetSum) {
			return;
		}

		else {
			for (int i = 1; i <= 6; i++) {
				solution.add(i);
				diceSum(numDice - 1, solution, targetSum, myResults);
				solution.remove(solution.size() - 1);
			}
		}
	}
	
	public static int sumDice(ArrayList<Integer> allDice) {
		int sum = 0;
		for (int d : allDice) sum += d;
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> allResults = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> dicerollResult = new ArrayList<Integer>();
		diceSum(3, dicerollResult, 5, allResults);
	}

}
