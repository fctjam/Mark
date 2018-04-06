import java.util.ArrayList;
import java.util.List;

import doodlepad.*;

public class Simwin {

	// keep track of current player
	static int currPlayer = 0;
	
	// define shapes for points
	static ArrayList<Oval> points = new ArrayList<Oval>();
	
	// define  text box for messages
	static Text gameMessage;
	
	// define rectangle to indicate current player
	static Rectangle playerRect;
	
	// define variable to remembet last point clicked
	static Shape lastPoint;
	
	// define index of last shape clicked
	static int lastIdx = 0;
	
	// define lines already drawn
	static int lines[][] = new int[6][6];
	
	// This method sets all the shapes to the handler for starting a line
	public static void setStartLineHandlers() {
		for (int i = 0; i < 6; i++) {
			((Oval)points.get(i)).setMousePressedHandler( Simwin::startLine );
		}
	} 

	// This method sets all the shapes to the handler for ending a line
	public static void setEndLineHandlers() { 
		for (int i = 0; i < 6; i++) {
			((Oval)points.get(i)).setMousePressedHandler( Simwin::endLine );
		}
	} 
	
	// This method draws a line between two shapes
	public static void drawLine(Shape sh1, Shape sh2) { 
		// get X you coordinates for the center of the shapes
		double x1 = sh1.getCenter().getX();
		double y1 = sh1.getCenter().getY();
		double x2 = sh2.getCenter().getX();
		double y2 = sh2.getCenter().getY();	
		
		// draw a line between the points
        Line line = new Line(x1, y1, x2, y2);
        
        // set line color based on current player
        line.setStrokeColor(0, 255, 255 * currPlayer);
        
        // make liner thicker
        line.setStrokeWidth(4);
        
        // send the line to the back, so it doesn't interfere with the point events
        line.toBack();        
	}
	
	
	// method invoked when the first shape is clicked
	public static void startLine(Shape shp, double x, double y, int button) { 	
		// Fill in color for shape, using current player color.  Doing it this way will alternate between blue and green
		shp.setFillColor(0, 255, 255 * currPlayer);
		
		// remember first point selected and idex of object
		lastPoint = shp;
		lastIdx = points.indexOf(shp);
				
		// reset handlers to handle ending a line
		setEndLineHandlers();
		
		// update message to let them know they should close the line
		gameMessage.setText("Player " + (currPlayer + 1) + ": Choose second dot");
	} 

	// check if player lost after drawing a line from the passed st and end shapes
	static boolean playerLost(int stSh, int endSh) {
		System.out.println("Checking lines starting at shape " + endSh);
		// check each line drawn from the end shape, and see if there are any lines coming out for the same player
		for (int j = 0; j < 6; j++) {
			if (lines[endSh][j] == currPlayer) {
				System.out.println("Found first line[" + endSh + "][" + j + "] = " + lines[endSh][j]);
				// check if there is another line going from the end of that shape, back to the first shape, which completes a triangle
				if (lines[j][stSh] == currPlayer) {
					System.out.println("Found final line[" + j + "][" + stSh + "] = " + lines[j][stSh]);
					ArrayList<Point> polyPts = new ArrayList<Point>();
					polyPts.add(points.get(stSh).getCenter());
					polyPts.add(points.get(j).getCenter());
					polyPts.add(points.get(endSh).getCenter());
					Polygon loserPol = new Polygon(polyPts);
					loserPol.setFillColor(0, 255, 255 * currPlayer);
					return true;
					
				}
			}
		}
		
		return false;
	}
	
	// method invoked when the first shape is clicked
	public static void endLine(Shape shp, double x, double y, int button) { 
		// check current line index
		int currIdx = points.indexOf(shp);
		// if a line already exists, give an error
		if (lines[lastIdx][currIdx] >= 0) {
    		gameMessage.setText("Error: Pick different end point");
    		return;
		}
		
		// Draw a line betwwen the current shape and the last one
		drawLine(lastPoint, shp);
				
		// Clear previous shape fill
		lastPoint.setFillColor(255, 255, 255);
		
		// check if player lost
        if (playerLost(lastIdx, currIdx)) {
    		gameMessage.setText("Player " +  (currPlayer + 1)  + " ... you lost!!!");
    		return;
        }

        // add this line to this player
        lines[lastIdx][currIdx] = currPlayer;
        lines[currIdx][lastIdx] = currPlayer;
        printLines();
        
		// reset handlers to handle starting a line
		setStartLineHandlers();

		// update the current player
		currPlayer = (currPlayer + 1) % 2;
		
		// update message and player indicator color, to let next player now to start a new line
		gameMessage.setText("Player " +  (currPlayer + 1)  + ": Choose first dot");
		playerRect.setFillColor(0, 255, 255 * currPlayer);

	} 

	static void printLines() {
		// print list of points
		System.out.println("-------------");
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				if (lines[i][j] >= 0)
					System.out.println("lines[" + i + "][" + j + "] = " + lines[i][j]);
		System.out.println("-------------");
	}

	public static void main(String[] args) {

		// create circles for hexagon and add them to array
		Oval pt = new Oval(300, 150, 20, 20);
		points.add(pt);
		pt = new Oval(150, 250, 20, 20);
		points.add(pt);
		pt = new Oval(150, 350, 20, 20);
		points.add(pt);
		pt = new Oval(300, 450, 20, 20);
		points.add(pt);
		pt = new Oval(450, 350, 20, 20);
		points.add(pt);
		pt = new Oval(450, 250, 20, 20);
		points.add(pt);

		// create text box for messages
		gameMessage = new Text("Player " +  (currPlayer + 1)  + ": Choose first dot", 10, 20, 28);

		// create rectangle to indicate current player color
		playerRect = new Rectangle(10, 60, 50, 50);
		playerRect.setFillColor(0, 255, 255 * currPlayer);

		// initialize list of poitns
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				lines[i][j] = -1;
				
		// Initialize handlers to start a line
		setStartLineHandlers();
		
	}

}
