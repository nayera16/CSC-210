import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CardGameTest {

	@Test
	void testCardsLeft() {
		ArrayList<String> players = new ArrayList<>();
		players.add("John"); players.add("Anna"); 
		players.add("Joanne"); players.add("Katy");
		CardGame myGame = new CardGame(players, 5);
		// after dealing 5 cards to 4 players, deck should have 32 cards left
		assertEquals(32, myGame.getDeck().getSize());
	}
	
	@Test
	void testCardDealing() {
		ArrayList<String> players = new ArrayList<>();
		players.add("Anna"); 
		CardGame myGame = new CardGame(players, 1);
		// Anna's card shouldn't be in the deck
		Card annasCard = myGame.getPlayer(0).getHand().getCard(0);
		assertFalse(myGame.getDeck().contains(annasCard.getSuit(), annasCard.getRank()));
	}
	
	@Test
	void testGameString() {
		ArrayList<String> players = new ArrayList<>();
		players.add("John"); players.add("Anna"); 
		CardGame myGame = new CardGame(players, 1);
		String expected = "******** John ********\n";
		expected += "ace of diamonds\n******** Anna ********\n";
		expected += "two of diamonds";
		assertEquals(expected, myGame.toString());	
	}

}
