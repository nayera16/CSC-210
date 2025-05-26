// package com.gradescope.gradenator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * The Gradenator class calculates the average grade for multiple
 * categories as well as the total grade based on the weight percentage
 * for each category.
 * It takes a file as input that should be formatted specifically
 * for this program.
 */




public class Gradenator {

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner keyboardScanner = new Scanner(System.in);
		
		System.out.println("File name?");
		
		
		String fileName = keyboardScanner.nextLine();
		
		File myFile = new File(fileName);
		Scanner fileReader = new Scanner(myFile);
		
		double gradeTotal = 0.0;
		double weightTotal = 0.0;
		
		
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			
			//split line by semicolon 
			String[] lineParts = line.split(";");
			
			//string for the grade category name
			String category = lineParts[1].trim();
			
			//array for each category's grade average
			String[] grades = lineParts[0].trim().split("\\s+");
			double gradeSum = 0;
			int gradeNum = grades.length;
			
			for (String score : grades) {
				gradeSum += Double.parseDouble(score);
			}
			
			double gradeAvg = gradeSum / gradeNum;
			
			//calculating the grade with its weight
			
			String strWeight = lineParts[2].trim().replace("%", "");
			double weight = Double.parseDouble(strWeight);
			
			
			//print each grade category's result
			
			System.out.print(category + "; ");
			System.out.format("%.1f%%; ", weight);
			System.out.format("avg=%.1f%n", gradeAvg);
			
			double weightPercent = weight/100;
			
			//calculate totals
			gradeTotal += gradeAvg * weightPercent;
			weightTotal += weight;
			
		}
		
		System.out.format("TOTAL = %.1f%% ", gradeTotal);
		System.out.format("out of %.1f%%", weightTotal);
		
		
		keyboardScanner.close();
		fileReader.close();
		
	}

}