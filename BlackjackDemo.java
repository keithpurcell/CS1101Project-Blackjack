import java.util.Scanner;
import java.util.ArrayList;
public class BlackjackDemo {
   private static Deck master;
	public static void main (String[] args) {
	   
	  //create scanner object
      Scanner kb = new Scanner(System.in);
 
      //Create and Shuffle Master Deck and Discard Deck
      Deck master = new Deck();
      Deck discard = new Deck();
      //master.createDeck();
      master.shuffleDeck();
    
      //Create the player
      System.out.println("Welcome to Blackjack!");
      System.out.print("Enter your name: ");
      String n = kb.next();
      Player p = new Player(n,500);
      System.out.print("Welcome "+p.getName()+"! You are starting off with $500!");
      boolean leave = false;
      int bet = 0;
      while(!p.isBroke() && !leave) {
         //Take Bets and create hands
         System.out.println("What is your bet?");
         while(!kb.hasNextInt()) {
            System.out.println("Not a valid bet. Try again: ");
            kb.next();
         }
         bet = kb.nextInt();
         while(bet<=0 || bet>p.getStack()) {
            System.out.println("Not a valid bet. Try again: ");
            while(!kb.hasNextInt()) {
               System.out.println("Not a valid bet. Try again: ");
               kb.next();
            }
            bet = kb.nextInt();
         }
            
         p.addToHand(master.deal());
         p.addToHand(master.deal());
         //Create the "dealer"
         Hand dealer = new Hand();
         dealer.add(master.deal());
         dealer.add(master.deal());
         
         int over = 3; //Turn over (3 for not over, 2 for stand, 0 for tie, 1 for win and -1 for loss)
         boolean dd = false; //Keeps track of if you've doubled down this turn
         
         //Turn Loop
         while(over == 3) {
            System.out.println("\nDealer's Hand: ["+ dealer.getCards().get(0)+ ",???]");
            System.out.println("\nYour Hand: "+p.getHand()+"\n");
      
            if(bjCheck(p.getHand()) == 1 && bjCheck(dealer) == 1) {
               over = 0;//Tie (2 BlackJacks)
            }
            else if(bjCheck(p.getHand()) == 1 && bjCheck(dealer) == 0) {
               over = 1;//You win (BlackJack)
            }
            else if(bjCheck(p.getHand()) == 0 && bjCheck(dealer) == 1) {
               over = -1;//You Lose (Dealer has Blackjack)
            }
            else if(bjCheck(p.getHand()) == -1) {
               over = -1;//You lose, you bust
            } 
            else {
               if(dd == false) {
                  System.out.println("\nWhat would you like to do? (Hit, Stand, or Double) ");
                  String play = kb.next();
                  while(!(play.equalsIgnoreCase("hit") || play.equalsIgnoreCase("stand") || play.equalsIgnoreCase("double"))) {
                     System.out.println("Not a valid response. Please type hit, stand or double:");
                     play = kb.next();
                  }
                  if(play.equalsIgnoreCase("hit")) {
                     p.addToHand(master.deal());
                     p.getHand().aceChecker();
                  }
                  else if(play.equalsIgnoreCase("stand"))
                     over = 2;
                  else if(play.equalsIgnoreCase("double")) {
                     if(bet*2 <= p.getStack()) {
                        bet = bet*2;
                        dd = true;
                     }
                     else
                        System.out.println("You don't have enough money to double down.");
                        
                  }
               }
               else if(dd == true) { 
                  p.addToHand(master.deal());
                  p.getHand().aceChecker();
                  if(bjCheck(p.getHand()) == 1)
                     over = 1;
                  else if(bjCheck(p.getHand()) == -1)
                     over = -1;
                  else
                     over = 2;
               }
            }//End of playing
            
            if (over == 2) {//Dealer has to play
               boolean soft = false;//For soft 17
               boolean done = false;//Indicates when the dealer is finished playing
               while(bjCheck(dealer) == 0 && done == false) {//Dealer hasn't won or bust and is done hitting.
                  if(dealer.count() < 17) {
                     dealer.add(master.deal());
                     dealer.aceChecker();
                  }
                  else if(dealer.count() > 17)
                     done = true;
                  else if (dealer.count() == 17 && soft == false) {//Check for soft 17
                     ArrayList<Card> dealerCards = dealer.getCards();
                     for(int i=0;i<dealerCards.size(); i++) {
                        Card test = dealerCards.get(i);
                        if(test.getValue() == 11) {//If any card in the hand in an ace worth 11
                           dealer.add(master.deal());
                           dealer.aceChecker();
                           i=dealerCards.size();
                           soft = true;
                        }
                     }
                     if(soft == false)
                        done = true;
                  }//End of soft 17 check
               }//End of dealer playing
               if(bjCheck(dealer) == 1)//You stood, dealer hits blackjack
                  over = -1;
               else if(bjCheck(dealer) == -1)//You stood, dealer busts
                  over = 1;
               else {//Dealer is done hitting and you stood. Compare hands
                  if(dealer.count() > p.getHand().count()) //Dealer has more
                     over = -1;
                  else if(dealer.count() == p.getHand().count())//Tie with the dealer
                     over = 0;
                  else//You beat the dealer
                     over = 1;
               }
            }          
         } //End of turn loop (Over (or the result) has definetley been determined and both your hand and the dealer's has been played)
         
         //Reward collecting/money losing
         System.out.println("\nDealer's Hand: "+ dealer);
         System.out.println("\nYour Hand: "+p.getHand()+"\n");
         //You tied the dealer
         if(over == 0) {
            System.out.println("Tie. $"+bet+" returned to your stack");
            System.out.println("You now have $"+p.getStack());
            //bet = 0;
         }
         //You hit blackjack or beat the dealer
         else if(over == 1) {
            p.setStack(p.getStack() + bet);
            System.out.println("You win! $"+bet+" added to your stack.");
            System.out.println("You now have $"+p.getStack());
            //bet = 0;
         }
         //You bust or lost to the dealer
         else if(over == -1) {
            p.setStack(p.getStack() - bet);
            System.out.println("You Lose. $"+bet+" removed from your stack.");
            System.out.println("You now have $"+p.getStack());
            //bet = 0;
         }

         //Discarding Cards/Resetting hands
         ArrayList<Card> playerCards = p.getHand().getCards();
         ArrayList<Card> dealerCards = dealer.getCards();
         int playerSize = playerCards.size();
         int dealerSize = dealerCards.size();
         Card c, d;
         for(int i=(playerSize-1); i>=0; i--) {
            c = playerCards.get(i); //Grab each card
            p.getHand().getCards().remove(i);//Remove from hand (to reset for next turn)
            discard.addToDeck(c);//Add to discard Pile
         }
         for(int i=dealerSize-1; i>=0; i--) {
            d = dealerCards.get(i); //Grab each card
            dealer.getCards().remove(i);//Remove from hand (to reset for next turn)
            discard.addToDeck(d);//Add to discard Pile
         }
         
         //Re-integrate discard if at a certain point
         if(discard.getSize() >= 4) {
            discard.clearDeck();
            master.createDeck();
            master.shuffleDeck();
         }
         
         //Offer chance to leave (Replaced by leave table button
         if(p.getStack() == 0)
            System.out.println("You have no money left. bye bye");
         else
            System.out.println("You have $" + p.getStack() + " left.");
         
      }//End of play loop
      
      System.out.println("\nGame Over");         
   }

	// BlackJack Checker (1 for BlackJack, -1 for bust, 0 for nothing)
	public static int bjCheck(Hand h) {
		int result = 0;
		if (h.count() == 21)
			result = 1;
		else if (h.count() > 21)
			result = -1;
		return result;
	}
 
}