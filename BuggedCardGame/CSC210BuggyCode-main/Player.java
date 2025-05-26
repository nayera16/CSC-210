public class Player {
	private String name;
	private Hand hand;
	
	public Player(String name, int cardCount, Deck deck) {
		this.name = name;
		hand = new Hand(cardCount, deck);
	}
	
	public String getName() {
		return name;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public String toString() {
		String message = "******** " + name + " ********\n";
		message += hand.toString();
		return message;
	}
 	

}
