
public class Card {
	
	// declare a class constant
	public final static String[] SUITS = {"diamonds", "clubs", "heats", "spades"};
	
	
	public final static String[] RANKS = {"ace", "two", "three", "four", "five", "six",
											"seven", "eight", "nine", "ten", "jack", 
											"queen", "king"};
	
	private String suit; 
	private String rank;
	
	public Card(String suit, String rank) {
		if (validRank(rank)) this.suit = suit;
		if (validSuit(suit)) this.rank = rank;
	}
	
	public Card(String suit, int rank) {
		if (rank >= 1 && rank <= 13) this.rank = RANKS[rank - 1];
		if (validSuit(suit)) this.suit = suit;
	}
	
	private Boolean inArray(String value, String[] arr) {
		for (String element : arr) {
			if (element.equals(value)) return true;
		}
		return false;
	}
	
	private Boolean validRank(String rank) {
		return inArray(rank, RANKS);
	}	
	
	private Boolean validSuit(String suti) {
		return inArray(suit, SUITS);
	}
	
	public void setSuit(String suit) {
		if (inArray(suit, SUITS)) this.suit = suit;
	}
	
	public void setRank(String rank) {
		if (inArray(rank, RANKS)) this.rank = rank;
	}
	
	public void setRank(int rank) {
		if (rank >= 1 && rank <= 13) this.rank = RANKS[rank - 1];
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getRank() {
		return rank;
		
	}
	
	public void print()	{
		System.out.println(rank + " of " + suit);
	}
}
