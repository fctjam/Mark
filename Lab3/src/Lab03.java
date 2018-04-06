/* Name: Mark Teixeira
   Date: 2/18/2018
   File Name: Lab03.java
   Description: 
*/

import doodlepad.*;

public class Lab03 {
	//declare ints
	static int rednum = 0;
	static int greennum = 0;
	static int bluenum = 0;
	
	//declare StringBuilder
	static StringBuilder mmorder = new StringBuilder();
	
	
	//method invoked when the red button is clicked
	public static void redClick(Shape shp, double x, double y, int button) { 
	
		System.out.println("FLAG1");
		//increment counter by 1
		rednum++;
		
		//add letter to StringBuilder
		mmorder.append('R');
	} 
	
	//method invoked when the green button is clicked
	public static void greenClick(Shape shp, double x, double y, int button) { 
		
		System.out.println("FLAG2");
		//increment counter by 1
		greennum++;
		
		//add letter to StringBuilder
		mmorder.append('G');	 
	} 
	
	//method invoked when the blue button is clicked
	public static void blueClick(Shape shp, double x, double y, int button) { 
		
		System.out.println("FLAG3");
		//increment counter by 1
		bluenum++;
		
		//add letter to StringBuilder
		mmorder.append('B');	
	} 
	
	
	//method invoked when the rectangle is clicked
	public static void rectClick(Shape shp, double x, double y, int button) { 
		System.out.println("The total number of Red M&M's is: " + rednum);
		System.out.println("The total number of Green M&M's is: " + greennum);
		System.out.println("The total number of Blue M&M's is: " + bluenum);
		System.out.println("The order of the M&M's is: " + mmorder);
	} 
	
	public static void main(String[] args) { 


		//declare ovals
		Oval o1 = new Oval(25, 300, 150, 150);
		Oval o2 = new Oval(200, 300, 150, 150);
		Oval o3 = new Oval(375, 300, 150, 150);
		
		//color ovals
		o1.setFillColor(255,0,0);
		o2.setFillColor(0,255,0);
		o3.setFillColor(0,0,255);
		
		//declare rectangle
		Rectangle r1 = new Rectangle(200, 500, 150, 50);
		
		//set click handlers
		o1.setMousePressedHandler( Lab03::redClick );
		o2.setMousePressedHandler( Lab03::greenClick );
		o3.setMousePressedHandler( Lab03::blueClick );
		r1.setMousePressedHandler( Lab03::rectClick );
	} 	
}