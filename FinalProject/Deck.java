import java.util.Random;
import java.util.ArrayList;

public class Deck {

    //attributes - arraylist of cards - one deck for the official deck of shuffled cards
    //and another to help reshuffle the deck
    private ArrayList<Card> shuffledDeck = new ArrayList<>();
    private ArrayList<Card> newDeck = new ArrayList<>();
    
    //no-args constructor 
    public Deck() { shuffleDeck(); }

    //createDeck method - deals equivalent number of cards for each suit
    public void createDeck() {
        for (int j = 0; j < 6; j++) {
            for (int i = 1; i < 14; i++)
                newDeck.add(new Card("hearts", i));
        }
        for (int j = 0; j < 6; j++) {
            for (int i = 1; i < 14; i++)
                newDeck.add(new Card("Spade", i));
        }
        for (int j = 0; j < 6; j++) {
            for (int i = 1; i < 14; i++)
                newDeck.add(new Card("Diamond", i));
        }
        for (int j = 0; j < 6; j++) {
            for (int i = 1; i < 14; i++)
                newDeck.add(new Card("clubs", i));
        }
    }

    //deal method - create temp card, removes it from deck, then returns it
    public Card deal() {
        Card temp = shuffledDeck.get(0);
        shuffledDeck.remove(0);
        return temp;
    }

    public void clearDeck() { shuffledDeck.clear(); }

    public int getSize() { return shuffledDeck.size(); }

    //shuffleDeck method - uses arraylist of card objects to shuffle deck
    public void shuffleDeck() {
        
        //clears array list of all card objects
        shuffledDeck.clear();
        newDeck.clear();
        
        //creates new Deck (312 card object will be added to arraylist)
        createDeck();

        Random r = new Random();
        int randomNum;
        for (int i = 0; i < 312; i++) {
            randomNum = r.nextInt(newDeck.size());
            shuffledDeck.add(newDeck.get(randomNum));
            newDeck.remove(randomNum);
        }
    }// end shuffleDecks
}//end class