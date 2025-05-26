package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 * Nayera Abdessalam
 * Fall 2024
 */

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Nayera's Food Ordering App");

        // we will be using a panel
        BorderPane myPanel = new BorderPane();

        // set up text area
        TextArea myTextArea = new TextArea();
        myTextArea.setPrefHeight(200);
        myTextArea.setEditable(false);
        
        // place text area in the panel
        myPanel.setBottom(myTextArea);

        // grid layout for buttons
        GridPane myGrid = new GridPane();
        myGrid.setPadding(new Insets(10, 10, 10, 10));
        myPanel.setCenter(myGrid);

        // start new order -- add a new button to start a new order
        // this hardcodes one order
        FoodOrder myOrder = new FoodOrder("0001");
        TextField userEntry = new TextField(myOrder.getOrderNumber());
        myGrid.getChildren().add(userEntry);

        // place order button
        Button submit = new Button("Place Order");
        GridPane.setConstraints(submit, 0, 2);
        myGrid.getChildren().add(submit);

        // the action for place order only prints it out
        // it does not update order status
        // TODO: update order status -- display order status, add buttons
        submit.setOnAction((actionEvent) -> {
            myTextArea.clear();
            myTextArea.appendText(myOrder.toString());
            myTextArea.appendText("\nOrder Status: Placed.");
        });

        Button readyButton = new Button("Mark as Ready");
        GridPane.setConstraints(readyButton, 0, 3);
        myGrid.getChildren().add(readyButton);

        readyButton.setOnAction((actionEvent) -> {
            myTextArea.appendText("\nOrder Status: Ready");
        });

        Button inRouteButton = new Button("Mark as InRoute");
        GridPane.setConstraints(inRouteButton, 0, 4);
        myGrid.getChildren().add(inRouteButton);
        
        inRouteButton.setOnAction((actionEvent) -> {
            myTextArea.appendText("\nOrder Status: InRoute");
            myOrder.setStatus(FoodOrder.OrderStatus.INROUTE);
        });

        Button deliveredButton = new Button("Mark as Delivered");
        GridPane.setConstraints(deliveredButton, 0, 5);
        myGrid.getChildren().add(deliveredButton);

        deliveredButton.setOnAction((actionEvent) -> {
            myTextArea.clear();
            myTextArea.appendText("Ordered Status: Delivered.\nEnjoy your food!");
        });

        // add size and flavor options for pizza
        final ToggleGroup groupSize = addSizeOptions(myGrid);
        final ToggleGroup groupFlavor = addFlavorOptions(myGrid);

        // add pizza button
        Button addPizza = new Button("Add Pizza");
        GridPane.setConstraints(addPizza, 3, 2);
        myGrid.getChildren().add(addPizza);

        // action for add pizza button
        addPizza.setOnAction((actionEvent) -> {
            // get selected flavor
            Pizza.Flavor flavor = (Pizza.Flavor) groupFlavor.getSelectedToggle().getUserData();
            // get selected size
            Pizza.Size size = (Pizza.Size) groupSize.getSelectedToggle().getUserData();
            // call constructor
            Food myFood = new Pizza(flavor, size);
            // add food to order
            myOrder.addFood(myFood);
            // print it out to tell user something happened
            myTextArea.appendText(myFood.toString());
        });

        // add size and topping options for burger
        final ToggleGroup groupSizeB = addSizeBOptions(myGrid);
        final ToggleGroup groupTopping = addToppingOptions(myGrid);

        // add burger button
        Button addBurger = new Button("Add Burger");
        GridPane.setConstraints(addBurger, 5, 2);
        myGrid.getChildren().add(addBurger);

        // action for add burger button
        addBurger.setOnAction((actionEvent) -> {
            // get selected flavor
            Burger.Topping topping = (Burger.Topping) groupTopping.getSelectedToggle().getUserData();
            // get selected size
            Burger.Size size = (Burger.Size) groupSizeB.getSelectedToggle().getUserData();
            // call constructor
            Food myFood = new Burger(topping, size);
            // add food to order
            myOrder.addFood(myFood);
            // print it out to tell user something happened
            myTextArea.appendText(myFood.toString());
        });

        // Remove food item
        Button removeFoodButton = new Button("Remove Last Item");
        GridPane.setConstraints(removeFoodButton, 3, 4);
        myGrid.getChildren().add(removeFoodButton);

        // Add functionality to remove the last food item
        removeFoodButton.setOnAction(e -> {
            if (!myOrder.items.isEmpty()) {
                Food lastItem = myOrder.items.get(myOrder.items.size() - 1);
                myOrder.removeFood(lastItem);
                myTextArea.appendText("\nRemoved:   " + lastItem.toString());
            } else {
                myTextArea.appendText("\nNo items to remove.");
            }
        }); 

        scene = new Scene(myPanel, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private ToggleGroup addToppingOptions(GridPane myGrid) {
        // set up group so that only one option is selected
        final ToggleGroup groupTopping = new ToggleGroup();

        // create cheese radio option
        RadioButton cheese = new RadioButton("Cheese");
        cheese.setSelected(true); // set selected to avoid errors
        // add it to group
        cheese.setToggleGroup(groupTopping);
        // set up user data to be enum option from Pizza class
        cheese.setUserData(Burger.Topping.CHEESE);
        // position option and add it to the grid
        GridPane.setConstraints(cheese, 5, 0);
        myGrid.getChildren().add(cheese);

        RadioButton plain = new RadioButton("Plain");
        plain.setToggleGroup(groupTopping);
        plain.setUserData(Burger.Topping.PLAIN);
        GridPane.setConstraints(plain, 5, 1);
        myGrid.getChildren().add(plain);

        return groupTopping;
    }

    private ToggleGroup addSizeBOptions(GridPane myGrid) {
        // set up group so that only one option is selected
        final ToggleGroup groupSizeB = new ToggleGroup();

        // create small radio option
        RadioButton single = new RadioButton("Single");
        single.setSelected(true); // set selected to avoid errors
        // add it to group
        single.setToggleGroup(groupSizeB);
        // set up user data to be enum option from Pizza class
        single.setUserData(Burger.Size.SINGLE);
        // position option and add it to the grid
        GridPane.setConstraints(single, 4, 0);
        myGrid.getChildren().add(single);

        RadioButton doubleBurg = new RadioButton("Double");
        doubleBurg.setToggleGroup(groupSizeB);
        doubleBurg.setUserData(Burger.Size.DOUBLE);
        GridPane.setConstraints(doubleBurg, 4, 1);
        myGrid.getChildren().add(doubleBurg);

        return groupSizeB;
    }

    private ToggleGroup addSizeOptions(GridPane myGrid) {
        // set up group so that only one option is selected
        final ToggleGroup groupSize = new ToggleGroup();

        // create small radio option
        RadioButton small = new RadioButton("Small");
        small.setSelected(true); // set selected to avoid errors
        // add it to group
        small.setToggleGroup(groupSize);
        // set up user data to be enum option from Pizza class
        small.setUserData(Pizza.Size.PERSONAL);
        // position option and add it to the grid
        GridPane.setConstraints(small, 2, 0);
        myGrid.getChildren().add(small);

        RadioButton medium = new RadioButton("Medium");
        medium.setToggleGroup(groupSize);
        medium.setUserData(Pizza.Size.MEDIUM);
        GridPane.setConstraints(medium, 2, 1);
        myGrid.getChildren().add(medium);

        RadioButton large = new RadioButton("Large");
        large.setToggleGroup(groupSize);
        large.setUserData(Pizza.Size.LARGE);
        GridPane.setConstraints(large, 2, 2);
        myGrid.getChildren().add(large);

        return groupSize;
    }

    private ToggleGroup addFlavorOptions(GridPane myGrid) {
        // set up group so that only one option is selected
        final ToggleGroup groupFlavor = new ToggleGroup();

        // create cheese radio option
        RadioButton cheese = new RadioButton("Cheese");
        cheese.setSelected(true); // set selected to avoid errors
        // add it to group
        cheese.setToggleGroup(groupFlavor);
        // set up user data to be enum option from Pizza class
        cheese.setUserData(Pizza.Flavor.CHEESE);
        // position option and add it to the grid
        GridPane.setConstraints(cheese, 3, 0);
        myGrid.getChildren().add(cheese);

        RadioButton pepperoni = new RadioButton("Pepperoni");
        pepperoni.setToggleGroup(groupFlavor);
        pepperoni.setUserData(Pizza.Flavor.PEPPERONI);
        GridPane.setConstraints(pepperoni, 3, 1);
        myGrid.getChildren().add(pepperoni);

        return groupFlavor;
    }

    public static void main(String[] args) {
        launch();
    }

}