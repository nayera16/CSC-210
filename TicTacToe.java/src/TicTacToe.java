import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) throws Exception {
        Character[][] grid = new Character[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
                if (j != 2) System.out.print("|");
            }
            if (i != 2) System.out.println("\n-----");
            else System.out.println();
        }

        boolean keep_playing = true;
        Character player = 'X';
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

        System.out.println("Game ended.");
        
    }
}
