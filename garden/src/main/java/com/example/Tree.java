package com.example;
public class Tree extends Plant {
	/*
	 * implements growth process for tree plant type: grows vertically 
	 * starting at the bottom middle
	 */
	
	public Tree(String type) {
		super(type);
		representation[4][2] = type.charAt(0);
	}
	
	@Override
	public void grow(int num) {
		for (int i = 4; i >= 0 && num > 0; i--) {
	        if (representation[i][2] == '.') {  // only grow in the middle column
	            representation[i][2] = type.charAt(0); // grow upwards
	            num--;
	        }
	    }
	}



}
