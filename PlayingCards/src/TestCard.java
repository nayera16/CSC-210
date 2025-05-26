import java.util.Random;

public class TestCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card cardOne = new Card("heats", "ace");
		Card cardTwo = new Card("diamond", 4);
		
		cardOne.print();
	
		cardTwo.print();
		
		cardOne.setRank("jack");
		cardOne.print();
		
		Deck myDeck = new Deck("Red");
		System.out.println(myDeck.getColor());
		//myDeck.print();
		
		Card thisCard = myDeck.getCard(4);
		thisCard.print();
		
		Random rand = new Random();
		int cardIndex = rand.nextInt(52);
		
		Card randomCard = myDeck.getCard(cardIndex);
		randomCard.print();
	}

}
