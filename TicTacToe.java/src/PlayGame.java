import java.util.Scanner;

public class PlayGame {
	Character[][] grid = new Character[3][3];
	// method for check win 
	
	// call board from board class
	
	boolean keep_playing = true;
    
    protected Character playerX;
    protected Character playerO;
    
    
    
    
    
    while (keep_playing) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter row number: ");
        int x = userInput.nextInt();
        System.out.print("Enter column number: ");
        int y = userInput.nextInt();
        grid[x][y] = player;
        if (player == 'X') player = 'O';
        else player = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
                if (j != 2) System.out.print("|");
            }
            if (i != 2) System.out.println("\n-----");
            else System.out.println();
        }

        boolean threeConsecutive = false;
        
        // check each 
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != ' ' && grid[i][1] != ' ' && grid[i][2] != ' ' &&
                grid[i][0] == grid[i][1] && 
                grid[i][1]  == grid[i][2]) threeConsecutive = true;
        }

        for (int i = 0; i < 3; i++) {
            if (grid[0][i] != ' ' && grid[1][i] != ' ' && grid[2][i] != ' ' &&
                grid[0][i] == grid[1][i] && 
                grid[1][i]  == grid[2][i]) threeConsecutive = true;
        }

        if (grid[0][0] != ' ' && grid[1][1] != ' ' && grid[2][2] != ' ' &&
            grid[0][0] == grid[1][1] && 
            grid[1][1]  == grid[2][2]) threeConsecutive = true;

        if (grid[0][2] != ' ' && grid[1][1] != ' ' && grid[2][0] != ' ' &&
            grid[0][2] == grid[1][1] && 
            grid[1][1]  == grid[2][0]) threeConsecutive = true;

        if (threeConsecutive) keep_playing = false;

        boolean tie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) { 
                if (grid[i][j] == ' ') tie = false;
            }
        }

        if (tie) {
            keep_playing = false;
            System.out.println("It's a tie!");
        }
      

    }
    
}
