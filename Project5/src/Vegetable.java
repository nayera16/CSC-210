//package com.gradescope.garden;
public class Vegetable extends Plant {
	/*
	 * implements growth process for vegetable plant type: grows vertically 
	 * starting at the top center location
	 */
	public Vegetable(String type) {
        super(type);
        representation[0][2] = type.charAt(0);
    }
	
	@Override
	public void grow(int num) {
		for (int i = 0; i < 5 && num > 0; i++) {
	        if (representation[i][2] == '.') {  // only grow in the middle column
	            representation[i][2] = type.charAt(0); // grow downward
	            num--;
	        }
	    }
	}
	
	
}
