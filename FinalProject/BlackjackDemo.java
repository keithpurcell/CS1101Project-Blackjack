import javafx.application.Platform;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import java.io.File;
import javafx.scene.transform.Rotate;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;
import java.util.Random;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.util.ArrayList;




public class BlackjackDemo extends Application {
      private Group root;
      private Text zero;
      private Text after;
      private Text t;
      private Text pot;
      private Text t1;
      private Text t2;
      private Text t3;
      private Text fini;
      private TextField betInput; 
      private TextField nameInput; 
      private Text intro;
      private Text intro2;
      private Text countS;
      private Text count;
      private Text dCount;
      private Text chips;
      private int cnt;
      private int b;
      private int check1;
      private int bett;
      private int counter;
      private int handNum;
      private int checker;
      private boolean check2;
      private boolean reg;
      private boolean prog;
      private Scene scene; 
      private ImageView C1;
      private ImageView C2;
      private ImageView v;
      private ImageView v1;
      private ImageView pnt;
      private Button hit;
      private Button stand;
      private Button split;
      private Button bet;
      private Button dd;
      private Button exit;
      private Button start;
      private Button plus;
      private Button minus;
      
      //Needed to play         
      private Player p;
      private static Deck master;
      private Deck discard;
      private Hand splitt;
      private Hand dealer;
      private int wager;
      private String name;
      private Image image3;
      private ArrayList<Card> playerCards;
      private ArrayList<Card> dealerCards;
      private ArrayList<Card> a;
      
      //club attributes
      private Image clubs1;
      private Image clubs2;
      private Image clubs3;
      private Image clubs4;
      private Image clubs5;
      private Image clubs6;
      private Image clubs7;
      private Image clubs8;
      private Image clubs9;
      private Image clubs10;
      private Image clubsJ;
      private Image clubsQ;
      private Image clubsK;
      //heart attributes
      private Image hearts1;
      private Image hearts2;
      private Image hearts3;
      private Image hearts4;
      private Image hearts5;
      private Image hearts6;
      private Image hearts7;
      private Image hearts8;
      private Image hearts9;
      private Image hearts10;
      private Image heartsJ;
      private Image heartsQ;
      private Image heartsK;
      //spade attributes
      private Image spa1;
      private Image spa2;
      private Image spa3;
      private Image spa4;
      private Image spa5;
      private Image spa6;
      private Image spa7;
      private Image spa8;
      private Image spa9;
      private Image spa10;
      private Image spaJ;
      private Image spaQ;
      private Image spaK;
      //diamond attributes
      private Image dia1;
      private Image dia2;
      private Image dia3;
      private Image dia4;
      private Image dia5;
      private Image dia6;
      private Image dia7;
      private Image dia8;
      private Image dia9;
      private Image dia10;
      private Image diaJ;
      private Image diaQ;
      private Image diaK;

   @Override
   public void start(Stage primaryStage){   
      root=new Group();
      //Scene
      scene = new Scene(root, 800, 800, Color.SANDYBROWN);

      /*
      On the board-----------------------------------------------
      */
      
      Circle face= new Circle();  
      face.setCenterX(400);
      face.setCenterY(50);
      face.setRadius(500);
      face.setStroke(Color.BLACK);
      face.setStrokeWidth(15);
      face.setFill(Color.GREEN);
      root.getChildren().add(face);
      //circle 1
      Circle r = new Circle();
      r.setCenterX(100);
      r.setCenterY(300);
      r.setRadius(50);
      r.setStroke(Color.WHITE);
      r.setFill(Color.GREEN);
      root.getChildren().add(r);
      //circle 1.1
      Circle r0 = new Circle();
      r0.setCenterX(680);
      r0.setCenterY(300);
      r0.setRadius(50);
      r0.setStroke(Color.WHITE);
      r0.setFill(Color.GREEN);
      root.getChildren().add(r0);
      //circle 2
      Circle r1 = new Circle();
      r1.setCenterX(230);
      r1.setCenterY(390);
      r1.setRadius(50);
      r1.setStroke(Color.WHITE);
      r1.setFill(Color.GREEN);
      root.getChildren().add(r1);
      //circle 2.1
      Circle rr1 = new Circle();
      rr1.setCenterX(550);
      rr1.setCenterY(390);
      rr1.setRadius(50);
      rr1.setStroke(Color.WHITE);
      rr1.setFill(Color.GREEN);
      root.getChildren().add(rr1);
      //circle 3
      Circle r2 = new Circle();
      r2.setCenterX(390);
      r2.setCenterY(450);
      r2.setRadius(50);
      r2.setStroke(Color.WHITE);
      r2.setFill(Color.GREEN);
      root.getChildren().add(r2);
      
      /*
      TextFields--------------------------------------
      */
 
      //take in name
      nameInput = new TextField();
      nameInput.setLayoutX(320);
      nameInput.setLayoutY(200);
      nameInput.setVisible(true);
      nameInput.setOnAction(this::processReturn);
      root.getChildren().add(nameInput);
         
      /*
      Buttons----------------------------------
      */
      
      //start button
      start= new Button("START GAME");
      start.setStyle("-fx-font:20 arial");
      start.setLayoutX(320);
      start.setLayoutY(300);
      start.setVisible(false);   
      start.setOnAction(this::processButtonPress);
      root.getChildren().add(start);
      //hit button
      hit= new Button("HIT");
      hit.setStyle("-fx-font:20 arial");
      hit.setLayoutX(500);
      hit.setLayoutY(600);
      hit.setVisible(false);
      hit.setOnAction(this::processButtonPress);
      root.getChildren().add(hit);
      //stand button
      stand= new Button("STAND");
      stand.setStyle("-fx-font:20 arial");
      stand.setLayoutX(570);
      stand.setLayoutY(600);
      stand.setVisible(false);
      stand.setOnAction(this::processButtonPress);
      root.getChildren().add(stand);
      //bet button
      bet= new Button("BET");
      bet.setStyle("-fx-font:20 arial");
      bet.setLayoutX(630);
      bet.setLayoutY(520);
      bet.setVisible(false);
      bet.setOnAction(this::processButtonPress);
      root.getChildren().add(bet);
      //doubledown button
      dd= new Button("DOUBLE");
      dd.setStyle("-fx-font:20 arial");
      dd.setLayoutX(675);
      dd.setLayoutY(600);
      dd.setVisible(false);
      dd.setOnAction(this::processButtonPress);
      root.getChildren().add(dd);
      //leave button
      exit= new Button("EXIT");
      exit.setStyle("-fx-font:20 arial");
      exit.setLayoutX(20);
      exit.setLayoutY(600);
      exit.setVisible(false);
      exit.setOnAction(this::processButtonPress);
      root.getChildren().add(exit);
      //plus button
      plus= new Button("+");
      plus.setStyle("-fx-font:20 arial");
      plus.setLayoutX(690);
      plus.setLayoutY(520);
      plus.setVisible(false);   
      plus.setOnAction(this::processButtonPress);
      root.getChildren().add(plus);
      //minus button
      minus= new Button("-");
      minus.setStyle("-fx-font:20 arial");
      minus.setLayoutX(600);
      minus.setLayoutY(520);
      minus.setVisible(false);   
      minus.setOnAction(this::processButtonPress);
      root.getChildren().add(minus);
      //End Round
      after = new Text();      
      after.setVisible(false);
      after.setFill(Color.BLACK);
      after.setFont(Font.font(null, FontWeight.BOLD, 20));
      root.getChildren().add(after);
      //split button
      split= new Button("SPLIT");
      split.setStyle("-fx-font:20 arial");
      split.setLayoutX(625);
      split.setLayoutY(650);
      split.setVisible(false);
      split.setOnAction(this::processButtonPress);
      root.getChildren().add(split);
   
      /*
      Text---------------------------------
      */
      
      // game logo
      DropShadow ds = new DropShadow();
      ds.setOffsetY(3.0);
      ds.setColor(Color.color(0.4, 0.4, 0.4));
      t = new Text();
      t.setEffect(ds);
      t.setCache(true);
      t.setX(20.0);
      t.setY(30.0);
      t.setCache(true);
      t.setText("BLACKJAVA");
      t.setFill(Color.BLACK);
      t.setFont(Font.font(null, FontWeight.BOLD, 30));
      root.getChildren().add(t);
      // part of game logo(just below)
      t3 = new Text();
      t3.setX(30.0);
      t3.setY(50.0);
      t3.setCache(true);
      t3.setText("50 dollar bet minimum");
      t3.setFill(Color.BLACK);
      t3.setFont(Font.font(null, FontWeight.BOLD, 15));
      root.getChildren().add(t3);
      // start of game 
      intro = new Text();
      intro.setX(278);
      intro.setY(188);      
      intro.setText("Please Enter Your Name: ");
      intro.setFill(Color.BLACK);
      intro.setFont(Font.font(null, FontWeight.BOLD, 20));
      root.getChildren().add(intro);
      intro2 = new Text();
      root.getChildren().add(intro2);
      // displayed amount for the cards (user)
      count = new Text();
      count.setX(280);
      count.setY(300);      
      count.setFill(Color.WHITE);
      count.setFont(Font.font(null, FontWeight.BOLD, 25));
      root.getChildren().add(count);
      count.setVisible(false);
      // displayed amount for the cards, duing a split (user)
      countS = new Text();     
      countS.setFill(Color.WHITE);
      countS.setFont(Font.font(null, FontWeight.BOLD, 25));
      root.getChildren().add(countS);
      countS.setVisible(false); 
      // displayed amount for the cards (dealer)
      dCount = new Text();
      dCount.setX(280);
      dCount.setY(200);      
      dCount.setFill(Color.WHITE);
      dCount.setFont(Font.font(null, FontWeight.BOLD, 25));
      root.getChildren().add(dCount);
      dCount.setVisible(false);
      // displaying users stack
      pot = new Text();
      pot.setX(460);
      pot.setY(460);  
      pot.setText("Stack: 500");    
      pot.setFill(Color.WHITE);
      pot.setFont(Font.font(null, FontWeight.BOLD, 15));
      root.getChildren().add(pot);
      pot.setVisible(false);
      // chips (bet)
      chips = new Text();
      chips.setX(380);
      chips.setY(460);
      chips.setFill(Color.BLACK);
      chips.setFont(Font.font(null, FontWeight.BOLD, 15));
      root.getChildren().add(chips);  
      chips.setVisible(false); 
      
      
      /*
      Player Stuff--------------------------------------------
      */
      master = new Deck();
      dealer = new Hand();
      splitt = new Hand();
      
      /*
      Images--------------------------------------------------
      */
      
      //CLUBS
      clubsK = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_13.jpg");
      clubsQ = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_12.jpg");
      clubsJ = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_11.jpg");
      clubs10 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_10.jpg");
      clubs9 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_9.jpg");
      clubs8 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_8.jpg");
      clubs7 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_7.jpg");
      clubs6 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_6.jpg");
      clubs5 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_5.jpg");
      clubs4 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_4.jpg");
      clubs3 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_3.jpg");
      clubs2 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_2.jpg");
      clubs1 = new Image("file:///Users/jasonlalonde/Desktop/Clubs%20/Clubs_1.jpg");
      //HEARTS
      heartsK = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_13.jpg");
      heartsQ = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_12.jpg");
      heartsJ = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_11.jpg");
      hearts10 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_10.jpg");
      hearts9 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_9.jpg");
      hearts8 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_8.jpg");
      hearts7 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_7.jpg");
      hearts6 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_6.jpg");
      hearts5 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_5.jpg");
      hearts4 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_4.jpg");
      hearts3 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_3.jpg");
      hearts2 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_2.jpg");
      hearts1 = new Image("file:///Users/jasonlalonde/Desktop/Hearts/Hearts_1.jpg");
      //DIAMONDS
      diaK = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_13.jpg");
      diaQ = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_12.jpg");
      diaJ = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_11.jpg");
      dia10 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_10.jpg");
      dia9 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_9.jpg");
      dia8 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_8.jpg");
      dia7 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_7.jpg");
      dia6 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_6.jpg");
      dia5 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_5.jpg");
      dia4 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_4.jpg");
      dia3 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_3.jpg");
      dia2 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_2.jpg");
      dia1 = new Image("file:///Users/jasonlalonde/Desktop/Diamonds/Diamonds_1.jpg");
      //SPADES
      spaK = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_13.jpg");
      spaQ = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_12.jpg");
      spaJ = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_11.jpg");
      spa10 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_10.jpg");
      spa9 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_9.jpg");
      spa8 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_8.jpg");
      spa7 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_7.jpg");
      spa6 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_6.jpg");
      spa5 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_5.jpg");
      spa4 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_4.jpg");
      spa3 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_3.jpg");
      spa2 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_2.jpg");
      spa1 = new Image("file:///Users/jasonlalonde/Desktop/Spades/Spades_1.jpg");
      // BACKSIDE CARD IMAGE  reference-  https://www.pinterest.com/pin/100979216620772389/
      image3 = new Image("file:///Users/jasonlalonde/Desktop/Pictures/Mandolin_BACK.jpg");
      
      /*
      Other Images and ImageView objects---------------------------
      */

      //CHIPS IMAGE reference-  http://www.medx-ray.com/page/2/
      Image image = new Image("file:///Users/jasonlalonde/Desktop/Pictures/chips.png");
      v = new ImageView();
      v.setImage(image);
      v.setX(440);
      v.setY(460);
      v.translateYProperty();
      v.setVisible(false);
      root.getChildren().add(v); 
      // COIN EXIT IMAGE reference-  https://giphy.com/gifs/money-coins-PqVBpJna7r8Gs
      Image image1 = new Image("file:///Users/jasonlalonde/Desktop/Pictures/Coins.gif");
      C1 = new ImageView();
      C1.setImage(image1); 
      C1.setX(0);
      C1.setY(0);
      C1.translateYProperty();
      C1.setVisible(false); // setting visible to false
      root.getChildren().add(C1);
      // exit text (needs to be below exit image)
      t1 = new Text();
      t1.setX(80);
      t1.setY(220);      
      t1.setText("THANKS FOR PLAYING :)");
      t1.setFill(Color.BLACK);
      t1.setFont(Font.font(null, FontWeight.BOLD, 30));
      t1.setVisible(false);
      root.getChildren().add(t1); 
      // exit text (needs to be below exit image)
      t2 = new Text();
      t2.setX(80);
      t2.setY(280);      
      t2.setText("(Click anywhere to close)");
      t2.setFill(Color.BLACK);
      t2.setFont(Font.font(null, FontWeight.BOLD, 15));
      t2.setVisible(false);
      root.getChildren().add(t2);
      // exit text (needs to be below exit image)
      fini = new Text();
      fini.setX(80);
      fini.setY(250);      
      fini.setFill(Color.BLACK);
      fini.setFont(Font.font(null, FontWeight.BOLD, 20));
      fini.setVisible(false);
      root.getChildren().add(fini);
       
      //CHIPS CASE IMAGE reference-  http://cvphotocasino.com/services/casino-rental-party-and-supplies/blackjack-table-rentals/
      Image image2 = new Image("file:///Users/jasonlalonde/Desktop/Pictures/ChipsCase.jpg");
      v1 = new ImageView();
      v1.setImage(image2);
      v1.setX(300);
      v1.setY(0);
      v1.translateYProperty();
      v1.setVisible(true);
      root.getChildren().add(v1);
      
      //pointer image  reference-  https://www.iconfinder.com/icons/27880/arrow_red_up_icon
      Image pointer = new Image("file:///Users/jasonlalonde/Desktop/Pictures/pointer.png");
      pnt= new ImageView();
      pnt.setImage(pointer);
      pnt.setVisible(false);
      root.getChildren().add(pnt);

      /*
      Size of the group (mouse click)------------------------------------------
      */
      cnt= root.getChildren().size();
      check2=false;
      scene.setOnMousePressed(this::processMousePressed);
      
      /*
      Stage-------------------------------------------------------
      */
      
      //stage 
      primaryStage.setTitle("BlackJackDemo");
      primaryStage.setResizable(false);
      primaryStage.setScene(scene);
      primaryStage.show();
  }
  
  //remove cards method
  //removes everything put of the board other then the orginal starting screen
  public void removeCards(int s){
      int difference= s-cnt; // everything on screen minus the orginal screen equals difference 
      for(int i=1; i<=difference; i++){ 
         root.getChildren().remove(s-i); //removes from the top of root
      }
  }
  
  //Show Card Method 
  /*This method should take in a card to be shown(from a deal/hit), 
  a String (p or d) so you can know who to play it for, and 
  an int so we can properly offset the image when displaying.
  Also deals with a double down, if the int coming in is a -1 then the 
  card gets displayed sideways. Furthermore, creates a new ImageView because
  there can be the same card on the table at one time.
  */
  public void showCard(Card c, String player, int num) { 
      //CLUBS
      if(c.getSuit().equals("clubs")) { //Card suit equals clubs
         if(c.getID().equals("Ace")) { // Card id equlas Ace
            if(player.equals("d")) { // playing for the dealer
               //regular (hit/deal), dealer cannot double down
               ImageView c1 = new ImageView();
               c1.setImage(clubs1);
               root.getChildren().add(c1);
               int number= num*20; // off setting the images
               c1.setY(80);
               c1.setX(330+number);
               c1.setVisible(true);
            }
            else if(player.equals("p")) { //playing for the user
               ImageView c1 = new ImageView(); 
               root.getChildren().add(c1); 
               c1.setImage(clubs1);
               if(num==-1){ // double down was clicked
                  c1.setY(240);
                  c1.setX(420);
                  c1.setRotate(90); // rotating the card
               }
               else{ //regular (hit/deal)
                  int number = num*20; //off setting the cards
                  c1.setY(290);
                  c1.setX(330+number);
               }
               c1.setVisible(true);
            }
         }
      } 
      /*
      comments are the same for the rest of the code in this method,
      checks for clubs, spades, diamonds, and hearts (from 1-13). 
      (Checks all 52 cards) 
      */
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("2")) {
            if(player.equals("d")) {
               ImageView c2 = new ImageView();
               c2.setImage(clubs2);
               root.getChildren().add(c2);
               int number = num*20;
               c2.setY(80);
               c2.setX(330+number);
               c2.setVisible(true);
            }
            else if(player.equals("p")) { 
               ImageView c2 = new ImageView();
               c2.setImage(clubs2);
               root.getChildren().add(c2); 
               if(num==-1){
                  c2.setY(240);
                  c2.setX(420);
                  c2.setRotate(90);
               }
               else{
                  int number = num*20;
                  c2.setY(290);
                  c2.setX(330+number);
               }                
               c2.setVisible(true);
            } 
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("3")) {
             if(player.equals("d")) {
               ImageView c3 = new ImageView();
               c3.setImage(clubs3);
               root.getChildren().add(c3);
               int number = num*20;
               c3.setY(80);
               c3.setX(330+number);
               c3.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView c3 = new ImageView(); 
               root.getChildren().add(c3); 
               c3.setImage(clubs3);
               if(num==-1){
                  c3.setY(240);
                  c3.setX(420);
                  c3.setRotate(90);
               }
               else{
                  int number = num*20;
                  c3.setY(290);
                  c3.setX(330+number);
               }
               c3.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("4")) {
             if(player.equals("d")) {
               ImageView c4 = new ImageView();
               c4.setImage(clubs4);
               root.getChildren().add(c4);
               int number = num*20;
               c4.setY(80);
               c4.setX(330+number);
               c4.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView c4 = new ImageView(); 
               root.getChildren().add(c4); 
               c4.setImage(clubs4);
               if(num==-1){
                  c4.setY(240);
                  c4.setX(420);
                  c4.setRotate(90);
               }
               else{
                  int number = num*20;
                  c4.setY(290);
                  c4.setX(330+number);
               }
               c4.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("5")) {
             if(player.equals("d")) {
               ImageView c5 = new ImageView();
               c5.setImage(clubs5);
               root.getChildren().add(c5);
               int number = num*20;
               c5.setY(80);
               c5.setX(330+number);
               c5.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView c5 = new ImageView(); 
               root.getChildren().add(c5); 
               c5.setImage(clubs5);
               if(num==-1){
                  c5.setY(240);
                  c5.setX(420);
                  c5.setRotate(90);
               }
               else{
                  int number = num*20;
                  c5.setY(290);
                  c5.setX(330+number);
               }
               c5.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("6")) {
           if(player.equals("d")) {
               ImageView c6 = new ImageView();
               c6.setImage(clubs6);
               root.getChildren().add(c6);
               int number = num*20;
               c6.setY(80);
               c6.setX(330+number);
               c6.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView c6 = new ImageView(); 
               root.getChildren().add(c6); 
               c6.setImage(clubs6);
               if(num==-1){
                  c6.setY(240);
                  c6.setX(420);
                  c6.setRotate(90);
               }
               else{
                  int number = num*20;
                  c6.setY(290);
                  c6.setX(330+number);
               }
               c6.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("7")) {
             if(player.equals("d")) {
               ImageView c7 = new ImageView();
               c7.setImage(clubs7);
               root.getChildren().add(c7);
               int number = num*20;
               c7.setY(80);
               c7.setX(330+number);
               c7.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView c7 = new ImageView(); 
               root.getChildren().add(c7); 
               c7.setImage(clubs7);
               if(num==-1){
                  c7.setY(240);
                  c7.setX(420);
                  c7.setRotate(90);
               }
               else{
                  int number = num*20;
                  c7.setY(290);
                  c7.setX(330+number);
               }
               c7.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("8")) {
             if(player.equals("d")) {
               ImageView c8 = new ImageView();
               c8.setImage(clubs8);
               root.getChildren().add(c8);
               int number = num*20;
               c8.setY(80);
               c8.setX(330+number);
               c8.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView c8 = new ImageView(); 
               root.getChildren().add(c8); 
               c8.setImage(clubs8);
               if(num==-1){
                  c8.setY(240);
                  c8.setX(420);
                  c8.setRotate(90);
               }
               else{
                  int number = num*20;
                  c8.setY(290);
                  c8.setX(330+number);
               }
               c8.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("9")) {
             if(player.equals("d")) {
               ImageView c9 = new ImageView();
               c9.setImage(clubs9);
               root.getChildren().add(c9);
               int number = num*20;
               c9.setY(80);
               c9.setX(330+number);
               c9.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView c9 = new ImageView(); 
               root.getChildren().add(c9); 
               c9.setImage(clubs9);
               if(num==-1){
                  c9.setY(240);
                  c9.setX(420);
                  c9.setRotate(90);
               }
               else{
                  int number = num*20;
                  c9.setY(290);
                  c9.setX(330+number);
               }
               c9.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("10")) {
             if(player.equals("d")) {
               ImageView c10 = new ImageView();
               c10.setImage(clubs10);
               root.getChildren().add(c10);
               int number = num*20;
               c10.setY(80);
               c10.setX(330+number);
               c10.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView c10 = new ImageView(); 
               root.getChildren().add(c10); 
               c10.setImage(clubs10);
               if(num==-1){
                  c10.setY(240);
                  c10.setX(420);
                  c10.setRotate(90);
               }
               else{
                  int number = num*20;
                  c10.setY(290);
                  c10.setX(330+number);
               }
               c10.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("Jack")) {
             if(player.equals("d")) {
               ImageView cJ = new ImageView();
               cJ.setImage(clubsJ);
               root.getChildren().add(cJ);
               int number = num*20;
               cJ.setY(80);
               cJ.setX(330+number);
               cJ.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView cJ = new ImageView(); 
               root.getChildren().add(cJ); 
               cJ.setImage(clubsJ);
               if(num==-1){
                  cJ.setY(240);
                  cJ.setX(420);
                  cJ.setRotate(90);
               }
               else{
                  int number = num*20;
                  cJ.setY(290);
                  cJ.setX(330+number);
               }
               cJ.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("Queen")) {
             if(player.equals("d")) {
               ImageView cQ = new ImageView();
               cQ.setImage(clubsQ);
               root.getChildren().add(cQ);
               int number = num*20;
               cQ.setY(80);
               cQ.setX(330+number);
               cQ.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView cQ = new ImageView(); 
               root.getChildren().add(cQ); 
               cQ.setImage(clubsQ);
               if(num==-1){
                  cQ.setY(240);
                  cQ.setX(420);
                  cQ.setRotate(90);
               }
               else{
                  int number = num*20;
                  cQ.setY(290);
                  cQ.setX(330+number);
               }
               cQ.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("clubs")) {
         if(c.getID().equals("King")) {
             if(player.equals("d")) {
               ImageView cK = new ImageView();
               cK.setImage(clubsK);
               root.getChildren().add(cK);
               int number = num*20;
               cK.setY(80);
               cK.setX(330+number);
               cK.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView cK = new ImageView(); 
               root.getChildren().add(cK); 
               cK.setImage(clubsK);
               if(num==-1){
                  cK.setY(240);
                  cK.setX(420);
                  cK.setRotate(90);
               }
               else{
                  int number = num*20;
                  cK.setY(290);
                  cK.setX(330+number);
               }
               cK.setVisible(true);
            }
         }
      }
      //SPADES
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("Ace")) {
            if(player.equals("d")) {
               ImageView s1 = new ImageView();
               s1.setImage(spa1);
               root.getChildren().add(s1);
               int number = num*20;
               s1.setY(80);
               s1.setX(330+number);
               s1.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView s1 = new ImageView(); 
               root.getChildren().add(s1); 
               s1.setImage(spa1);
               if(num==-1){
                  s1.setY(240);
                  s1.setX(420);
                  s1.setRotate(90);
               }
               else{
                  int number = num*20;
                  s1.setY(290);
                  s1.setX(330+number);
               }
               s1.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("2")) {
            if(player.equals("d")) {
               ImageView s2 = new ImageView();
               s2.setImage(spa2);
               root.getChildren().add(s2);
               int number = num*20;
               s2.setY(80);
               s2.setX(330+number);
               s2.setVisible(true);
            }
            else if(player.equals("p")) { 
               ImageView s2 = new ImageView();
               s2.setImage(spa2);
               root.getChildren().add(s2); 
               if(num==-1){
                  s2.setY(240);
                  s2.setX(420);
                  s2.setRotate(90);
               }
               else{
                  int number = num*20;
                  s2.setY(290);
                  s2.setX(330+number);
               }                
               s2.setVisible(true);
            } 
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("3")) {
             if(player.equals("d")) {
               ImageView s3 = new ImageView();
               s3.setImage(spa3);
               root.getChildren().add(s3);
               int number = num*20;
               s3.setY(80);
               s3.setX(330+number);
               s3.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView s3 = new ImageView(); 
               root.getChildren().add(s3); 
               s3.setImage(spa3);
               if(num==-1){
                  s3.setY(240);
                  s3.setX(420);
                  s3.setRotate(90);
               }
               else{
                  int number = num*20;
                  s3.setY(290);
                  s3.setX(330+number);
               }
               s3.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("4")) {
             if(player.equals("d")) {
               ImageView s4 = new ImageView();
               s4.setImage(spa4);
               root.getChildren().add(s4);
               int number = num*20;
               s4.setY(80);
               s4.setX(330+number);
               s4.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView s4 = new ImageView(); 
               root.getChildren().add(s4); 
               s4.setImage(spa4);
               if(num==-1){
                  s4.setY(240);
                  s4.setX(420);
                  s4.setRotate(90);
               }
               else{
                  int number = num*20;
                  s4.setY(290);
                  s4.setX(330+number);
               }
               s4.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("5")) {
             if(player.equals("d")) {
               ImageView s5 = new ImageView();
               s5.setImage(spa5);
               root.getChildren().add(s5);
               int number = num*20;
               s5.setY(80);
               s5.setX(330+number);
               s5.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView s5 = new ImageView(); 
               root.getChildren().add(s5); 
               s5.setImage(spa5);
               if(num==-1){
                  s5.setY(240);
                  s5.setX(420);
                  s5.setRotate(90);
               }
               else{
                  int number = num*20;
                  s5.setY(290);
                  s5.setX(330+number);
               }
               s5.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("6")) {
           if(player.equals("d")) {
               ImageView s6 = new ImageView();
               s6.setImage(spa6);
               root.getChildren().add(s6);
               int number = num*20;
               s6.setY(80);
               s6.setX(330+number);
               s6.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView s6 = new ImageView(); 
               root.getChildren().add(s6); 
               s6.setImage(spa6);
               if(num==-1){
                  s6.setY(240);
                  s6.setX(420);
                  s6.setRotate(90);
               }
               else{
                  int number = num*20;
                  s6.setY(290);
                  s6.setX(330+number);
               }
               s6.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("7")) {
             if(player.equals("d")) {
               ImageView s7 = new ImageView();
               s7.setImage(spa7);
               root.getChildren().add(s7);
               int number = num*20;
               s7.setY(80);
               s7.setX(330+number);
               s7.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView s7 = new ImageView(); 
               root.getChildren().add(s7); 
               s7.setImage(spa7);
               if(num==-1){
                  s7.setY(240);
                  s7.setX(420);
                  s7.setRotate(90);
               }
               else{
                  int number = num*20;
                  s7.setY(290);
                  s7.setX(330+number);
               }
               s7.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("8")) {
             if(player.equals("d")) {
               ImageView s8 = new ImageView();
               s8.setImage(spa8);
               root.getChildren().add(s8);
               int number = num*20;
               s8.setY(80);
               s8.setX(330+number);
               s8.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView s8 = new ImageView(); 
               root.getChildren().add(s8); 
               s8.setImage(spa8);
               if(num==-1){
                  s8.setY(240);
                  s8.setX(420);
                  s8.setRotate(90);
               }
               else{
                  int number = num*20;
                  s8.setY(290);
                  s8.setX(330+number);
               }
               s8.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("9")) {
             if(player.equals("d")) {
               ImageView s9 = new ImageView();
               s9.setImage(spa9);
               root.getChildren().add(s9);
               int number = num*20;
               s9.setY(80);
               s9.setX(330+number);
               s9.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView s9 = new ImageView(); 
               root.getChildren().add(s9); 
               s9.setImage(spa9);
               if(num==-1){
                  s9.setY(240);
                  s9.setX(420);
                  s9.setRotate(90);
               }
               else{
                  int number = num*20;
                  s9.setY(290);
                  s9.setX(330+number);
               }
               s9.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("10")) {
             if(player.equals("d")) {
               ImageView s10 = new ImageView();
               s10.setImage(spa10);
               root.getChildren().add(s10);
               int number = num*20;
               s10.setY(80);
               s10.setX(330+number);
               s10.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView s10 = new ImageView(); 
               root.getChildren().add(s10); 
               s10.setImage(spa10);
               if(num==-1){
                  s10.setY(240);
                  s10.setX(420);
                  s10.setRotate(90);
               }
               else{
                  int number = num*20;
                  s10.setY(290);
                  s10.setX(330+number);
               }
               s10.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("Jack")) {
             if(player.equals("d")) {
               ImageView sJ = new ImageView();
               sJ.setImage(spaJ);
               root.getChildren().add(sJ);
               int number = num*20;
               sJ.setY(80);
               sJ.setX(330+number);
               sJ.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView sJ = new ImageView(); 
               root.getChildren().add(sJ); 
               sJ.setImage(spaJ);
               if(num==-1){
                  sJ.setY(240);
                  sJ.setX(420);
                  sJ.setRotate(90);
               }
               else{
                  int number = num*20;
                  sJ.setY(290);
                  sJ.setX(330+number);
               }
               sJ.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("Queen")) {
             if(player.equals("d")) {
               ImageView sQ = new ImageView();
               sQ.setImage(spaQ);
               root.getChildren().add(sQ);
               int number = num*20;
               sQ.setY(80);
               sQ.setX(330+number);
               sQ.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView sQ = new ImageView(); 
               root.getChildren().add(sQ); 
               sQ.setImage(spaQ);
               if(num==-1){
                  sQ.setY(240);
                  sQ.setX(420);
                  sQ.setRotate(90);
               }
               else{
                  int number = num*20;
                  sQ.setY(290);
                  sQ.setX(330+number);
               }
               sQ.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Spade")) {
         if(c.getID().equals("King")) {
             if(player.equals("d")) {
               ImageView sK = new ImageView();
               sK.setImage(spaK);
               root.getChildren().add(sK);
               int number = num*20;
               sK.setY(80);
               sK.setX(330+number);
               sK.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView sK = new ImageView(); 
               root.getChildren().add(sK); 
               sK.setImage(spaK);
               if(num==-1){
                  sK.setY(240);
                  sK.setX(420);
                  sK.setRotate(90);
               }
               else{
                  int number = num*20;
                  sK.setY(290);
                  sK.setX(330+number);
               }
               sK.setVisible(true);
            }
         }
      }
      //DIAMONDS
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("Ace")) {
            if(player.equals("d")) {
               ImageView d1 = new ImageView();
               d1.setImage(dia1);
               root.getChildren().add(d1);
               int number = num*20;
               d1.setY(80);
               d1.setX(330+number);
               d1.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView d1 = new ImageView(); 
               root.getChildren().add(d1); 
               d1.setImage(dia1);
               if(num==-1){
                  d1.setY(240);
                  d1.setX(420);
                  d1.setRotate(90);
               }
               else{
                  int number = num*20;
                  d1.setY(290);
                  d1.setX(330+number);
               }
               d1.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("2")) {
            if(player.equals("d")) {
               ImageView d2 = new ImageView();
               d2.setImage(dia2);
               root.getChildren().add(d2);
               int number = num*20;
               d2.setY(80);
               d2.setX(330+number);
               d2.setVisible(true);
            }
            else if(player.equals("p")) { 
               ImageView d2 = new ImageView();
               d2.setImage(dia2);
               root.getChildren().add(d2); 
               if(num==-1){
                  d2.setY(240);
                  d2.setX(420);
                  d2.setRotate(90);
               }
               else{
                  int number = num*20;
                  d2.setY(290);
                  d2.setX(330+number);
               }                
               d2.setVisible(true);
            } 
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("3")) {
             if(player.equals("d")) {
               ImageView d3 = new ImageView();
               d3.setImage(dia3);
               root.getChildren().add(d3);
               int number = num*20;
               d3.setY(80);
               d3.setX(330+number);
               d3.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView d3 = new ImageView(); 
               root.getChildren().add(d3); 
               d3.setImage(dia3);
               if(num==-1){
                  d3.setY(240);
                  d3.setX(420);
                  d3.setRotate(90);
               }
               else{
                  int number = num*20;
                  d3.setY(290);
                  d3.setX(330+number);
               }
               d3.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("4")) {
             if(player.equals("d")) {
               ImageView d4 = new ImageView();
               d4.setImage(dia4);
               root.getChildren().add(d4);
               int number = num*20;
               d4.setY(80);
               d4.setX(330+number);
               d4.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView d4 = new ImageView(); 
               root.getChildren().add(d4); 
               d4.setImage(dia4);
               if(num==-1){
                  d4.setY(240);
                  d4.setX(420);
                  d4.setRotate(90);
               }
               else{
                  int number = num*20;
                  d4.setY(290);
                  d4.setX(330+number);
               }
               d4.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("5")) {
            if(player.equals("d")) {
               ImageView d5 = new ImageView();
               d5.setImage(dia5);
               root.getChildren().add(d5);
               int number = num*20;
               d5.setY(80);
               d5.setX(330+number);
               d5.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView d5 = new ImageView(); 
               root.getChildren().add(d5); 
               d5.setImage(dia5);
               if(num==-1){
                  d5.setY(240);
                  d5.setX(420);
                  d5.setRotate(90);
               }
               else{
                  int number = num*20;
                  d5.setY(290);
                  d5.setX(330+number);
               }
               d5.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("6")) {
           if(player.equals("d")) {
               ImageView d6 = new ImageView();
               d6.setImage(dia6);
               root.getChildren().add(d6);
               int number = num*20;
               d6.setY(80);
               d6.setX(330+number);
               d6.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView d6 = new ImageView(); 
               root.getChildren().add(d6); 
               d6.setImage(dia6);
               if(num==-1){
                  d6.setY(240);
                  d6.setX(420);
                  d6.setRotate(90);
               }
               else{
                  int number = num*20;
                  d6.setY(290);
                  d6.setX(330+number);
               }
               d6.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("7")) {
             if(player.equals("d")) {
               ImageView d7 = new ImageView();
               d7.setImage(dia7);
               root.getChildren().add(d7);
               int number = num*20;
               d7.setY(80);
               d7.setX(330+number);
               d7.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView d7 = new ImageView(); 
               root.getChildren().add(d7); 
               d7.setImage(dia7);
               if(num==-1){
                  d7.setY(240);
                  d7.setX(420);
                  d7.setRotate(90);
               }
               else{
                  int number = num*20;
                  d7.setY(290);
                  d7.setX(330+number);
               }
               d7.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("8")) {
             if(player.equals("d")) {
               ImageView d8 = new ImageView();
               d8.setImage(dia8);
               root.getChildren().add(d8);
               int number = num*20;
               d8.setY(80);
               d8.setX(330+number);
               d8.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView d8 = new ImageView(); 
               root.getChildren().add(d8); 
               d8.setImage(dia8);
               if(num==-1){
                  d8.setY(240);
                  d8.setX(420);
                  d8.setRotate(90);
               }
               else{
                  int number = num*20;
                  d8.setY(290);
                  d8.setX(330+number);
               }
               d8.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("9")) {
             if(player.equals("d")) {
               ImageView d9 = new ImageView();
               d9.setImage(dia9);
               root.getChildren().add(d9);
               int number = num*20;
               d9.setY(80);
               d9.setX(330+number);
               d9.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView d9 = new ImageView(); 
               root.getChildren().add(d9); 
               d9.setImage(dia9);
               if(num==-1){
                  d9.setY(240);
                  d9.setX(420);
                  d9.setRotate(90);
               }
               else{
                  int number = num*20;
                  d9.setY(290);
                  d9.setX(330+number);
               }
               d9.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("10")) {
             if(player.equals("d")) {
               ImageView d10 = new ImageView();
               d10.setImage(dia10);
               root.getChildren().add(d10);
               int number = num*20;
               d10.setY(80);
               d10.setX(330+number);
               d10.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView d10 = new ImageView(); 
               root.getChildren().add(d10); 
               d10.setImage(dia10);
               if(num==-1){
                  d10.setY(240);
                  d10.setX(420);
                  d10.setRotate(90);
               }
               else{
                  int number = num*20;
                  d10.setY(290);
                  d10.setX(330+number);
               }
               d10.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("Jack")) {
             if(player.equals("d")) {
               ImageView dJ = new ImageView();
               dJ.setImage(diaJ);
               root.getChildren().add(dJ);
               int number = num*20;
               dJ.setY(80);
               dJ.setX(330+number);
               dJ.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView dJ = new ImageView(); 
               root.getChildren().add(dJ); 
               dJ.setImage(diaJ);
              if(num==-1){
                  dJ.setY(240);
                  dJ.setX(420);
                  dJ.setRotate(90);
               }
               else{
                  int number = num*20;
                  dJ.setY(290);
                  dJ.setX(330+number);
               }
               dJ.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("Queen")) {
             if(player.equals("d")) {
               ImageView dQ = new ImageView();
               dQ.setImage(diaQ);
               root.getChildren().add(dQ);
               int number = num*20;
               dQ.setY(80);
               dQ.setX(330+number);
               dQ.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView dQ = new ImageView(); 
               root.getChildren().add(dQ); 
               dQ.setImage(diaQ);
               if(num==-1){
                  dQ.setY(240);
                  dQ.setX(420);
                  dQ.setRotate(90);
               }
               else{
                  int number = num*20;
                  dQ.setY(290);
                  dQ.setX(330+number);
               }
               dQ.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("Diamond")) {
         if(c.getID().equals("King")) {
             if(player.equals("d")) {
               ImageView dK = new ImageView();
               dK.setImage(diaK);
               root.getChildren().add(dK);
               int number = num*20;
               dK.setY(80);
               dK.setX(330+number);
               dK.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView dK = new ImageView(); 
               root.getChildren().add(dK); 
               dK.setImage(diaK);
               if(num==-1){
                  dK.setY(240);
                  dK.setX(420);
                  dK.setRotate(90);
               }
               else{
                  int number = num*20;
                  dK.setY(290);
                  dK.setX(330+number);
               }
               dK.setVisible(true);
            }
         }
      }
      //HEARTS
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("Ace")) {
            if(player.equals("d")) {
               ImageView h1 = new ImageView();
               h1.setImage(hearts1);
               root.getChildren().add(h1);
               int number = num*20;
               h1.setY(80);
               h1.setX(330+number);
               h1.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView h1 = new ImageView(); 
               root.getChildren().add(h1); 
               h1.setImage(hearts1);
               if(num==-1){
                  h1.setY(240);
                  h1.setX(420);
                  h1.setRotate(90);
               }
               else{
                  int number = num*20;
                  h1.setY(290);
                  h1.setX(330+number);
               }
               h1.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("2")) {
            if(player.equals("d")) {
               ImageView h2 = new ImageView();
               h2.setImage(hearts2);
               root.getChildren().add(h2);
               int number = num*20;
               h2.setY(80);
               h2.setX(330+number);
               h2.setVisible(true);
            }
            else if(player.equals("p")) { 
               ImageView h2 = new ImageView();
               h2.setImage(hearts2);
               root.getChildren().add(h2); 
               if(num==-1){
                  h2.setY(240);
                  h2.setX(420);
                  h2.setRotate(90);
               }
               else{
                  int number = num*20;
                  h2.setY(290);
                  h2.setX(330+number);
               }               
               h2.setVisible(true);
            } 
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("3")) {
             if(player.equals("d")) {
               ImageView h3 = new ImageView();
               h3.setImage(hearts3);
               root.getChildren().add(h3);
               int number = num*20;
               h3.setY(80);
               h3.setX(330+number);
               h3.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView h3 = new ImageView(); 
               root.getChildren().add(h3); 
               h3.setImage(hearts3);
               if(num==-1){
                  h3.setY(240);
                  h3.setX(420);
                  h3.setRotate(90);
               }
               else{
                  int number = num*20;
                  h3.setY(290);
                  h3.setX(330+number);
               }
               h3.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("4")) {
             if(player.equals("d")) {
               ImageView h4 = new ImageView();
               h4.setImage(hearts4);
               root.getChildren().add(h4);
               int number = num*20;
               h4.setY(80);
               h4.setX(330+number);
               h4.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView h4 = new ImageView(); 
               root.getChildren().add(h4); 
               h4.setImage(hearts4);
               if(num==-1){
                  h4.setY(240);
                  h4.setX(420);
                  h4.setRotate(90);
               }
               else{
                  int number = num*20;
                  h4.setY(290);
                  h4.setX(330+number);
               }
               h4.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("5")) {
            if(player.equals("d")) {
               ImageView h5 = new ImageView();
               h5.setImage(hearts5);
               root.getChildren().add(h5);
               int number = num*20;
               h5.setY(80);
               h5.setX(330+number);
               h5.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView h5 = new ImageView(); 
               root.getChildren().add(h5); 
               h5.setImage(hearts5);
               if(num==-1){
                  h5.setY(240);
                  h5.setX(420);
                  h5.setRotate(90);
               }
               else{
                  int number = num*20;
                  h5.setY(290);
                  h5.setX(330+number);
               }
               h5.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("6")) {
           if(player.equals("d")) {
               ImageView h6 = new ImageView();
               h6.setImage(hearts6);
               root.getChildren().add(h6);
               int number = num*20;
               h6.setY(80);
               h6.setX(330+number);
               h6.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView h6 = new ImageView(); 
               root.getChildren().add(h6); 
               h6.setImage(hearts6);
               if(num==-1){
                  h6.setY(240);
                  h6.setX(420);
                  h6.setRotate(90);
               }
               else{
                  int number = num*20;
                  h6.setY(290);
                  h6.setX(330+number);
               }
               h6.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("7")) {
             if(player.equals("d")) {
               ImageView h7 = new ImageView();
               h7.setImage(hearts7);
               root.getChildren().add(h7);
               int number = num*20;
               h7.setY(80);
               h7.setX(330+number);
               h7.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView h7 = new ImageView(); 
               root.getChildren().add(h7); 
               h7.setImage(hearts7);
               if(num==-1){
                  h7.setY(240);
                  h7.setX(420);
                  h7.setRotate(90);
               }
               else{
                  int number = num*20;
                  h7.setY(290);
                  h7.setX(330+number);
               }
               h7.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("8")) {
             if(player.equals("d")) {
               ImageView h8 = new ImageView();
               h8.setImage(hearts8);
               root.getChildren().add(h8);
               int number = num*20;
               h8.setY(80);
               h8.setX(330+number);
               h8.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView h8 = new ImageView(); 
               root.getChildren().add(h8); 
               h8.setImage(hearts8);
               if(num==-1){
                  h8.setY(240);
                  h8.setX(420);
                  h8.setRotate(90);
               }
               else{
                  int number = num*20;
                  h8.setY(290);
                  h8.setX(330+number);
               }
               h8.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("9")) {
             if(player.equals("d")) {
               ImageView h9 = new ImageView();
               h9.setImage(hearts9);
               root.getChildren().add(h9);
               int number = num*20;
               h9.setY(80);
               h9.setX(330+number);
               h9.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView h9 = new ImageView(); 
               root.getChildren().add(h9); 
               h9.setImage(hearts9);
               if(num==-1){
                  h9.setY(240);
                  h9.setX(420);
                  h9.setRotate(90);
               }
               else{
                  int number = num*20;
                  h9.setY(290);
                  h9.setX(330+number);
               }
               h9.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("10")) {
             if(player.equals("d")) {
               ImageView h10 = new ImageView();
               h10.setImage(hearts10);
               root.getChildren().add(h10);
               int number = num*20;
               h10.setY(80);
               h10.setX(330+number);
               h10.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView h10 = new ImageView(); 
               root.getChildren().add(h10); 
               h10.setImage(hearts10);
               if(num==-1){
                  h10.setY(240);
                  h10.setX(420);
                  h10.setRotate(90);
               }
               else{
                  int number = num*20;
                  h10.setY(290);
                  h10.setX(330+number);
               }
               h10.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("Jack")) {
             if(player.equals("d")) {
               ImageView hJ = new ImageView();
               hJ.setImage(heartsJ);
               root.getChildren().add(hJ);
               int number = num*20;
               hJ.setY(80);
               hJ.setX(330+number);
               hJ.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView hJ = new ImageView(); 
               root.getChildren().add(hJ); 
               hJ.setImage(heartsJ);
               if(num==-1){
                  hJ.setY(240);
                  hJ.setX(420);
                  hJ.setRotate(90);
               }
               else{
                  int number = num*20;
                  hJ.setY(290);
                  hJ.setX(330+number);
               }
               hJ.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("Queen")) {
             if(player.equals("d")) {
               ImageView hQ = new ImageView();
               hQ.setImage(heartsQ);
               root.getChildren().add(hQ);
               int number = num*20;
               hQ.setY(80);
               hQ.setX(330+number);
               hQ.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView hQ = new ImageView(); 
               root.getChildren().add(hQ); 
               hQ.setImage(heartsQ);
               if(num==-1){
                  hQ.setY(240);
                  hQ.setX(420);
                  hQ.setRotate(90);
               }
               else{
                  int number = num*20;
                  hQ.setY(290);
                  hQ.setX(330+number);
               }
               hQ.setVisible(true);
            }
         }
      }
      if(c.getSuit().equals("hearts")) {
         if(c.getID().equals("King")) {
             if(player.equals("d")) {
               ImageView hK = new ImageView();
               hK.setImage(heartsK);
               root.getChildren().add(hK);
               int number = num*20;
               hK.setY(80);
               hK.setX(330+number);
               hK.setVisible(true);
            }
            else if(player.equals("p")) {
               ImageView hK = new ImageView(); 
               root.getChildren().add(hK); 
               hK.setImage(heartsK);
               if(num==-1){
                  hK.setY(240);
                  hK.setX(420);
                  hK.setRotate(90);
               }
               else{
                  int number = num*20;
                  hK.setY(290);
                  hK.setX(330+number);
               }
               hK.setVisible(true);
            }
         }
      }
   }//End of showCard Method
   
  //Event listener for mouse click
  public void processMousePressed(MouseEvent e){
      if(check2==true)
         Platform.exit();
  }
           
  // Event Listener for field input 
  public void processReturn(ActionEvent event) {
      //Entering a name
      if(event.getSource()==nameInput) { 
         name = nameInput.getText();
         nameInput.setVisible(false);
         p = new Player(name, 500);
         start.setVisible(true);
         intro.setX(250);
         intro.setY(188);      
         intro.setFont(Font.font(null, FontWeight.BOLD, 20));
         intro.setText("Welcome to BlackJava "+name+"!");
         intro2.setX(20);
         intro2.setY(220);      
         intro2.setText("Press the \"Start Game\" button to claim your $500 starter stack and start playing!");
         intro2.setFill(Color.BLACK);
         intro2.setFont(Font.font(null, FontWeight.BOLD, 20)); 
      }
  }
  
  //Event listeners for button clicks
  public void processButtonPress(ActionEvent event){
      //start button event
      if(event.getSource()==start){
         start.setVisible(false);
         bet.setVisible(true);
         plus.setVisible(true);
         minus.setVisible(true);
         hit.setVisible(false);
         stand.setVisible(false);
         dd.setVisible(false);
         nameInput.setVisible(false);
         intro.setVisible(false);
         exit.setVisible(true);
         v.setVisible(true);
         pot.setVisible(true);
         intro2.setX(180);
         intro2.setY(220); 
         intro2.setText("Press the \"Bet\" button to start the first round!");
         playerCards = p.getHand().getCards();
         dealerCards = dealer.getCards();
         a= splitt.getCards();
         bett=50;
         chips.setText(""+bett);
         chips.setVisible(true);
         handNum=-1;
         //reg gameplay true and prog of gameplay is false
         reg=true;
         prog=false;
      } 
      //clicking plus
      if(event.getSource()==plus) { 
         if(bett<p.getStack()){
            bett+=50;
            chips.setText(""+bett);
            chips.setVisible(true);
         }  
      }
      //clicking minus
      if(event.getSource()==minus) { 
         if(bett>50){
            bett-=50;
            chips.setText(""+bett);
            chips.setVisible(true);   
         }
      }        
      // bet button event
      if(event.getSource()==bet){
         //gameplay 
         prog=true;
         //resetting handNum to -1 if split was to happen
         handNum=-1; 
         //resetting checker if split was to happen
         checker=0;
         //resetting count position if split was to happen
         count.setX(280);
         count.setY(300);
         //resetting reg gameplay if split was to happen
         reg=true;
         after.setVisible(false);
         countS.setVisible(false);
         //checking if you can double down
         if(bett*2>p.getStack()){
            dd.setVisible(false);
         }
         else{
            dd.setVisible(true);
         }
         //size of players and dealers hand
         int playerSize = playerCards.size();
         int dealerSize = dealerCards.size();
         for(int i=(playerSize-1); i>=0; i--) {
             p.getHand().getCards().remove(i);//Remove from hand (to reset for next turn)
         }
         for(int i=dealerSize-1; i>=0; i--) {
            dealer.getCards().remove(i);//Remove from hand (to reset for next turn)
         }
         // removing cards from the screen
         removeCards(root.getChildren().size()); 
         //Re-shuffle cards into master deck
         if(master.getSize() <= 212)
            master.shuffleDeck();
         wager = bett; // wager set to users bet
         bett=50; // resetting minimum bet
         pot.setText("Stack: "+ (p.getStack()-wager)); // instantly taking wager from players stack
         for(int i=1;i<=2;i++) { //Deal the first 2 cards to player
            Card c = master.deal();//Store deal in temp variable
            showCard(c,"p",i);//Add to the visual
            p.addToHand(c);//Store in the player's hand
         }
         p.getHand().aceChecker();
         count.setText(""+p.getHand().count());
         count.setVisible(true);
         for(int i=1;i<=2;i++) { //Deal the first 2 cards to player
            Card c = master.deal();//Store deal in temp variable
            if(i==1){
               showCard(c,"d",i);
               dCount.setText(""+c.getValue());
               dCount.setVisible(true);
            }
            else{
               //THIS IS SPECIAL BECAUSE THE DEALER'S 2ND CARD SHOULD BE HIDDEN. USE THE CARD BACK PHOTO FOR THE VISUAL
               ImageView C2 = new ImageView(); 
               root.getChildren().add(C2);
               C2.setImage(image3); 
               C2.setY(80);
               C2.setX(370);
               C2.setVisible(true);
            }
            dealer.add(c);//Store the card in the dealer's hand
         }
         //players cards
         Card one = playerCards.get(0);
         Card two = playerCards.get(1);
         //if card 1 and card 2 are the same. Also you have enough money  
         if((one.getID().equals(two.getID())) && (wager*2<=p.getStack())){
            split.setVisible(true);
         }
         //Blackjack first 2 cards
         if(p.getHand().count()==21){
            count.setText("21");
            stand.setVisible(true);
            minus.setVisible(false);
            plus.setVisible(false);
            intro2.setVisible(false);
            hit.setVisible(false);
            bet.setVisible(false);
            dd.setVisible(false);
         }
         //must play
         else{
            hit.setVisible(true);
            stand.setVisible(true);
            bet.setVisible(false);
            minus.setVisible(false);
            plus.setVisible(false);
            intro2.setVisible(false);
         }
      }
      //exit button event
      if(event.getSource()==exit){
         if(prog==true){
            p.setStack(p.getStack()-wager);
         }
         v1.setVisible(false);
         C1.setVisible(true);
         nameInput.setVisible(false);
         bet.setVisible(false);
         hit.setVisible(false);
         stand.setVisible(false);
         dd.setVisible(false);
         exit.setVisible(false);
         intro.setVisible(false);
         intro2.setVisible(false);
         count.setVisible(false);
         countS.setVisible(false);
         t1.setVisible(true);
         t2.setVisible(true);
         check2=true;
         fini.setText("You finished with $"+ p.getStack());
         fini.setVisible(true);
         removeCards(root.getChildren().size());  // removing the cards on the stage   
      }
      
      //hit button event
      if(event.getSource()==hit) {
         if(reg==true){
            Card c = master.deal();//Store deal in temp variable
            showCard(c,"p",p.getHand().getCards().size() + 1);//Add to the visual
            p.addToHand(c);//Store in the player's hand
            p.getHand().aceChecker();
            dd.setVisible(false);  //cant double down after a hit
            split.setVisible(false); // cant split after a hit
            //player bust
            if(p.getHand().count()>21){
               count.setText("BUST");
               dealerCards = dealer.getCards();
               showCard(dealerCards.get(1),"d",2); //Reveal the dealer's second card
               dCount.setText(""+dealer.count());
               bet.setVisible(true);
               stand.setVisible(false);
               hit.setVisible(false);
               endRound(-1); 
               //gameplay done
               prog=false;  
            }
            // player gets 21
            else if(p.getHand().count()==21){
               count.setText("21");
               hit.setVisible(false);
            }
            //still under 21
            else{
               count.setText(""+p.getHand().count());
            }
         }
         else if(reg==false && handNum==0){
            Card c = master.deal();//Store deal in temp variable
            showCard(c,"p",p.getHand().getCards().size() -10);//Add to the visual
            p.addToHand(c);//Store in the player's hand
            p.getHand().aceChecker();
            dd.setVisible(false);
            //player bust
            if(p.getHand().count()>21){
               handNum=1;
               count.setX(180);
               count.setY(280);
               count.setText("BUST");
               pnt.setX(500);
               pnt.setY(200);
               pnt.setVisible(true);
               checker++;
            }
            // player gets 21
            else if(p.getHand().count()==21){
               count.setX(180);
               count.setY(280);
               count.setText("21");
               pnt.setX(500);
               pnt.setY(200);
               pnt.setVisible(true);
               handNum=1;
            }
            //still under 21
            else{
               count.setX(180);
               count.setY(280);
               count.setText(""+p.getHand().count());
               stand.setVisible(true);
            }
         }
         else if(reg==false && handNum==1){
            countS.setVisible(true);
            Card c = master.deal();//Store deal in temp variable
            showCard(c,"p",splitt.getCards().size() + 5);//Add to the visual
            splitt.add(c);//Store in the player's hand
            splitt.aceChecker();
            dd.setVisible(false);
            //player bust
            if(splitt.count()>21){
               countS.setX(420);
               countS.setY(280);
               countS.setText("BUST");
               checker++; 
               if(checker==2){
                  dealerCards = dealer.getCards();
                  showCard(dealerCards.get(1),"d",2); //Reveal the dealer's second card
                  dCount.setText(""+dealer.count());
                  bet.setVisible(true);
                  stand.setVisible(false);
                  hit.setVisible(false);
                  pnt.setVisible(false);
                  endRound(2);
                  prog=false;
               }
               else{
                  hit.setVisible(false);
                  stand.setVisible(false);
                  dd.setVisible(false);
                  pnt.setVisible(false);
                  dealerPlay();
                  if((((dealer.count() > splitt.count()) && (dealer.count()<=21) && (splitt.count()<=21)) || (splitt.count()>21))  && (((dealer.count() < p.getHand().count()) && (dealer.count()<=21) && (p.getHand().count()<=21)) || (dealer.count()>21)))
                     endRound(3); // 1 win (1W/1L) *****
                  else if((((dealer.count() < splitt.count()) && (dealer.count()<=21) && (splitt.count()<=21)) ||(dealer.count()>21))  && (((dealer.count() > p.getHand().count()) && (dealer.count()<=21) && (p.getHand().count()<=21)) || (p.getHand().count()>21)))
                     endRound(4); // 1 win (1L/1W) HELP
                  else if(((dealer.count() < splitt.count()) && (dealer.count()<=21) && (splitt.count()<=21)) && ((dealer.count() < p.getHand().count()) && (dealer.count()<=21) && (p.getHand().count()<=21)) || (dealer.count()>21 && p.getHand().count()<=21 && splitt.count()<=21))
                     endRound(5); // 2 wins (1W/1W) ****
                  else if((((dealer.count() < splitt.count()) && (dealer.count()<=21)) ||((dealer.count() >21) && (splitt.count() <=21))) && (dealer.count() == p.getHand().count()) && (p.getHand().count()<=21))
                     endRound(6); // 1 win (1T/1W)  ****
                  else if((((dealer.count() < p.getHand().count()) && (dealer.count()<=21)) ||((dealer.count() >21) && (p.getHand().count() <=21))) && (dealer.count() == splitt.count()) && (splitt.count()<=21))
                     endRound(7); // 1 win (1W/1T) *****
                  else if((dealer.count()==p.getHand().count()) && (dealer.count() == splitt.count()) && (splitt.count()<=21) && (p.getHand().count()<=21) && (dealer.count()<=21))
                     endRound(8); // 0 wins (1T/1T) *****
                  else if((((dealer.count() > p.getHand().count()) && (dealer.count()<=21) && (p.getHand().count()<=21)) || (p.getHand().count()>21)) && (dealer.count() == splitt.count()) && (splitt.count()<=21) && (dealer.count()<=21))
                     endRound(9); // 0 wins (1L/1T)  *****
                  else if((dealer.count() == p.getHand().count()) && (p.getHand().count()<=21) && (((dealer.count() > splitt.count()) && (dealer.count()<=21) && (splitt.count()<=21)) || (splitt.count()>21)))
                     endRound(10); // 0 wins (1T/1L)  *****
                  else if(((dealer.count() > p.getHand().count() && (p.getHand().count()<=21) && (dealer.count()<=21)) || (p.getHand().count()>21)) && ((dealer.count() > splitt.count() && (splitt.count()<=21) && (dealer.count()<=21)) || (splitt.count()>21)))
                     endRound(2); // 0 wins (1L/1L) *****
                  //gameplay done
                  prog=false;
               }                
            }
            // player gets 21
            else if(splitt.count()==21){
               countS.setX(420);
               countS.setY(280);
               countS.setText("21");
               hit.setVisible(false);
               stand.setVisible(true);
               pnt.setVisible(false);
            }
            //still under 21
            else{
               countS.setX(420);
               countS.setY(280);
               countS.setText(""+splitt.count());
               stand.setVisible(true);
            }
         }
         
      }
      // double down button
      if(event.getSource()==dd) {
            wager = 2*wager;
            split.setVisible(false);
            dd.setVisible(false);
            hit.setVisible(false);
            stand.setVisible(false);
            Card c = master.deal();//Store deal in temp variable
            showCard(c,"p",-1);//Add to the visual (diagonal- repersenting 1 card double down)
            p.addToHand(c);//Store in the player's hand
            p.getHand().aceChecker();
            if(p.getHand().count()>21){
               count.setText("BUST");
               dCount.setText(""+dealer.count());
               showCard(dealerCards.get(1),"d",2); //Reveal the dealer's second card
               endRound(-1);
               //gameplay done
               prog=false;
            }
            else{
               count.setText(""+p.getHand().count());
               dealerPlay();
               if((dealer.count() > p.getHand().count()) && (dealer.count()<=21))
                  endRound(-1);
               else if((dealer.count() < p.getHand().count()) || dealer.count()>21)
                  endRound(1);
               else 
                  endRound(0);
               //gameplay done
               prog=false;
            }
      }
      //stand button event
      if(event.getSource()==stand) {//Added the second part because after a double, you are essentially forced to stand. This will happen after when you hit double
         //Dealer has to play
         if(reg==false){
            if(handNum==1){
               hit.setVisible(false);
               stand.setVisible(false);
               dd.setVisible(false);
               pnt.setVisible(false);
               dealerPlay();
               if((((dealer.count() > splitt.count()) && (dealer.count()<=21) && (splitt.count()<=21)) || (splitt.count()>21))  && (((dealer.count() < p.getHand().count()) && (dealer.count()<=21) && (p.getHand().count()<=21)) || (dealer.count()>21)))
                  endRound(3); // 1 win (1W/1L) *****
               else if((((dealer.count() < splitt.count()) && (dealer.count()<=21) && (splitt.count()<=21)) ||(dealer.count()>21))  && (((dealer.count() > p.getHand().count()) && (dealer.count()<=21) && (p.getHand().count()<=21)) || (p.getHand().count()>21)))
                  endRound(4); // 1 win (1L/1W) help
               else if(((dealer.count() < splitt.count()) && (dealer.count()<=21) && (splitt.count()<=21)) && ((dealer.count() < p.getHand().count()) && (dealer.count()<=21) && (p.getHand().count()<=21)) || (dealer.count()>21 && p.getHand().count()<=21 && splitt.count()<=21))
                  endRound(5); // 2 wins (1W/1W) *****
               else if((((dealer.count() < splitt.count()) && (dealer.count()<=21)) ||((dealer.count() >21) && (splitt.count() <=21))) && (dealer.count() == p.getHand().count()) && (p.getHand().count()<=21))
                  endRound(6); // 1 win (1T/1W) *****
               else if((((dealer.count() < p.getHand().count()) && (dealer.count()<=21)) ||((dealer.count() >21) && (p.getHand().count() <=21))) && (dealer.count() == splitt.count()) && (splitt.count()<=21))
                  endRound(7); // 1 win (1W/1T) *****
               else if((dealer.count()==p.getHand().count()) && (dealer.count() == splitt.count()) && (splitt.count()<=21) && (p.getHand().count()<=21) && (dealer.count()<=21))
                  endRound(8); // 0 wins (1T/1T) ****
               else if((((dealer.count() > p.getHand().count()) && (dealer.count()<=21) && (p.getHand().count()<=21)) || (p.getHand().count()>21)) && (dealer.count() == splitt.count()) && (splitt.count()<=21) && (dealer.count()<=21))
                  endRound(9); // 0 wins (1L/1T) *****
               else if((dealer.count() == p.getHand().count()) && (p.getHand().count()<=21) && (((dealer.count() > splitt.count()) && (dealer.count()<=21) && (splitt.count()<=21)) || (splitt.count()>21)))
                  endRound(10); // 0 wins (1T/1L) *****
               else if(((dealer.count() > p.getHand().count() && (p.getHand().count()<=21) && (dealer.count()<=21)) || (p.getHand().count()>21)) && ((dealer.count() > splitt.count() && (splitt.count()<=21) && (dealer.count()<=21)) || (splitt.count()>21)))
                  endRound(2); // 0 wins (1L/1L) *****
               //gameplay done
               prog=false;
            }
            else{
               dd.setVisible(false);
               handNum=1;
               pnt.setX(500);
               pnt.setY(200);
               pnt.setVisible(true);
               stand.setVisible(false);
            }
         }
         else{
            split.setVisible(false);
            hit.setVisible(false);
            stand.setVisible(false);
            dd.setVisible(false);
            bet.setVisible(true);
            minus.setVisible(true);
            plus.setVisible(true);
            dealerPlay();
            if((dealer.count() > p.getHand().count()) && (dealer.count()<=21))
                endRound(-1);
            else if((dealer.count() < p.getHand().count()) || dealer.count()>21)
                endRound(1);
            else 
                endRound(0);
            //gameplay done
            prog=false;   
         }
      }//End of Stand button 
      
      //split button
      if(event.getSource()==split) {
         pnt.setX(150);
         pnt.setY(200);
         pnt.setVisible(true);
         stand.setVisible(false);
         wager=wager*2;
         handNum=0;
         checker=0;
         reg=false;
         a =p.getHand().split();
         if(a.get(0).getID().equals("Ace")){
            a.get(0).setValue(11);
            splitt= new Hand(a.get(0));
         }
         else{
            splitt= new Hand(a.get(0));
         }
         count.setX(180);
         count.setY(280);
         count.setText(""+p.getHand().count());
         countS.setX(420);
         countS.setY(280);
         countS.setText(""+splitt.count());
         countS.setVisible(true);
         // removing from orginal spot
         root.getChildren().remove(cnt+1); 
         root.getChildren().remove(cnt);
         //shifting them into a split hand
         showCard(playerCards.get(0), "p", -10); 
         showCard(a.get(0), "p", 5);
         // only one split and no dd on 1 card(can dd after you hit once) 
         split.setVisible(false);
         dd.setVisible(false);
      }    
  }//End of button result method
  
  // BlackJack Checker (1 for BlackJack, -1 for bust, 0 for nothing)
  public static int bjCheck(Hand h) {
     int result = 0;
     if (h.count() == 21)
        result = 1;
     else if (h.count() > 21)
        result = -1;
     return result;
  }
  
  // player made it so the dealer has to play his hand out
  public void dealerPlay(){
     dealerCards = dealer.getCards();
     dCount.setText(""+dealer.count());
     showCard(dealerCards.get(1),"d",2); //Reveal the dealer's second card
     boolean soft = false;//For soft 17
     boolean done = false;//Indicates when the dealer is finished playing
     while(bjCheck(dealer) == 0 && done == false) {//Dealer hasn't won or bust and is done hitting.
         if(dealer.count() < 17) {
             Card a = master.deal();
             showCard(a,"d",dealer.getCards().size() + 1);//Add to the visual
             dealer.add(a);
             dealer.aceChecker();
             if(dealer.count()>21){
               dCount.setText("BUST");
             }
             else if(dealer.count()==21){
               dCount.setText("21");
             }
             else{
               dCount.setText(""+dealer.count());
             }
          }
          else if(dealer.count() > 17){
             dCount.setText(""+dealer.count());
             done = true;
          }
          else if (dealer.count() == 17 && soft == false) {//Check for soft 17
             for(int i=0;i<dealerCards.size(); i++) {
               Card test = dealerCards.get(i);
               if(test.getValue() == 11) {//If any card in the hand is an ace worth 11
                  Card a = master.deal();
                  showCard(a,"d",dealer.getCards().size() + 1);//Add to the visual
                  dealer.add(a);
                  dealer.aceChecker();
                  dCount.setText(""+dealer.count());
                  i=dealerCards.size();
                  soft = true;
               }
             }
             if(soft == false){
               done = true; 
               dCount.setText(""+dealer.count());
             }                   
           }//End of soft 17 check
       }//End of dealer playing
   }

  //End of Round
  public void endRound(int over) {
     if(over == 0) {
        after.setText("Push. $"+wager+" returned to your stack");
        pot.setText("Stack: "+p.getStack());
        after.setX(250);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     //You hit blackjack or beat the dealer
     else if(over == 1) {
        p.setStack(p.getStack() + wager);
        pot.setText("Stack: "+p.getStack());
        after.setText("YOU WIN!! $"+wager+" added to your stack!");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     //You bust or lost to the dealer
     else if(over == -1) {
        p.setStack(p.getStack() - wager);
        pot.setText("Stack: "+p.getStack());
        after.setText("You Lose. $"+wager+" removed from your stack!");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);

     }
     // lose both in a split
     else if(over==2){
        p.setStack(p.getStack() - wager);
        pot.setText("Stack: "+p.getStack());
        after.setText("(1L/1L). $" +wager+" removed from your stack!");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     else if(over==3){
        pot.setText("Stack: "+p.getStack());
        after.setText("(1W/1L). $"+wager+" returned to your stack");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     else if(over==4){
        pot.setText("Stack: "+p.getStack());
        after.setText("(1L/1W). $"+wager+" returned to your stack");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     else if(over==5){
        p.setStack(p.getStack() + wager);
        pot.setText("Stack: "+p.getStack());
        after.setText("(1W/1W). $"+wager+" added to your stack!");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     else if(over==6){
        p.setStack(p.getStack() + wager/2);
        pot.setText("Stack: "+p.getStack());
        after.setText("(1T/1W). $"+(wager/2)+" added to your stack!");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     else if(over==7){
        p.setStack(p.getStack() + wager/2);
        pot.setText("Stack: "+p.getStack());
        after.setText("(1W/1T). $"+(wager/2)+" added to your stack!");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     else if(over==8){
        pot.setText("Stack: "+p.getStack());
        after.setText("(1T/1T). $"+wager+" returned to your stack");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     else if(over==9){
        p.setStack(p.getStack() - wager/2);
        pot.setText("Stack: "+p.getStack());
        after.setText("(1L/1T). $" +(wager/2)+" removed from your stack!");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     else if(over==10){
        p.setStack(p.getStack() - wager/2);
        pot.setText("Stack: "+p.getStack());
        after.setText("(1T/1L). $"+(wager/2)+" removed from your stack!");
        after.setX(220);
        after.setY(250);
        after.setVisible(true);
        minus.setVisible(true);
        plus.setVisible(true);
        bet.setVisible(true);
        chips.setText(""+bett);
     }
     if(p.isBroke()==true){
        after.setText("Thats the last 500 dollars I'll ever give you...");
        after.setX(230);
        after.setY(250);
        after.setVisible(true);
        bet.setVisible(false);
        minus.setVisible(false);
        plus.setVisible(false);
     }
  }//End of endRound method

  public static void main (String[]args){
     launch(args);   
  }
}
