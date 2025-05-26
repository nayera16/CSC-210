package com.example;
public class Garden {
	/*
	 * the garden class creates the garden according to the input number of 
	 * rows and columns. it also controls each grow method, as well as the harvest, 
	 * pick and cut methods for the different plant types. it also has a print method
	 * which calls the screen class to update the printed output
	 */
	
	private int rows;
	private int cols;
	private Plant[][] gardenPlots;
	
	public Garden(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.gardenPlots = new Plant[rows][cols];
	}
	
	public void plant(int x, int y, String type) {
		// plant method creates plot according to each plant type
		
		switch (type.toLowerCase()) {
		// checks each case for each type of flower, tree, vegetable, and herb
		case "iris":
		case "lily":
		case "rose":
		case "daisy":
		case "tulip":
		case "sunflower":
			gardenPlots[x][y] = new Flower(type);
			break;
		case "oak":
        case "willow":
        case "banana":
        case "coconut":
        case "pine":
            gardenPlots[x][y] = new Tree(type);
            break;
        case "garlic":
        case "zucchini":
        case "tomato":
        case "yam":
        case "lettuce":
            gardenPlots[x][y] = new Vegetable(type);
            break;
        case "alfalfa":
        case "fennel":
        case "mint":
        case "echinacea":
        case "horseradish":
            gardenPlots[x][y] = new Herb(type);
            break;
        default:
            System.out.println("");
		}	
		
	}
	
	// grows every plant in the garden
	public void grow(int num) {
		
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] != null) {
                    gardenPlots[i][j].grow(num);
                }
            }
        }
    }

    // grows only the plant at specific coordinates
    public void grow(int num, int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && gardenPlots[x][y] != null) {
            gardenPlots[x][y].grow(num);
        } else {
            System.out.println("Can't grow there.\n");
        }
    }

    // grows only the plants of the specified name
    public void grow(int num, String type) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] != null && gardenPlots[i][j].getType().equalsIgnoreCase(type)) {
                    gardenPlots[i][j].grow(num);
                }
            }
        }
    }

    // grow only the plants of the specified type
    public void growPlant(int num, String plantClass) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] != null) {
                    switch (plantClass.toLowerCase()) {
                        case "flower":
                            if (gardenPlots[i][j] instanceof Flower) {
                                gardenPlots[i][j].grow(num);
                            }
                            break;
                        case "tree":
                            if (gardenPlots[i][j] instanceof Tree) {
                                gardenPlots[i][j].grow(num);
                            }
                            break;
                        case "vegetable":
                            if (gardenPlots[i][j] instanceof Vegetable) {
                                gardenPlots[i][j].grow(num);
                            }
                            break;
                    }
                }
            }
        }
    }
    
    // method to create an empty plot for pick, cut, and harvest commands
    private char[][] getEmptyPlot() {
        char[][] emptyPlot = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                emptyPlot[i][j] = '.';
            }
        }
        return emptyPlot;
    }
    

    // harvest all vegetables
    public void harvest() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] instanceof Vegetable) {
                    gardenPlots[i][j].setRepresentation(getEmptyPlot()); 
                }
            }
        }
    }

    // harvest vegetable at specific coordinates
    public void harvest(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && gardenPlots[x][y] instanceof Vegetable) {
            gardenPlots[x][y].setRepresentation(getEmptyPlot());
        } else {
            System.out.println("Can't harvest there.\n");
        }
    }

    // harvest all vegetables of a specific name
    public void harvest(String type) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] instanceof Vegetable && gardenPlots[i][j].getType().equalsIgnoreCase(type)) {
                    gardenPlots[i][j].setRepresentation(getEmptyPlot());
                }
            }
        }
    }

    // pick all flowers
    public void pick() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] instanceof Flower) {
                    gardenPlots[i][j].setRepresentation(getEmptyPlot());
                }
            }
        }
    }

    // pick flower at specific coordinates
    public void pick(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && gardenPlots[x][y] instanceof Flower) {
            gardenPlots[x][y].setRepresentation(getEmptyPlot());
        } else {
            System.out.println("Can't pick there.\n");
        }
    }

    // pick all flowers of a specific name
    public void pick(String type) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] instanceof Flower && gardenPlots[i][j].getType().equalsIgnoreCase(type)) {
                    gardenPlots[i][j].setRepresentation(getEmptyPlot());
                }
            }
        }
    }

    // cut all trees
    public void cut() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] instanceof Tree) {
                    gardenPlots[i][j].setRepresentation(getEmptyPlot());
                }
            }
        }
    }

    // cut tree at specific coordinates
    public void cut(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && gardenPlots[x][y] instanceof Tree) {
        	
        	gardenPlots[x][y].setRepresentation(getEmptyPlot());
        } else {
            System.out.println("Can't cut there.\n");
        }
    }

    // cut all trees of a specific name
    public void cut(String type) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] instanceof Tree && gardenPlots[i][j].getType().equalsIgnoreCase(type)) {
              
                	gardenPlots[i][j].setRepresentation(getEmptyPlot());
                }
            }
        }
    }
    
	public void print() {
        Screen screen = new Screen(rows, cols);
        screen.clearScreen();

        // update screen with each plant's representation
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gardenPlots[i][j] != null) {
                    screen.updateScreen(gardenPlots[i][j], i, j);
                }
            }
        }

        // print garden
        screen.printScreen();
    }
	
}
