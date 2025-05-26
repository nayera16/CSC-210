import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<>();
	private String color;
	
	// constructor method
	public Deck(String color) {
		this.color = color;
		for (String s : Card.SUITS) {
			for (int i = 1; i <= 13; i++) {
				Card newCard = new Card(s, i);
				cards.add(newCard);
			}
		}
	}
	
	// write setters and getters
	public String getColor() {
		return color;
	}
	
	public Card getCard(int index) {
		return cards.get(index);
	}
	
	public boolean contains(String suit, String rank) {
		for (Card c : cards) {
			if (c.getRank().equals(rank) && c.getSuit().equals(suit)) 
				return true;
		}
		return false;
		
	}
	
	public boolean removeCard(int index) {
		if (cards.size() > index) {
			cards.remove(index);
			return true;
		} else return false;
	}
	
	public int getSize() {
		return cards.size();
	}
	
	// write print method
	public String toString() {
		String message = "";
		for (int i = 0; i < cards.size(); i++) {
			String thisSuit = cards.get(i).getSuit();
			String thisRank = cards.get(i).getRank();
			message += thisRank + " of " + thisSuit;
		}
		return message;
	}
	
	

}
