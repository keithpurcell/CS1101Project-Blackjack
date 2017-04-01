package blackjack;
//Suggest taking the split option out. 
//Free to take a look but I can't get it to work within the turn loop so the player can play both hands at once}
import java.util.Scanner;
import java.ArrayList;
public class BlackjackDemo {
   public static void main (String[] args) {
      Scanner kb = new Scanner(System.in);
 
      //Create and Shuffle Master Deck and Discard Deck
      Deck master = new Deck();
      Deck discard = new Deck();
      master.createDeck();
      master.shuffleDeck();
    
      //Create the player
      System.out.println("Welcome to Blackjack!");
      System.out.print("Enter your name: ");
      String n = kb.next();
      Player p = new Player(n,500);
      System.out.print("Welcome "+p.getName()+"! You are starting off with $500!");
      boolean leave = false;
      
      while(!p.isBroke() && !leave) {
           
         //Take Bets and create hands
         System.out.println("What is your bet?");
         int bet = kb.nextInt();
         //p.setHand(master.deal(), master.deal());
         //Create the "dealer"
         //Hand dealer = new Hand(master.deal(),master.deal());
         
         int over = 3; //Turn over (3 for not over, 2 for stand, 0 for tie, 1 for win and -1 for loss)
         Hand split;//Useful for splitting
         boolean sp = false; //Keeps track of if you've split this turn
         boolean dd = false; //Keeps track of if you've doubled down this turn
         
         //Turn Loop
         while(over == 3) {
            //System.out.println("\nDealer's Hand: "+ dealer);
            System.out.println("\nYour Hand: "+p.getHand());
      
            if(bjCheck(p.getHand()) == 1 && bjCheck(dealer) == 1) {
            
               over = 0;//Tie (2 BlackJacks)
         
            }
            else if(bjCheck(p.getHand()) == 1 && bjCheck(dealer) == 0) {
           
               over = 1;//You win (BlackJack)
         
            }
            else if(bjCheck(p.getHand()) == 0 && bjCheck(dealer) == 1) {
         
               over = -1;//You Lose (Dealer has BlackJack)
         
            }
            else {
               if(dd == false && sp == false) {
                  System.out.println("What would you like to do? (Hit, Stand, Split or Double) ");
                  String play = kb.next();
                  if(play.equalsIgnoreCase("hit"))
                     p.hit();
                  else if(play.equalsIgnoreCase("stand")) {
                     over == 2;
                  }
                  else if(play.equalsIgnoreCase("split")) {
                     if(p.canSplit() == true) {
                        split = new Hand(p.getHand().getHand().remove(0), master.deal()) //New hand gets (1 card from old hand, new card)
                        p.getHand().add(master.deal());//Adds a second card to the current hand
                        sp = true
                     }
                     else
                        System.out.println("You cannot split on your current hand.");
                  }
                  else if(play.equalsIgnoreCase("double")) {
                     bet = bet*2;
                     dd = true;
                  }
               }
               else if(dd == true && sp == false) 
                  p.hit();
               /*else if (sp == true) {
                  System.out.println("Your Second Hand: "+split);*/
            }
            if(over == 2)
               dealerPlay(dealer); //Static method that takes in a hand and plays based on the rules in which a dealer plays
   
         } //End of turn loop
         
         //Reward collecting/money losing
         if(over == 0) {
            p.setStack(p.getStack() + bet);
            System.out.println("Tie. $"+bet+" returned to your stack");
            System.out.println("You now have $"+p.getStack());
            bet = 0;
         }
         else if(over == 1) {
            p.setStack(p.getStack() + (2*bet));
            System.out.println("You win! $"+bet+" added to your stack.");
            System.out.println("You now have $"+p.getStack());
            bet = 0;
         }
         else if(over == -1) {
            p.setStack(p.getStack() - bet)
            System.out.println("You Lose. $"+bet+" removed from your stack.");
            System.out.println("You now have $"+p.getStack());
            bet = 0;
         }
         
         //Discarding Cards/Resetting hands
         int playerSize = p.getHand().getHand().getSize();
         int dealerSize = dealer.getHand().getSize();
         for(int i=playerSize; i>=0; i++) {
            Card c = player.getHand().getHand().get(i);//Store card
            player.getHand().getHand().remove(i);//Remove from hand (to reset for next turn
            discard.add(c);//Add the card to the discard pile (NEED THIS METHOD)
         }
         for(int i=dealerSize; i>=0; i++) {
            Card d = dealer.getHand().get(i);
            dealer.getHand().remove(i);
            discard.add(d);
         }
         
         //Re-integrate discard if at a certain point
         if(discard.getSize()/*NEED THIS METHOD*/ >= 30) {
            discard.empty();//NEED THIS METHOD to empty discard pile
            master.createDeck();
            master.shuffleDeck();
         }
         
         //Offer chance to leave (Replaced by leave table button
         if(p.getStack() == 0)
            System.out.println("You have no money left. bye bye");
         else
            System.out.println("You have $"+p.getStack()+" left. Would you like to leave
         
      }//End of play loop
      
      System.out.println("Game Over");         
   }
      
   //BlackJack Checker (1 for BlackJack, -1 for bust, 0 for nothing)
   public static int bjCheck(Hand h) {
      int result = 0;
      if(h.count() == 21)
         result = 1;
      else if(h.count() > 21)
         result = -1;
      return result;
   }
}
