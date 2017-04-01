package blackjack;

import java.util.ArrayList;
public class Hand {
  private ArrayList<Card> cards;
  
  //constructor
  public Hand (Card c1, Card c2) {
      cards.add(c1);
      cards.add(c2);
  }
  //get/set methods
  public ArrayList getHand() {return cards;}
  
  //Hit Method
  public void add(Card c) {
    cards.add(c);
  }
  
  //Counts the value of your hand
  public int count() {
    int result = 0;
    for(int i=0; i<cards.size(); i++) 
      result += cards.get(i).getValue();
    return result;
  }
  
  //toString
  public String toString() {
    return cards.toString();
  }
}
