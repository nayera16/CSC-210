// package com.gradescope.medalinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MedalInfo {
	
	public static HashMap<String, Integer> getMedalCount(String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		HashMap <String, Integer> medalCounts = new HashMap<>();
		
		File myFile = new File(fileName);
		Scanner reader = new Scanner(myFile);
		reader.nextLine();
		
		while (reader.hasNext()) {
			String line = reader.nextLine();
			String[] data = line.split(",");
			String country = data[6];
			if (medalCounts.get(country) == null) {
				medalCounts.put(country, 0);
			}
			medalCounts.put(country, medalCounts.get(country) + 1);
		}
		
		reader.close();
		return medalCounts;
	}
	
	public static String getCountry(HashMap<String, Integer> medalCounts, String country) {
		// TODO Auto-generated method stub
		if (medalCounts.get(country) == null) {
			return "No country found";
		}
		
		else {
			Integer medals = medalCounts.get(country);
			if (medalCounts.get(country) == 1) {
				return country + " had a total of " + medals + " medal.";
			}
			return country + " had a total of " + medals + " medals.";
		}
	}


	public static String getMin(HashMap<String, Integer> medalCounts) {
		// TODO Auto-generated method stub
		String minCountry = null;
		int minMedals = Integer.MAX_VALUE;
		
		for (String key : medalCounts.keySet()) {
			if (medalCounts.get(key) < minMedals) {
				minMedals = medalCounts.get(key);
				minCountry = key;
			}
		}
		return minCountry + " had the fewest medals with a total of " + minMedals + " medal.";
		
	}


	public static String getMax(HashMap<String, Integer> medalCounts) {
		// TODO Auto-generated method stub
		
		String maxCountry = null;
		int maxMedals = 0;
		
		for (String key : medalCounts.keySet()) {
			if (medalCounts.get(key) > maxMedals) {
				maxMedals = medalCounts.get(key);
				maxCountry = key;
			}
		}
		return maxCountry + " had the most medals with a total of " + maxMedals + " medals.";
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> countryCount = getMedalCount("../medallists.csv");
        
        if (args[0].equals("MAX")) {
            System.out.println(getMax(countryCount));
        }
        
        if (args[0].equals("MIN")) {
            System.out.println(getMin(countryCount));
        }
        
        if (args[0].equals("COUNTRY")) {
            System.out.println(getCountry(countryCount, args[1]));
        }

	}


	

	

}
