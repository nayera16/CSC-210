// package com.gradescope.lab03;
import java.util.ArrayList;

public class Lab3Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> allSolutions = new ArrayList<String>();
        String solution = "";
        roll(2, solution, allSolutions);
        System.out.println(allSolutions);
	}

	public static void roll(int numDice, String solution, ArrayList<String> allSols) {
		if (numDice == 0) {
			allSols.add(solution);
			return;
		}
		for (int i = 1; i <= 6; i++) {
			roll(numDice-1, solution + i, allSols);
		}
		
	}

}
