package Lab05;

import java.util.ArrayList;
import java.util.Scanner;

public class HundredCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Card> cards = new ArrayList<Card>();
		Scanner keyboard = new Scanner(System.in);
		
		for (int i = 0; i < 100; i++) {
			// create new card using i to change x position
			Card c = new Card((i % 10) * 25, (i / 10) * 45);
			cards.add(c);
		}
		for (int i = 0; i < 100; i++) {
			//System.out.println("Iteration " + i);
			// keyboard.nextLine();
			for (int j = 0 + i; j < 100; j+=(i+1)) {
				// System.out.println("Iteration " + i + "." + j);
				cards.get(j).flip();
			}
		}
		for (int i = 0; i < 100; i++) {
			if (cards.get(i).getFaceUp())
				System.out.println("Card " + (i + 1) + " is up");
		}
	}

}
