package com.example;
public abstract class Plant {
	/*
	 * this is an abstract class to define the characteristics of all
	 * plant types. each plant has it's further specified type and its representation
	 * which is a 2D array of characters
	 */
	protected String type;
	protected char[][] representation;
	
	public Plant(String type) {
		this.type = type;
		this.representation = new char[5][5];
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				representation[i][j] = '.';
				
			}
		}
	}
	
	public char[][] getRepresentation(){
		return representation;
	}
	
	public void setRepresentation(char[][] newRepresentation) {
        this.representation = newRepresentation;
    }
	
	public String getType() {
		
		return type;
	}

	public abstract void grow(int num);
    
}
