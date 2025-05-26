package com.example;
public class Herb extends Plant{
	/*
	 * implements growth process for herb plant type: grows horizontally 
	 * along bottom row
	 */
	public Herb(String type) {
        super(type);
        representation[4][0] = type.charAt(0); // start at bottom left
	}
	
	@Override
	public void grow(int num) {
		for (int i = 4; i >= 0 && num > 0; i--) {
            if (representation[4][i] == '.') {  // Only grow along the bottom row
                representation[4][i] = type.charAt(0);  // Grow to the right
                num--;
            }
        }
	}
    
}
