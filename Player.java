package blackjack;

import java.util.ArrayList;

public class Player {
  private String name;
  private ArrayList <Chip> stack = new ArrayList <Chip>();
  private Hand hand;
  int total;
  
  public Player(String n, Arraylist <Chip> s, Hand h){
    name = n;
    stack = s;
    hand = h;
    setTotal();
  }
  
  //get and set methods
  public String getName(){
    return name;
  }
  public ArrayList<Chip> getStack(){
    return stack;
  }
  public Hand getHand(){
    return hand;
  }
  public int getTotal(){
    return total;
  }
  public void setName(String n){
    name = n;
  }
  public void setStack(ArrayList <Chip> s){
    stack = s
  }
  public void setHand(Hand h){
    hand = h;
  }
  public void setTotal(){
    for (int i=0;i<stack.size();i++){
      total += chip.getValue(stack.get(i));
  }
  
  //other methods
  public boolean isBroke(){
    if (stack.isEmpty())
      return true
    else
      return false
  }
  public void addChip(Chip c){
    stack.add(c);
    setTotal();
  }
  public void subtractChip(Chip c){
    if (!stack.contains(c))
      return false
    else {
      stack.remove(c);
      setTotal();
    }
  }
  
  //Hit Method
  public void hit(Card c) {
    hand.add(c);
  }
  
  //canSplit
  public boolean canSplit() {
    boolean result = false;
    if(hand.getHand().get(0).getID().equals(hand.getHand().get(1).getID()) && hand.getHand().get(0).getSuit().equals(hand.getHand().get(1).getSuit()))
      result = true;
  }
  
  //Split Method
  public Card split() {
    return (hand.getHand.remove(1));
  }
  
  //toString
  public String toString(){
      return name+": $"+getTotal();
  }
}
