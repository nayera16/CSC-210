package com.example;

public class Burger extends Food{
    private Size size;
    public enum Size { SINGLE, DOUBLE }

	private Topping topping;
	public enum Topping {
		CHEESE,
        PLAIN
	}
	
	// constructor
	public Burger(Topping topping, Size size) {
		this.label = size.toString() + " ";
		this.label += topping.toString() + " BURGER";
		this.topping = topping;
		this.size = size;
	}
	
	// getter and setter
	public double getPrice() {
		switch (topping) {
		case CHEESE:
			return 6.00 + size.ordinal() * 5;
		case PLAIN:
			return 5.20 + size.ordinal() * 5;
		default:
			return 0;
		}
	}
	
}
