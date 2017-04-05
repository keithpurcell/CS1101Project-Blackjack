public class Player {
	
	//attributes
	private String name;
	private int stack; //this variable represents how much money the player has
	private Hand hand;

	//constructor method - create player
	public Player(String n, int s) {
		name = n;
		stack = s;
      hand = new Hand();
	}

	public String getName() { return name; }

	public int getStack() { return stack; }

	public Hand getHand() { return hand; }

	public void setName(String n) { name = n; }

	//setStack method - sets players stack (how much money the player has)
	public void setStack(int s) { stack = s; }

	//addToHand method - adds a card to the players hand
	public void addToHand(Card c) { hand.add(c); }

	//isBroke method - checks if player is out of money
	public boolean isBroke() {
		if (stack == 0)
			return true;
		else
			return false;
	}

	// toString
	public String toString() {
		String p = name + "\n Stack: " + Integer.toString(stack) + "\n Hand: " + hand.toString();
		return p;
	}//end toString method
}//end Player class