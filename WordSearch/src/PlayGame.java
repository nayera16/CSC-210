//package com.gradescope.wordsearch;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
	
	/*
	 * This class handles the REPL for the user game play. This includes the command
	 * line prompts, checking if the correct input was entered for a word, removing the 
	 * necessary words from the grid, and printing the grid 
	 */
	
	private char[][] grid;
    private List<Word> words;

    public PlayGame(char[][] grid, List<Word> words) {
        this.grid = grid;
        this.words = words;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (!allWordsFound()) {
        	
            printGrid();
            
            // read loop that gives prompts and takes user input
            System.out.print("Enter word found: ");
            String wordInput = scanner.nextLine().trim().toUpperCase();

            System.out.print("Enter x: ");
            int row = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter y: ");
            char colChar = scanner.nextLine().trim().toUpperCase().charAt(0);
            int col = colChar - 'A';

            System.out.print("[H]orizontal [V]ertical [D]iagonal? ");
            String direction = scanner.nextLine().trim().toUpperCase();
            
            // eval loop that checks for the input word in the grid
            if (verifyWord(wordInput, row, col, direction)) {
                System.out.println("\n" + wordInput + " removed\n");
                removeWordFromGrid(wordInput);
            } else {
                System.out.println("Word not found.");
            }
        }

        System.out.println("All words found!");
        scanner.close();
    }

    private boolean verifyWord(String wordInput, int row, int col, String direction) {
        for (Word word : words) {
            if (!word.isFound() &&
                word.getText().equals(wordInput) &&
                word.getStartRow() == row &&
                word.getStartCol() == col &&
                word.getDirection().equals(direction)) {
                word.setFound(true);
                return true;
            }
        }
        return false;
    }

    private void removeWordFromGrid(String wordInput) {
        for (Word word : words) {
            if (word.getText().equals(wordInput) && word.isFound()) {
                int row = word.getStartRow();
                int col = word.getStartCol();
                for (int i = 0; i < wordInput.length(); i++) {
                    switch (word.getDirection()) {
                        case "H":
                            grid[row][col + i] = '*';
                            break;
                        case "V":
                            grid[row + i][col] = '*';
                            break;
                        case "D":
                            grid[row + i][col + i] = '*';
                            break;
                    }
                }
                break;
            }
        }
    }

    private boolean allWordsFound() {
        for (Word word : words) {
       
            if (!word.isFound()) {
                return false;
            }
        }
        return true;
    }

    private void printGrid() {
        System.out.print("   ");
        for (int i = 0; i < grid[0].length; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.printf("%02d ", i);
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
