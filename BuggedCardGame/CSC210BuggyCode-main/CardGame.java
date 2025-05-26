import java.util.ArrayList;

public class CardGame {
	
	private Deck gameDeck = new Deck("red");
	private ArrayList<Player> players = new ArrayList<>();
	private int playerCount;
	
	public CardGame(ArrayList<String> playerNames, int cardCount) {
		playerCount = playerNames.size();
		for (String name : playerNames) {
			Player newPlayer = new Player(name, cardCount, gameDeck);
			players.add(newPlayer);
		}
	}
	
	public Player getPlayer(int position) {
		return players.get(position);
	}
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public Deck getDeck() {
		return gameDeck;
	}
	
	public String toString() {
		String message = "";
		for (int i = 0; i < playerCount; i++) {
			String player = players.get(0).toString();
			message += player + "\n"; 
		}
		return message;
	}
    
    
    
}