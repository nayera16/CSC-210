package com.example;

/*
 * TODO: Write a file header!
 */
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App extends Application {

    // variables that will be read in from file
    private static double delay = 2;

    // constants for the program
    private final static int TEXT_SIZE = 120;
    private final static int CELLSIZE = 20;
    private static int numRows;
    private static int numCols;

    private Garden garden;
    private Scanner scanner;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        TextArea command = new TextArea();
        GraphicsContext gc = setupStage(primaryStage, numCols * CELLSIZE, numRows * CELLSIZE, command);

        // Initialize garden with the number of rows and columns
        garden = new Garden(numRows, numCols);
        
        primaryStage.show();
        simulateGarden(gc, command);
    }

    /**
     * TODO: Rewrite this method. Take out the given placeholder code
     * (and comments), implement the provided pseudocode
     * 
     * @param gc
     *            GraphicsContext for drawing garden to.
     * @param command
     *            Reference to text area to show simulation commands.
     */

    
    private void simulateGarden(GraphicsContext gc, TextArea command) throws FileNotFoundException {
        // Initialize Scanner to read from Garden.in
        Scanner scanner = new Scanner(new File("Garden.in"));
        

        final int NUM_STEPS = 10;
        Counter countref = new Counter(NUM_STEPS);

        PauseTransition wait = new PauseTransition(Duration.seconds(delay));
        wait.setOnFinished((e) -> {
            if (countref.count > 0 && scanner != null && scanner.hasNextLine()) {
                String cmd = scanner.nextLine();
                processCommand(cmd, gc, command);
                command.appendText(cmd + "\n");
                countref.count--;  // Decrement the counter after processing each command
                wait.playFromStart();
            } else {
                // Stop the simulation when the counter reaches zero or there are no commands left
                if (scanner != null) {
                    scanner.close();
                }
                wait.stop();
            }
        });
        // Now that the PauseTransition thread is setup, get it going.
        wait.play();
    }

    private void processCommand(String cmd, GraphicsContext gc, TextArea command) {
        String[] parts = cmd.split(" ");
        if (parts.length == 0) return;

        switch (parts[0].toLowerCase()) {
            case "plant":
                if (parts.length == 4) {
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    String type = parts[3];
                    garden.plant(x, y, type);
                }
                break;
            case "grow":
                if (parts.length == 2) {
                    int amount = Integer.parseInt(parts[1]);
                    garden.grow(amount);
                } else if (parts.length == 4) {
                    int amount = Integer.parseInt(parts[1]);
                    int x = Integer.parseInt(parts[2]);
                    int y = Integer.parseInt(parts[3]);
                    garden.grow(amount, x, y);
                }
                break;
            case "harvest":
                garden.harvest();
                break;
            case "pick":
                garden.pick();
                break;
            case "cut":
                garden.cut();
                break;
            default:
                command.appendText("Unknown command: " + cmd + "\n");
        }

        drawGarden(gc);
    }

    private void drawGarden(GraphicsContext gc) {
        gc.clearRect(0, 0, numCols * CELLSIZE, numRows * CELLSIZE);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Plant plot = Plant.getRepresentation();
                if (plot != null) {
                    gc.setFill(plant.getColor());
                    gc.fillRect(j * CELLSIZE, i * CELLSIZE, CELLSIZE, CELLSIZE);
                }
            }
        }
    }

    public GraphicsContext setupStage(Stage primaryStage, int canvas_width, int canvas_height, TextArea command) {
        BorderPane p = new BorderPane();
        Canvas canvas = new Canvas(canvas_width, canvas_height);

        command.setPrefHeight(TEXT_SIZE);
        command.setEditable(false);

        p.setCenter(canvas);
        p.setBottom(command);

        primaryStage.setTitle("Garden Simulator");
        primaryStage.setScene(new Scene(p));

        return canvas.getGraphicsContext2D();
    }
}
