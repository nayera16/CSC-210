package com.example;

import java.util.List;

public class ParseResult {
    private final int rows;
    private final int cols;
    private final List<String> wordList;

    public ParseResult(int rows, int cols, List<String> wordList) {
        this.rows = rows;
        this.cols = cols;
        this.wordList = wordList;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<String> getWordList() {
        return wordList;
    }
}
