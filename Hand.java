/* Leave comments here [...]
 * 
 */

package blackjack;

import java.util.ArrayList;
public class Hand {
	
	//attributes - an arraylist of cards
	private ArrayList<Card> cards;

	// constructor
	public Hand(Card c1, Card c2) {
		cards.add(c1);
		cards.add(c2);
	}

	//getHand method
	public ArrayList getHand() { return cards; }

	//add method - adds card to arraylist
	public void add(Card c) {
		cards.add(c);
	}

	//count method gets "total value" of cards (ex. ace plus 5 had value of 16)
	public int count() {
		int result = 0;
		for (int i = 0; i < cards.size(); i++)
			result += cards.get(i).getValue();
		return result;
	}

	//toString method
	public String toString() { return cards.toString(); }
}//end Hand class
