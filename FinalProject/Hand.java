import java.util.ArrayList;
public class Hand {
	
	//attributes - an arraylist of cards
	private ArrayList<Card> cards;

	// constructor
   public Hand() {
      cards = new ArrayList<Card>();
   }//No args
	public Hand(Card c1, Card c2) {
      cards = new ArrayList<Card>();
	   cards.add(c1);
		cards.add(c2);
   }
   public Hand(Card c3){
      cards = new ArrayList<Card>();
	   cards.add(c3);
   }

	//getHand method
	public ArrayList getCards() { return cards; }

	//add method - adds card to arraylist
	public void add(Card c) {
		cards.add(c);
	}
   
   //split
   public ArrayList split(){
      ArrayList<Card> split = new ArrayList<Card>();
      Card c=cards.get(1);
      cards.remove(1);
      split.add(c);
      return split;
   }
      
   //Ace Checker
   public void aceChecker() {
      boolean ace = false;
      int index = -1;
      for(int i=0; i<cards.size();i++) {
         if(cards.get(i).getID().equalsIgnoreCase("ace")) {
            ace = true;
            index = i;
         }
      }
      if(ace == true) {//If there's an ace in the hand
         if(count() > 21)
            cards.get(index).setValue(1);
      }
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