import java.util.ArrayList;


public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private String color;
	
	public Deck(String color) {
		
		for (String s : Card.SUITS) {
			for (int i = 1; i <= 13; i++) {
				Card thisCard = new Card(s, i);
				thisCard.print();
			}
		}
		
	}
	
	public void printCards() {
		for (int i = 0; i < cards.size(); i++) {
			String this.suit = 
		}
	}
	
	public Card getCard(int index) {
		return cards.get(index);
	}
	
	public void setColor(String color) {
		if (color.equals("Red") || color.equals("Black")) this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	
}

