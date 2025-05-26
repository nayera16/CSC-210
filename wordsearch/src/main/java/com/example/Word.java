package com.example;
public class Word {
	/*
	 * This class handles the variables for each word and has the necessary
	 * getters and setters for each of those variables. This allows there to be a
	 * much simpler List of Word types in WordSearch.java and PlayGame.java.
	 * 
	 */
	private String text;
    private int startRow;
    private int startCol;
    private String direction; // "H", "V", or "D"
    private boolean found;

    public Word(String text, int startRow, int startCol, String direction) {
        this.text = text;
        this.startRow = startRow;
        this.startCol = startCol;
        this.direction = direction;
        this.found = false;
    }

    public String getText() {
        return text;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    @Override
    public String toString() {
        return text + " (" + startRow + ", " + startCol + ", " + direction + ")";
    }
}
