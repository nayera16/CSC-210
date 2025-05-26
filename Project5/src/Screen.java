//package com.gradescope.garden;
public class Screen {
	/*
	 * this class creates the actual printed out representation for each plot of 
	 * the garden. each plot is represented by a 5x5 grid of '.' characters. these
	 * plots are updated based on the grow, pick, cut, and harvest commands. 
	 */
	private int rows;
    private int cols;
    private char[][] plots;

    public Screen(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.plots = new char[rows * 5][cols * 5]; // each plot is 5x5

        clearScreen(); // initialize with empty grid
    }
    
    public void clearScreen() {
        for (int i = 0; i < rows * 5; i++) {
            for (int j = 0; j < cols * 5; j++) {
                plots[i][j] = '.';
            }
        }
    }

    public void updateScreen(Plant plant, int x, int y) {
    	// updates a plot when a command is called
        char[][] plantRep = plant.getRepresentation();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                plots[x * 5 + i][y * 5 + j] = plantRep[i][j];
            }
        }
    }
    
    public void printScreen() {
    	// prints all garden plots
        for (int i = 0; i < rows * 5; i++) {
            for (int j = 0; j < cols * 5; j++) {
                System.out.print(plots[i][j]);
            }
            System.out.println();
        }
    }
    
}
