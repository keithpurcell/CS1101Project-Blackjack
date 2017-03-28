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
  
  //Add Method
  public void add(Card c) {
    cards.add(c);
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
