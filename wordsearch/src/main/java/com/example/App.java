package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * JavaFX App
 * Nayera Abdessalam
 * Fall 2024
 * Project 10- WordSearch GUI implementation
 */

public class App extends Application {

    private static Scene scene;
    private TextArea gridDisplay;
    private TextField userInputField;
    private char[][] grid;
    private PlayGame playGame;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane myPanel = new BorderPane();
        stage.setTitle("Nayera's Word Search game");

        // Prompt for input file using a FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Word Search File");
        File inputFile = fileChooser.showOpenDialog(stage);

        if (inputFile == null) {
            Text errorText = new Text("No file selected. Please restart the application.");
            myPanel.setCenter(errorText);
        } else {
            try {
                // Parse the input file
                ParseResult result = PlayGame.parseFile(inputFile.getAbsolutePath());

                // Generate the grid using the WordSearch method
                List<Word> wordList = new ArrayList<>();
                grid = WordSearch.generateWordSearchGrid(result.getRows(), result.getCols(), result.getWordList(), wordList);

                // Initialize PlayGame
                playGame = new PlayGame(grid, wordList);

                // Create UI elements
                gridDisplay = new TextArea(playGame.getGridAsString());
                gridDisplay.setEditable(false);
                gridDisplay.setStyle("-fx-font-family: monospace; -fx-font-size: 14px;");

                userInputField = new TextField();
                userInputField.setPromptText("Enter word, x, y, direction (e.g., apple, 0, 1, h)");

                // Handle user input
                userInputField.setOnAction(event -> handleUserGuess());

                // Add elements to panel
                myPanel.setCenter(gridDisplay);
                myPanel.setBottom(userInputField);

            } catch (IOException e) {
                Text errorText = new Text("Error processing the file: " + e.getMessage());
                myPanel.setCenter(errorText);
            }
        }

        // set stage
        scene = new Scene(myPanel, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void handleUserGuess() {
        String input = userInputField.getText().trim();
        String[] parts = input.split(",");
        if (parts.length != 4) {
            userInputField.setText("Invalid input format! Try: word, x, y, direction");
            return;
        }

        try {
            String word = parts[0].trim().toUpperCase();
            int row = Integer.parseInt(parts[1].trim());
            char colChar = parts[2].trim().toUpperCase().charAt(0);
            int col = colChar - 'A';
            String direction = parts[3].trim().toUpperCase();

            // Check the word guess
            if (playGame.verifyWord(word, row, col, direction)) {
                playGame.removeWordFromGrid(word);
                gridDisplay.setText(playGame.getGridAsString());
                if (playGame.allWordsFound()) {
                    userInputField.setText("All words found! You win!");
                    userInputField.setEditable(false);
                }
            } else {
                userInputField.setText("Word not found! Try again.");
            }
        } catch (Exception e) {
            userInputField.setText("Error: " + e.getMessage());
        }
    }

    

}