import java.util.ArrayList;
import java.util.Random;

public class Hand {
	private ArrayList<Card> hand = new ArrayList<>();
	private int cardCount;
	
	public Hand(int cardCount, Deck deck) {
		this.cardCount = cardCount;
		Random rand = new Random();
		  
        for (int i = 0; i < cardCount; i++) {
        	int cardIndex = rand.nextInt(cardCount-1);
        	Card thisCard = deck.getCard(cardIndex);
        	// add card to hand
        	hand.add(thisCard);
        }
	}
	
	public Card getCard(int index) {
		return hand.get(index);
	}
	
	public String toString() {
		String message = "";
		for (int i = 0; i < cardCount; i++) {
			message += hand.get(i).toString() + "\n";
		}
		return message; 
	}

}
