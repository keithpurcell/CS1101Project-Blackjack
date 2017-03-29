package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<>(312);

	public Deck() {
	}

	public void createDeck() {
		for (int j = 0; j < 6; j++) {
			for (int i = 1; i < 14; i++)
				deck.add(i, new Card("Heart", i));
		}
		for (int j = 0; j < 6; j++) {
			for (int i = 1; i < 14; i++)
				deck.add(i, new Card("Spade", i));
		}
		for (int j = 0; j < 6; j++) {
			for (int i = 1; i < 14; i++)
				deck.add(i, new Card("Diamond", i));
		}
		for (int j = 0; j < 6; j++) {
			for (int i = 1; i < 14; i++)
				deck.add(i, new Card("Club", i));
		}
	}

	public void shuffleDeck() {
    deck.clear();
    createDeck();
    ArrayList<Integer> usedNums = new ArrayList<>();
    
    for (int i = 312; i >= 0; i--) {
    	Card holder = new Card(deck.get(i).getSuit(), deck.get(i).getValue());
    	deck.remove(deck.get(i));
    	int randomNum = 1 + (int)(Math.random() * 312);
    	while (usedNums.indexOf(randomNum) == -1)
    		randomNum = 1 + (int)(Math.random() * 312);
    	deck.add(randomNum, holder);
    	usedNums.add(randomNum);
    }
  }
}
