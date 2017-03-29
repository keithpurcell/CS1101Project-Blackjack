package blackjack;

public class Player {
	private String name;
	private Hand hand;

	public Player(String n) {
		name = n;
	}

	// get and set methods
	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}
	
	public String toString() {
		String attributes;
		attributes = name + "\n" + hand.toString();
		return attributes;
	}
}
