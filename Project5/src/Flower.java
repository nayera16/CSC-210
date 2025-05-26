//package com.gradescope.garden;
public class Flower extends Plant{
	/*
	 * implements growth process for flower type using "growth stages"
	 *(the iteration of growth) according to the project instructions aka it 
	 *blooms outward
	 * 
	 */
	private int growthStage = 0; // growth stage is tracked so that regardless of num the plant will 
	
	public Flower(String type) {
		super(type);
		representation[2][2] = type.charAt(0);
		
	}
	
	@Override
	public void grow(int num) {
			if (growthStage == 0) {
                // first stage: expand to adjacent cells
                representation[1][2] = type.charAt(0); // up
                representation[3][2] = type.charAt(0); // down
                representation[2][1] = type.charAt(0); // left
                representation[2][3] = type.charAt(0); // right
                growthStage = 1; 
                if (num == 1) return; // when the input is 1, then growth stops here
                else num--; // otherwise it moves to the next growth stage, but decrements num so the cycle stops eventually
            }
			
			if (growthStage == 1) {
                // second stage: expand to diagonal cells and corners
                representation[1][1] = type.charAt(0);
                representation[1][3] = type.charAt(0); 
                representation[3][1] = type.charAt(0); 
                representation[3][3] = type.charAt(0); 
                representation[0][2] = type.charAt(0); 
                representation[4][2] = type.charAt(0); 
                representation[2][0] = type.charAt(0);
                representation[2][4] = type.charAt(0); 
                growthStage = 2; 
                if (num == 1) return; // when the input is 1, then growth stops here
                else num--; // otherwise it moves to the next growth stage, but decrements num so the cycle stops eve
            }
			if (growthStage == 2) {
                // third stage: fill the outermost edges except the corners
                for (int i = 1; i < 4; i++) {
                    representation[0][i] = type.charAt(0); // top row
                    representation[4][i] = type.charAt(0); // bottom row
                }
                for (int i = 1; i < 4; i++) {
                    representation[i][0] = type.charAt(0); // left column 
                    representation[i][4] = type.charAt(0); // right column 
                }
                growthStage = 3; 
                if (num == 1) return; // when the input is 1, then growth stops here
                else num--; // otherwise it moves to the next growth stage, but decrements num so the cycle stops eve
            }
            if (growthStage == 3) {
                // third stage: fill the outermost edges
                for (int i = 0; i < 5; i++) {
                    representation[0][i] = type.charAt(0); // Top row
                    representation[4][i] = type.charAt(0); // Bottom row
                    representation[i][0] = type.charAt(0); // Left column
                    representation[i][4] = type.charAt(0); // Right column
                }
                growthStage = 4; 
                return; // growth stops here no matter what the input is because this is the final growth stage
            }
	}
	
}
