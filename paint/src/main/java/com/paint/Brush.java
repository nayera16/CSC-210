package com.paint;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Brush {
    private double size;
    private Color color;
    private String shape; // "CIRCLE", "SQUARE", etc.

    public Brush() {
        this.size = 5; // Default size
        this.color = Color.BLACK; // Default color
        this.shape = "CIRCLE"; // Default shape
    }

    // Getters and Setters
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = Math.max(1, size);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void increaseSize() {
        setSize(size + 2); // increase size by 2 units
    }

    public void decreaseSize() {
        setSize(size - 2); // decrease size by 2 units
    }

    // Method to draw the current shape
    public void drawShape(double x, double y, Group group) {
        Shape drawable;
        switch (shape) {
            case "RECTANGLE":
                drawable = new Rectangle(x - size / 2.0, y - size / 2.0, size, size);
                break;
            case "TRIANGLE":
                drawable = createTriangle(x, y, size);
                break;
            case "CIRCLE":
            default:
                drawable = new Circle(x, y, size / 2.0);
                break;
        }
        drawable.setFill(color);
        group.getChildren().add(drawable);
    }

    private Polygon createTriangle(double x, double y, double size) {
        double halfSize = size / 2.0;
        return new Polygon(
            x, y - halfSize, // Top point
            x - halfSize, y + halfSize, // Bottom left
            x + halfSize, y + halfSize // Bottom right
        );
    }


}
