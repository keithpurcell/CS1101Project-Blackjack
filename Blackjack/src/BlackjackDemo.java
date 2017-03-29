package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackDemo {
	/*public static ArrayList<Chip> createStack(int buyIn){
		ArrayList<Chip> stack = new ArrayList<Chip>();
		Chip Hundred = new Chip("hundred", 100);
		Chip fifty = new Chip();
		while (buyIn != 0){
			if (buyIn - 100 >= 0){
				stack.add
			}
		}
	}
	*/
	public static void main (String[] Args){
		
		String name;
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		name = kb.nextLine();
		Player player = new Player(name, 500);
		
		while (!player.isBroke()){
			
		}
	}
}
