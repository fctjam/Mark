import doodlepad.*;

public class Sim {

	// keep track of current player
	static int currPlayer = 0;
	
	// define shapes for points
	static Oval pt1;
	static Oval pt2;
	static Oval pt3;
	static Oval pt4;
	static Oval pt5;
	static Oval pt6;
	
	// define  text box for messages
	static Text gameMessage;
	
	// define rectangle to indicate current player
	static Rectangle playerRect;
	
	// define variable to remembet last point clicked
	static Shape lastPoint;
	
	// This method sets all the shapes to the handler for starting a line
	public static void setStartLineHandlers() { 
		pt1.setMousePressedHandler( Sim::startLine );
		pt2.setMousePressedHandler( Sim::startLine );
		pt3.setMousePressedHandler( Sim::startLine );
		pt4.setMousePressedHandler( Sim::startLine );
		pt5.setMousePressedHandler( Sim::startLine );
		pt6.setMousePressedHandler( Sim::startLine );
	} 

	// This method sets all the shapes to the handler for ending a line
	public static void setEndLineHandlers() { 
		pt1.setMousePressedHandler( Sim::endLine );
		pt2.setMousePressedHandler( Sim::endLine );
		pt3.setMousePressedHandler( Sim::endLine );
		pt4.setMousePressedHandler( Sim::endLine );
		pt5.setMousePressedHandler( Sim::endLine );
		pt6.setMousePressedHandler( Sim::endLine );
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
		
		// remember first point selected
		lastPoint = shp;
		
		// reset handlers to handle ending a line
		setEndLineHandlers();
		
		// update message to let them know they should close the line
		gameMessage.setText("Player " + (currPlayer + 1) + ": Choose second dot");
	} 

	// method invoked when the first shape is clicked
	public static void endLine(Shape shp, double x, double y, int button) { 
		// Draw a line betwwen the current shape and the last one
		drawLine(lastPoint, shp);
		
		// Clear previous shape fill
		lastPoint.setFillColor(255, 255, 255);
		
		// reset handlers to handle starting a line
		setStartLineHandlers();

		// update the current player
		currPlayer = (currPlayer + 1) % 2;
		
		// update message and player indicator color, to let next player now to start a new line
		gameMessage.setText("Player " +  (currPlayer + 1)  + ": Choose first dot");
		playerRect.setFillColor(0, 255, 255 * currPlayer);

	} 

	public static void main(String[] args) {

		// create circles for hexagon
		pt1 = new Oval(300, 150, 20, 20);
		pt2 = new Oval(150, 250, 20, 20);
		pt3 = new Oval(450, 250, 20, 20);
		pt4 = new Oval(150, 350, 20, 20);
		pt5 = new Oval(450, 350, 20, 20);
		pt6 = new Oval(300, 450, 20, 20);

		// create text box for messages
		gameMessage = new Text("Player " +  (currPlayer + 1)  + ": Choose first dot", 10, 20, 28);

		// create rectangle to indicate current player color
		playerRect = new Rectangle(10, 60, 50, 50);
		playerRect.setFillColor(0, 255, 255 * currPlayer);
		
		// Initialize handlers to start a line
		setStartLineHandlers();
		
	}

}
