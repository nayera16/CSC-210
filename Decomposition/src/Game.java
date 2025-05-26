import java.util.Random;
import java.util.Scanner;

public class Game {
	
	Scanner userInput = new Scanner(System.in);
	Random random = new Random();
	
	protected int number;
	protected int guess;
	protected int tries;
	
	public int getNumber() {
		return random.nextInt(10);
	}
	
	public int getNumTries() {
		return tries;
	}
	
	public int getGuess() {
		return userInput.nextInt();
	}
	
	public String checkWin() {
		if (guess == number) {
			return "Game ended with " + getNumTries() + " tries.";
		}
		else tries++;
		return "Enter a number between 0 and 9: ";
	}
	
	public Game() {
		tries = 1;
	}
	

}
