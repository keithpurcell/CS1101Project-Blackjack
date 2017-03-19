package blackjack;

public class Player {
  String name;
  double money;
  
  public Player(String n, double m){
    name = n;
    money = m;
  }
  
  //get and set methods
  public String getName(){
    return name;
  }
  public int getMoney(){
    return money;
  }
  public void setName(String n){
    name = n;
  }
  public void setMoney(int m){
    money = m;
  }
}
