package blackjack;

import java.util.ArrayList;

public class Player {
	private String name;
	private int stack;
	private Hand hand;
	int total;

	public Player(String n, int s) {
		name = n;
		stack = s;
	}

	// get and set methods
	public String getName() {
		return name;
	}

	public int getStack() {
		return stack;
	}

	public Hand getHand() {
		return hand;
	}

	public int getTotal() {
		return total;
	}

	public void setName(String n) {
		name = n;
	}

	public void setStack(int s) {
		stack = s;
	}

	public void setHand(Hand h) {
		hand = h;
	}

	// other methods
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
	}
}
