/* Name: Mark Teixeira
   Date: 2/18/2018
   File Name: Lab03.java
   Description: 
*/

import doodlepad.*;

public class Rule30 {

	// define dimensions
	static final int NUM_COLS = 601;
	static final int NUM_ROWS = 300;
	
	//declare array
	static boolean [][] pixArr = new boolean[NUM_COLS][2];

	// declare image
	static Image rule30Img;
	
	
	public static void main(String[] args) { 

		// create image
		rule30Img = new Image(0,0,NUM_COLS, NUM_ROWS);
		
		// initialize array to all points false
		for (int x = 0; x < NUM_COLS; x++)
			for (int y = 0; y < 2; y++)
				pixArr[x][y] = false;
		// initialize the center point in the array to get things started
		pixArr[300][0] = true;
		// set image center point on first row to black 
		rule30Img.setPixel(300, 0, 0 , 0, 0);
		
		// use variables to point to current row 1 and row 2
		int row1 = 0;
		int row2 = 1;
		
		// loop for all the rows
		for (int row = 1; row < NUM_ROWS; row++) {
			System.out.println("Row " + row);
			for (int col = 1; col < NUM_COLS - 1; col++) {
				// check for patterns on the first row
				if (!pixArr[col-1][row1] && !pixArr[col][row1] && !pixArr[col+1][row1]) {
					// set row2 value and corresponding pixel acccording to rule 30
					pixArr[col][row2] = false;
					rule30Img.setPixel(col, row, 255 , 255, 255);
					System.out.println("Found pattern 1");
				}
				else if (!pixArr[col-1][row1] && !pixArr[col][row1] && pixArr[col+1][row1]) {
					// set row2 value and corresponding pixel acccording to rule 30
					pixArr[col][row2] = true;
					rule30Img.setPixel(col, row, 0 , 0, 0);
					System.out.println("Found pattern 2");
				}
				else if (!pixArr[col-1][row1] && pixArr[col][row1] && !pixArr[col+1][row1]) {
					// set row2 value and corresponding pixel acccording to rule 30
					pixArr[col][row2] = true;
					rule30Img.setPixel(col, row, 0 , 0, 0);
					System.out.println("Found pattern 3");

				}
				else if (!pixArr[col-1][row1] && pixArr[col][row1] && pixArr[col+1][row1]) {
					// set row2 value and corresponding pixel acccording to rule 30
					pixArr[col][row2] = true;
					rule30Img.setPixel(col, row, 0 , 0, 0);
					System.out.println("Found pattern 4");
				}
				else if (pixArr[col-1][row1] && !pixArr[col][row1] && !pixArr[col+1][row1]) {
					// set row2 value and corresponding pixel acccording to rule 30
					pixArr[col][row2] = true;
					rule30Img.setPixel(col, row, 0 , 0, 0);
					System.out.println("Found pattern 5");
				}
				else if (pixArr[col-1][row1] && !pixArr[col][row1] && pixArr[col+1][row1]) {
					// set row2 value and corresponding pixel acccording to rule 30
					pixArr[col][row2] = false;
					rule30Img.setPixel(col, row, 255 , 255, 255);
					System.out.println("Found pattern 6");

				}
				else if (pixArr[col-1][row1] && pixArr[col][row1] && !pixArr[col+1][row1]) {
					// set row2 value and corresponding pixel acccording to rule 30
					pixArr[col][row2] = false;
					rule30Img.setPixel(col, row, 255 , 255, 255);
					System.out.println("Found pattern 7");

				}
				else if (pixArr[col-1][row1] && pixArr[col][row1] && pixArr[col+1][row1]) {
					// set row2 value and corresponding pixel acccording to rule 30
					pixArr[col][row2] = false;
					rule30Img.setPixel(col, row, 255 , 255, 255);
					System.out.println("Found pattern 8");

				}
			}
			// Swap row1 and row2 definitions
			row1 = (row1 + 1) % 2;
			row2 = (row2 + 1) % 2;
		}

	} 	
}