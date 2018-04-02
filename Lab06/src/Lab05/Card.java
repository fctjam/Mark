package Lab05;

import doodlepad.*;

public class Card {
	boolean faceUp;
	Rectangle cardRec;
	
	// Constructor parameterized with x-y location of the Card’s Shape
	public Card( int x, int y) {
		cardRec = new Rectangle(x,y,20,40);
		cardRec.setFillColor(0,0,0);
		cardRec.setStrokeColor(0, 0, 255);
		faceUp = false;
	}
	
	// Flip the Card face-up or face-down
	public void flip() {
		faceUp = !faceUp;
		if (faceUp) {
			cardRec.setFillColor(255,255,255);
		} else {
			cardRec.setFillColor(0,0,0);

		}
	}
	
	boolean getFaceUp() {
		return faceUp;
	}
}
