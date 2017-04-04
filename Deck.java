/* Leave comments here [...]
 * 
 */

package blackjack;

import java.util.ArrayList;
public class Deck {

	//attributes - arraylist of cards
	private ArrayList<Card> deck = new ArrayList<>(312);

	//no-args constructor 
	public Deck() { }

	//createDeck method - deals equivalent number of cards for each suit
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

	//deal method - create temp card, removes it from deck, then returns it
	public Card deal() {
		Card temp = deck.get(0);
		deck.remove(0);
		return temp;
	}
	
	public void addToDeck(Card c) {
		deck.add(c);
	}
	
	public void clearDeck() {
		deck.clear();
	}
	
	public int getSize() {
		return deck.size();
	}

	//shuffleDeck method - uses arraylist of card objects to shuffle deck
	public void shuffleDeck() {
		//clears array list of all card objects
		deck.clear();
		//creates new Deck (312 card object will be added to arraylist)
		createDeck();
		//create usedNums array to keep track of the numbers (indexes) already used to shuffle the deck
		ArrayList<Integer> usedNums = new ArrayList<>();
		//for loop - rearranges or "shuffles" 312 cards (equivalent to 6 decks - blackjack standard)
		for (int i = 312; i >= 0; i--) {
			Card holder = new Card(deck.get(i).getSuit(), deck.get(i).getValue());
			deck.remove(deck.get(i));
			int randomNum = 1 + (int) (Math.random() * 312);
			while (usedNums.indexOf(randomNum) == -1)
				randomNum = 1 + (int) (Math.random() * 312);
			deck.add(randomNum, holder);
			usedNums.add(randomNum);
		} // end for loop
	}// end shuffleDeck
}// end Deck class
