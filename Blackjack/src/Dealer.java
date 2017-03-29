
public class Dealer {
	private Hand hand;
	
	public Dealer(){}
	
	public Hand getHand(){
		return hand;
	}
	public void setHand(Hand h){
		hand = h;
	}
	public void dealHand(Card c1, Card c2){
		hand.hit(c1);
		hand.hit(c2);
	}
}
