package blackjack;

public class Card {
  
  //attributes
  private String suit;
  private String id;
  private int value;
  
  //constructor
  public Card(String s, int v) {
    
    suit = s;
    if (v == 11) {
      value = 10;
      id = "Jack";
    }
    else if (v == 12) {
      value = 10;
      id = "Queen";
    }
    else if (v == 13) {
      value = 10;
      id = "King";
    }
    else if (v == 14) {
      value = 11;
      id = "Ace";
    }
    else {
      value = v;
      id = Integer.toString(v);
    }
}
