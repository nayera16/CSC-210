
public class Card {
	
	// declaring a class constant
	public final static String[] SUITS = {"diamonds", "clubs", 
			                               "hearts", "spades"};
	
	// declare a constant for rank
	private final static String[] RANKS = {"ace", "two", "three",
			                               "four", "five", "six",
			                               "seven", "eight", "nine",
			                               "ten", "jack", "queen",
			                               "king"};
	
	private String suit;
	private String rank;
	
	// constructors
	public Card(String suit, String rank) {
		if (inArray(suit, SUITS)) this.suit = suit;
		if (inArray(rank, RANKS)) this.rank = rank;
	}
	
	public Card(String suit, int rank) {
		if (inArray(suit, SUITS)) this.suit = suit;
		if (rank >= 1 && rank <= 13) this.rank = RANKS[rank-1];
	}
	
	// helper contains method for array
	private boolean inArray(String value, String[] array) {
		for (String element : array) {
			if (element.equals(value)) return true;
		}
		return false;
	}
	
	// setters
	public void setSuit(String suit) {
		if (inArray(suit, SUITS)) this.suit = suit;
	}
	
	// overloading, write another setRank method with
	// an int argument
	public void setRank(int rank) {
		if (rank >= 1 && rank <= 13) this.rank = RANKS[rank-1];
	}
	
	public void setRank(String rank) {
		if (inArray(rank, RANKS)) this.rank = rank;
	}
	
	// getters
	public String getSuit() {
		return suit;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String toString() {
		return rank + " of " + suit;
	}

}
