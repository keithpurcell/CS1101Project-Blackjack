package blackjack;

import java.util.Random;
public class Deck {

  private ArrayList<Card> deck = new ArrayList<>(312);
    
  public Deck() {}
  
  public void createDeck () {
    
      
  }
  
  public void shuffleDeck() {
    deck.clear();
    deck.createDeck();
    ArrayList<Integer> usedNums = new ArrayList<>();
    Card holder = new Card();
    
    for (int i = 312; i >= 0; i--) {
      holder = deck.get(i);
      deck.remove(deck.get(i));
      int randomNum = 1 + (int)(Math.random() * 312);
      while (usedNums.indexOf(randomNum) == -1)
        randomNum = 1 + (int)(Math.random() * 312);
      deck.add(holder, randomNum);
      usedNums.add(randomNum);
    }
  }
      
        
      
  

