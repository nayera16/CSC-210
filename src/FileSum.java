// package com.gradescope.filesum;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class FileSum {


	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner keyboardScanner = new Scanner(System.in);

		
		System.out.print("Enter file name: ");
		
		String fileName = keyboardScanner.nextLine();
		
		File myFile = new File(fileName);
		Scanner myReader = new Scanner(myFile);
		
		int sum = 0;
		while(myReader.hasNextInt()) {
	
			sum += myReader.nextInt();
		}
		
		System.out.print(sum);
		
		keyboardScanner.close();	
	}

}

