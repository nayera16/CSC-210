package bool_exp;
//package com.gradescope.bool_exp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BoolSat {
	/*
	 * The input for this program is a text file containing a well formed
	 * NAND expression. The program only considers the first line of the file and
	 * it can only contain the NAND operator, strings with no spaces that start with
	 * exactly one letter, or "$", or "_" and is followed by any number of letters, 
	 * digits, "$", or "_". The program evaluates every possible combination of boolean
	 * values for the expression in the file. If the command line input contains the DEBUG
	 * argument, all the configurations are printed out followed by the evaluated result
	 * for the configuration. If DEBUG is not an argument, only the configurations that
	 * evaluate to true are printed. 
	 * 
	 */
	
	public static String getOuput(ASTNode root, boolean debug) {
		// builds and formats the strings for each output and adds them to an 
		// ArrayList of HashMaps containing all variable value combinations.
		
		HashMap<String, Boolean> variableMap = new HashMap<>();
		getVariables(root, variableMap);
		
		ArrayList<String> varList = new ArrayList<>(variableMap.keySet());
		Collections.sort(varList);
		
		ArrayList<HashMap<String, Boolean>> allCombinations = getCombinations(varList);
		
		ArrayList<String> results = new ArrayList<>();
		boolean SAT = false;
		
		for (HashMap<String, Boolean> combination : allCombinations) {
			boolean evalResult = evaluateNandExpression(root, combination);
			
			// Generate strings for the current combination
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < varList.size(); i++) {
				String var = varList.get(i);
				result.append(var).append(": ").append(combination.get(var));
				if (i < varList.size() - 1) {
					result.append(", ");
				}
			}
			if (debug) {
				result.append(", ").append(evalResult);
			}
			else if(evalResult) {
				SAT = true;
			}
			
			if (debug || evalResult) {
				results.add(result.toString());
			}
			
		}
		
		// StringBuilder to format each line corresponding to each variable combination
		StringBuilder output = new StringBuilder();
		
		
		if (!debug && !SAT)	{
			output.append("UNSAT\n");
		}
		else {
			output.append("SAT\n");
		}
		
		Collections.sort(results); // sorts the lines 
		
		for(String r : results) {
			output.append(r).append("\n");
		}
		
		return output.toString();
		
	
	}


	private static void getVariables(ASTNode node, HashMap<String, Boolean> variableMap) {
		// gets all variable names in the tree
		
		if(node.isId()) {
			variableMap.put(node.getId(), false);
		}
		else if(node.isNand()) {
			if (node.child1 != null) {
				getVariables(node.child1, variableMap);	
			}
			if (node.child2 != null) {
				getVariables(node.child2, variableMap);
			}
		}
		
	}

	public static ArrayList<HashMap<String, Boolean>> getCombinations(ArrayList<String> vars) {
		// adds all combinations to the HashMap
		ArrayList<HashMap<String, Boolean>> combinations = new ArrayList<>();
		int numVars = vars.size();
		int totalCombinations = (int) Math.pow(2, numVars);
		
		for (int i = 0; i < totalCombinations; i++) {
			HashMap<String, Boolean> combo = new HashMap<>();
			for (int j = 0; j < numVars; j++) {
				combo.put(vars.get(j), (i & (1 << j)) != 0);
			}
			combinations.add(combo);
		}
		
		return combinations;
	}
	
	
	private static boolean evaluateNandExpression(ASTNode node, HashMap<String, Boolean> values) {
		// recursive method to evaluate the NAND expression for each combination
		if(node.isId()) {
			return values.get(node.getId());
		}
		else if (node.isNand()) {
			boolean left = evaluateNandExpression(node.child1, values); // recursive call for each child
			boolean right = evaluateNandExpression(node.child2, values); // recursive call for each child
			
			// evaluate NAND operator
			return !(left && right); 
		}
		return false;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
        if(args.length < 1 || args.length > 2){
            System.err.println(
                    "USAGE: java BoolSat <inputFile.txt> <DEBUG*>");
            System.exit(1);
        }

        // Get the expression from the file
        String expression = null;
        Scanner s = new Scanner(new File(args[0]));
        expression = s.nextLine();

        System.out.println("input: " + expression);
        
        s.close();

        // call the parser to generate the AST for the expression
        ASTNode root = BoolSatParser.parse(expression);
        
        // get string output to print out
        String output;
        if (args.length == 2 && args[1].equals("DEBUG")) {
            output = getOuput(root, true);
        } else {
            output = getOuput(root, false);
        }
        
        // print output string
        System.out.println(output);
        
    }

	


}
