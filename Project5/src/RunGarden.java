//package com.gradescope.garden;
import java.io.*;
import java.util.Scanner;

public class RunGarden {
	/*
	 * takes a well-formed input file with garden commands and executes commands
	 * line by line. takes plant, grow, pick, harvest, and cut commands and handles 
	 * them according to the rest of the input (coordinates, type, name)
	 * 
	 */
    public static void main(String[] args) throws FileNotFoundException {
       
        String inputFile = args[0];
        Scanner scanner = new Scanner(new File(inputFile));
        
        // read garden dimensions
        int rows = 0, cols = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.startsWith("rows:")) {
                rows = Integer.parseInt(line.split(":")[1].trim());
            } else if (line.startsWith("cols:")) {
                cols = Integer.parseInt(line.split(":")[1].trim());
                // handles error for too many columns
                if (cols > 16) { 
                	System.out.println("Too many plot columns.");
                	scanner.close();
                	return; // stops reading the rest of the lines in file
                }
            } else {
                break; // continues reading the other command lines in file
            }
        }

        // creates the Garden object
        Garden garden = new Garden(rows, cols);

        // process all commands in file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            processCommand(line, garden);
        }

        scanner.close();
    }

       

    private static void processCommand(String line, Garden garden) {
    	// splits line into parts by space character to separate out the command
    	String[] parts = line.split("\\s+");
    	String command = (parts[0]).toUpperCase(); // command is always printed uppercase
    	String newLine = command;
    	
    	// reformats the new output line to be printed with the uppercase command
    	for (int i = 1; i < parts.length; i++) {
    		newLine += " " + parts[i]; 
    	}
    	
    	// calls appropriate method to execute each command
    	if (line.equalsIgnoreCase("print")) {
    		System.out.println("> PRINT");
    		garden.print();
    		System.out.println();
        } else if (command.equals("PLANT")) {
            handlePlantCommand(line, garden);
        } else if (command.equals("GROW")) {
        	System.out.println("> " + newLine + "\n");
            handleGrowCommand(line, garden);
        } else if (command.equalsIgnoreCase("HARVEST")) {
        	System.out.println("> " + newLine + "\n");
            handleHarvestCommand(line, garden);
        } else if (command.equalsIgnoreCase("PICK")) {
        	System.out.println("> " + newLine + "\n");
            handlePickCommand(line, garden);
        } else if (command.equalsIgnoreCase("CUT")) {
        	System.out.println("> " + newLine + "\n");
            handleCutCommand(line, garden);
        } 
    }

    private static void handlePlantCommand(String line, Garden garden) {
        // for all plant commands
 
        String[] parts = line.split("\\s+");
        String[] coordinates = parts[1].replace("(", "").replace(")", "").split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        String plantType = parts[2];

        garden.plant(x, y, plantType);
       
    }

    private static void handleGrowCommand(String line, Garden garden) {
        // for all grow commands
        String[] parts = line.split("\\s+");

            int num = Integer.parseInt(parts[1]);

            if (parts.length == 2) {
                // GROW num (for all plants)
                garden.grow(num);
            } else if (parts[2].startsWith("(")) {
                // GROW num (x, y)
                String[] coordinates = parts[2].replace("(", "").replace(")", "").split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                garden.grow(num, x, y);
            } else {
            	String arg = parts[2].toLowerCase();
                if (arg.equals("flower") || arg.equals("tree") || arg.equals("vegetable")|| arg.equals("herb")) {
                	garden.growPlant(num, arg);
                }
                
                garden.grow(num, arg);
            }
    }

    private static void handleHarvestCommand(String line, Garden garden) {
        // for all harvest commands
        String[] parts = line.split("\\s+");

        if (parts.length == 1) {
            // HARVEST all vegetables
            garden.harvest();
        } else if (parts[1].startsWith("(")) {
            // HARVEST (x, y)
            try {
                String[] coordinates = parts[1].replace("(", "").replace(")", "").split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                garden.harvest(x, y);
            } catch (Exception e) {
                System.out.println("Invalid HARVEST command: " + line);
            }
        } else {
            // HARVEST type
            String type = parts[1];
            garden.harvest(type);
        }
    }

    private static void handlePickCommand(String line, Garden garden) {
        // for all pick commands
        String[] parts = line.split("\\s+");

        if (parts.length == 1) {
            // PICK all flowers
            garden.pick();
        } else if (parts[1].startsWith("(")) {
            // PICK (x, y)
            try {
                String[] coordinates = parts[1].replace("(", "").replace(")", "").split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                garden.pick(x, y);
            } catch (Exception e) {
                System.out.println("Invalid PICK command: " + line);
            }
        } else {
            // PICK type
            String type = parts[1];
            garden.pick(type);
        }
    }

    private static void handleCutCommand(String line, Garden garden) {
        // for all cut commands
        String[] parts = line.split("\\s+");

        if (parts.length == 1) {
            // CUT all trees
            garden.cut();
        } else if (parts[1].startsWith("(")) {
            // CUT (x, y)
            try {
                String[] coordinates = parts[1].replace("(", "").replace(")", "").split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                garden.cut(x, y);
            } catch (Exception e) {
                System.out.println("Invalid CUT command: " + line);
            }
        } else {
            // CUT type
            String type = parts[1];
            garden.cut(type);
        }
    }
    
    
}
