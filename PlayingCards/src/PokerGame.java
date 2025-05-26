
public class PokerGame implements CardGame	{
	private int cardCount = 5;
	private int playerCount = 5;
	
	public void setHand(int cardcount) {
		this.cardCount = cardCount;
	}
	
	public int getHand() {
		return cardCount;
	}
	
	public void setPlayers(int playerCount) {
		this.playerCount = playerCount;	
	}
	
	public int getPlayers() {
		return playerCount;
	}

}
