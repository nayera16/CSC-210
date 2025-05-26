package com.paint;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 * Fall 2024
 * Nayera Abdessalam's Paint App
 */
public class App extends Application {
    private static Scene scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Nayera's paint app");

        // set up the canvas
        Group root = new Group();
        
        Brush brush = new Brush();
        
        // drawing area
        
        BorderPane myPanel = new BorderPane();
        

        // grid layout for buttons
        GridPane myGrid = new GridPane();
        myGrid.setPadding(new Insets(10, 10, 10, 10));
        
        myPanel.setCenter(root);

        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 0, 0);
        myGrid.getChildren().add(clear);
        clear.setOnAction((actionEvent) -> {
            root.getChildren().clear();
            root.getChildren().add(clear);
        }); 

        Button plus = new Button("+");
        GridPane.setConstraints(plus, 1, 0);
        myGrid.getChildren().add(plus); 
        plus.setOnAction(e -> brush.increaseSize());

        Button minus = new Button("-");
        GridPane.setConstraints(minus, 2, 0);
        myGrid.getChildren().add(minus);
        minus.setOnAction(e -> brush.decreaseSize());

        Button colorOrange = new Button();
        colorOrange.setStyle("-fx-background-color: orange");
        GridPane.setConstraints(colorOrange, 3, 0);
        myGrid.getChildren().add(colorOrange);
        colorOrange.setOnAction(e -> brush.setColor(Color.ORANGE));

        Button colorBlue = new Button();
        colorBlue.setStyle("-fx-background-color: blue");
        GridPane.setConstraints(colorBlue, 4, 0);
        myGrid.getChildren().add(colorBlue);
        colorBlue.setOnAction(e -> brush.setColor(Color.BLUE));

        Button colorGreen = new Button();
        colorGreen.setStyle("-fx-background-color: green");
        GridPane.setConstraints(colorGreen, 5, 0);
        myGrid.getChildren().add(colorGreen);
        colorGreen.setOnAction(e -> brush.setColor(Color.GREEN));

        Button shapeCircle = new Button("Circle");
        GridPane.setConstraints(shapeCircle, 6, 0);
        myGrid.getChildren().add(shapeCircle);
        shapeCircle.setOnAction(e -> brush.setShape("CIRCLE"));

        Button shapeSquare = new Button("Square");
        GridPane.setConstraints(shapeSquare, 7, 0);
        myGrid.getChildren().add(shapeSquare);
        shapeSquare.setOnAction(e -> brush.setShape("RECTANGLE"));

        Button shapeTriangle = new Button("Triangle");
        GridPane.setConstraints(shapeTriangle, 8, 0);
        myGrid.getChildren().add(shapeTriangle);
        shapeTriangle.setOnAction(e -> brush.setShape("TRIANGLE"));

        myPanel.setBottom(myGrid);

        scene = new Scene(myPanel, 640, 480);
        stage.setScene(scene);
        stage.show();

        // handle clear button 
               
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, (mouseEvent) -> {
            int x = (int) mouseEvent.getX();
            int y = (int) mouseEvent.getY();
            System.out.println(x + " " + y);
            brush.drawShape(x, y, root); 
        });
        scene.addEventFilter(MouseEvent.MOUSE_DRAGGED, (mouseEvent) -> {
            int x = (int) mouseEvent.getX();
            int y = (int) mouseEvent.getY();
            System.out.println(x + " " + y);
            brush.drawShape(x, y, root); 
        });
    }
   
}
