public class Hand {
  private ArrayList<Card> cards;
  
  //constructor
  public Hand (Card c1, Card c2) {
      cards.add(c1);
      cards.add(c2);
  }
  //get/set methods
  public Card getHand() {return cards;}
  public Card getCard1() {return card1;}
  public Card getCard2() {return card2;}
  public void setCard1(Card c1) {card1 = c1;}
  public void setCard2(Card c2) {card2 = c2;}
  
  //Hit Method
  public void hit(Card c) {
    cards.add(c);
  }
  
  //canSplit
  public boolean canSplit() {
    boolean result = false;
    if(cards.get(0).getID().equals(cards.get(1).getID()) && cards.get(0).getSuit().equals(cards.get(1).getSuit()))
      result = true;
  }
  
  //Split Method
  public Card split() {
    return (cards.remove(1));
  }
  
  //Counts the value of your hand
  public int count() {
    int result = 0;
    for(int i=0; i<card.size(); i++) 
      result += cards.get(i).getValue();
    return result;
  }
  
  //toString
  public String toString() {
    return cards;
  }
}
