/* Leave comments here [...]
 * 
 */
import java.util.Random;
import java.util.ArrayList;
public class Deck {

	//attributes - arraylist of cards
	private ArrayList<Card> deck = new ArrayList<>();

	//no-args constructor 
	public Deck() { }

	//createDeck method - deals equivalent number of cards for each suit
	public void createDeck() {
		for (int j = 0; j < 6; j++) {
			for (int i = 1; i < 14; i++)
				deck.add(new Card("Heart", i));
		}
		for (int j = 0; j < 6; j++) {
			for (int i = 1; i < 14; i++)
				deck.add(new Card("Spade", i));
		}
		for (int j = 0; j < 6; j++) {
			for (int i = 1; i < 14; i++)
				deck.add(new Card("Diamond", i));
		}
		for (int j = 0; j < 6; j++) {
			for (int i = 1; i < 14; i++)
				deck.add(new Card("Club", i));
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
      Random rand = new Random();
		for (int i = 311; i >= 0; i--) {
			Card holder = new Card(deck.get(i).getSuit(), deck.get(i).getValue());
			deck.remove(deck.get(i));
			int randomNum = rand.nextInt(312);//0-311
			while (usedNums.indexOf(randomNum) != -1)
				randomNum = rand.nextInt(312);//0-311
			deck.add(randomNum, holder);
			usedNums.add(randomNum);
		} // end for loop
	}// end shuffleDeck
}// end Deck class