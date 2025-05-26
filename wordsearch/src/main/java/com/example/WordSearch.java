package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Nayera Abdessalam
 * Fall 2024
 * CSC 210
 * Programming Assignment 9
 * WordSearch.java Part 2
 * 
 * This program creates a word search in an output file given a well-formed 
 * input file in the command line. The input file should have the dimensions 
 * of the word search grid on the first line ( columns x rows ), and then each word 
 * to be put in the word search on subsequent new lines. It then enters a 
 * read-eval-print loop in which the user can enter their found words using an x,y 
 * coordinate and an orientation direction. The loop will exit once all words have 
 * been found.
 */

public class WordSearch {
	
	// The main method takes the input file as an argument, parses the file elements, 
	// calls the generatewordsearch() method, and starts a new game with the PlayGame class.
    public static void main(String[] args) {

        // Get input and output file names
        String inputFileName = args[0];
        String outputFileName = "output_" + new File(inputFileName).getName();
        List<Word> wordList = new ArrayList<>();

        try {
            // Read the input file
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);

            // Read grid dimensions
            String[] dimensions = scanner.nextLine().split(" ");
            int cols = Integer.parseInt(dimensions[0]);
            int rows = Integer.parseInt(dimensions[1]);

            // Read words
            List<String> words = new ArrayList<>();
            while (scanner.hasNextLine()) {
            	String word = scanner.nextLine().trim().toUpperCase();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
            scanner.close();

            // Create the word search grid
            char[][] grid = generateWordSearchGrid(rows, cols, words, wordList);
            
            // Write to the output file
            FileWriter fileWriter = new FileWriter(outputFileName);
            for (char[] row : grid) {
                for (char c : row) {
                    fileWriter.write(c + " ");
                }
                fileWriter.write("\n");
            }
            // Write the word placement details so there's an answer key
            fileWriter.write("\nWord Placements:\n");
            for (Word word : wordList) {
                fileWriter.write(word.toString() + "\n");
            }
            fileWriter.close();
            
            PlayGame game = new PlayGame(grid, wordList);
            game.start();
            
        } catch (IOException e) {
            // Error handling
        	System.out.println("Error: " + e.getMessage());
        }
    }

    // This method creates the word search grid of characters with the given dimensions
    // first with placeholder characters, then the words in the word list, then the rest is filled
    // with random letters
    public static char[][] generateWordSearchGrid(int rows, int cols, List<String> words, List<Word> wordList) {
        char[][] grid = new char[rows][cols];
        Random random = new Random();

        // Initialize grid with empty characters
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = ' ';
            }
        }

        // Attempt to place each word in the grid
        for (String word : words) {
            boolean placed = false;

            for (int attempts = 0; attempts < 100 && !placed; attempts++) {
                int row = random.nextInt(rows);
                int col = random.nextInt(cols);
                int direction = random.nextInt(3); // 0 = horizontal, 1 = vertical, 2 = diagonal

                if (canPlaceWord(word, grid, row, col, direction)) {
                    placeWord(word, grid, row, col, direction);
                    String dirString = direction == 0 ? "H" : direction == 1 ? "V" : "D";
                    wordList.add(new Word(word, row, col, dirString));
                    placed = true;
                }
            }
        }
        
        fillRandom(grid, random);
        

        return grid;
    }
    
    private static void fillRandom(char[][] grid, Random random) {
    	for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = (char) ('A' + random.nextInt(26)); // Random A-Z
                }
            }
        }
    }
    
    // This method checks that the word can be placed at a certain location taking into consideration the other words
    // as well as the bounds of the grid.
    private static boolean canPlaceWord(String word, char[][] grid, int row, int col, int direction) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < word.length(); i++) {
            int r = row, c = col;

            switch (direction) {
                case 0: c += i; break; // Horizontal
                case 1: r += i; break; // Vertical
                case 2: r += i; c += i; break; // Diagonal
            }

            if (r < 0 || r >= rows || c < 0 || c >= cols) return false; // Out of bounds
            if (grid[r][c] != ' ' && grid[r][c] != word.charAt(i)) return false; // Conflict
        }
        return true;
    }
    // This method adds the word to the grid 
    private static void placeWord(String word, char[][] grid, int row, int col, int direction) {
        for (int i = 0; i < word.length(); i++) {
            switch (direction) {
                case 0: grid[row][col + i] = word.charAt(i); break; // Horizontal
                case 1: grid[row + i][col] = word.charAt(i); break; // Vertical
                case 2: grid[row + i][col + i] = word.charAt(i); break; // Diagonal
            }
        }
    }
}