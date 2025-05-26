// package com.gradescope.lab03;
import java.util.ArrayList;
public class Lab3Binary {
	
	public static void binary(int n, String solution, ArrayList<String> allSols) {
		if (n == 0) {
			allSols.add(solution);
			return;
		}
		
		binary(n-1, solution + "0", allSols);
		binary(n-1, solution + "1", allSols);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		ArrayList<String> allSolutions = new ArrayList<String>();
        binary(3, "", allSolutions);
        System.out.println(allSolutions);
	}

}
