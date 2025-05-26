// package com.gradescope.airportinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/*
 * The file header should include instructions on how someone would use this program. 
 * To use the program, one would need to know the input file format.
 * 
 * This program is designed to organize and access flight information for a .csv file.
 * The input file should have data for the following in this order: airline,airline ID, 
 * source airport, source airport id, destination airport, destination airport id, codeshare, 
 * stops, equipment. 
 * 
 * This program will return the airports with the maximum departing and incoming flights, 
 * a list of each airports destinations, and the airports with a certain minimum number
 * of flights when specified.
 * 
 * 
 */

public class AirportInfo {

	public static HashMap<String, Integer> getAirportCount(String fileName) throws FileNotFoundException {
		// create a HashMap to keep track of the airport flight count 
		HashMap <String, Integer> airportCount = new HashMap<>();
		
		// read lines in file
		File myFile = new File(fileName);
		Scanner reader = new Scanner(myFile);
		reader.nextLine();
		
		// iterate over all lines in file in order to count the flights for an airport 
		// including source and destination
		while (reader.hasNext()) {
			String line = reader.nextLine();
			String [] data = line.split(",");
			String airport = data[2];
			String destination = data[4];
			if (airportCount.get(airport) == null) {
				airportCount.put(airport, 1);
			}
			else {
				airportCount.put(airport, airportCount.get(airport) + 1);
			}
			
			if (airportCount.get(destination) == null) {
				airportCount.put(destination, 1);
			}
			else {
				airportCount.put(destination, airportCount.get(destination) + 1);
			}
		}
		
		reader.close();
		
		return airportCount;
	}

	public static HashMap<String, String> getDestinations(String fileName) throws FileNotFoundException {
		// create HashMap to keep track of each airports destination list
		HashMap <String, String> destinationMap = new HashMap<>();
		
		// read lines in file
		File myFile = new File(fileName);
		Scanner reader = new Scanner(myFile);
		reader.nextLine();
		
		// iterate over all lines in file to concatenate the destinations of the same airport
		// to a single string
		while (reader.hasNext()) {
			String line = reader.nextLine();
			String [] data = line.split(",");
			String airport = data[2];
		
			if (destinationMap.get(airport) == null) {
				destinationMap.put(airport, "");
			}
			destinationMap.put(airport, destinationMap.get(airport) + data[4] + " ");
	
		}
		
		reader.close();
		
		// output all airports with the string of all their destinations
		
		return destinationMap;
	}
	
	public static String getMax(HashMap<String, Integer> airportCount) {
		// create ArrayList so the airports can be sorted into alphabetical order
		// determine the airport(s) with the maximum flight count
		int maxFlights = Collections.max(airportCount.values());
        ArrayList<String> maxAirports = new ArrayList<>();
        
        for (String airport : airportCount.keySet()) {
            if (airportCount.get(airport) == maxFlights) {
                maxAirports.add(airport);
            }
        }
        
        Collections.sort(maxAirports);
        
        // add all airports with the max flight count to a string 
        String airportList = "";
        for (String airport : maxAirports) {
        	 airportList += airport + " ";
        }
		
        // output the max flight number with the airports that have the max flight count
		return "MAX FLIGHTS " + maxFlights + " : " + airportList;
	}
	
	public static String getDepartures(HashMap<String, String> destinations) {
		// create ArrayList so the airports can be sorted into alphabetical order 
		ArrayList<String> sortedAirports = new ArrayList<>(destinations.keySet());
        Collections.sort(sortedAirports);
        String allDepartures = "";
        
        // add all airports with all their corresponding destinations to a single string with formatting
        for (String airport : sortedAirports) {
   
        	allDepartures += airport + " flies to " + destinations.get(airport).trim() + "\n";
        }
		
		return allDepartures;
	}
	
	public static String getLimits(int limitVal, HashMap<String, Integer> airportCount) {
		// create ArrayList so the airports can be sorted into alphabetical order
		ArrayList<String> limitAirports = new ArrayList<>();
		
		// iterate through all airportCounts to find those that exceed the limitVal
		// add these airports to the ArrayList
		for (String airport : airportCount.keySet()) {
			if (airportCount.get(airport) > limitVal) {
				limitAirports.add(airport + " - " + airportCount.get(airport));
			}
		}
		
		// sort ArrayList and output all items in the array as a string
		Collections.sort(limitAirports);
		String finalString = "";
		
		
		for (String airport : limitAirports) {
			finalString += airport + "\n";
		}
		
		return finalString;
	}

	
	public static void main(String[] args) throws FileNotFoundException {
        
        HashMap<String, String> destinations = getDestinations(args[0]);
        HashMap<String, Integer> airportCount = getAirportCount(args[0]);
        
        
        if (args[1].equals("MAX")) {
            System.out.println(getMax(airportCount));
        }
        
        if (args[1].equals("DEPARTURES")) {
            System.out.println(getDepartures(destinations));
        }
        
        if (args[1].equals("LIMIT")) {
            System.out.println(getLimits(Integer.valueOf(args[2]), airportCount));
        }
        
    
    }

	
	

	

	

}
