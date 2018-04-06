import java.util.Random;

public class Lab04 {

	static final int NUM_ITER = 10000000;
	static final int R = 1000;
	
	public static void main(String[] args) {
		// create new random numer generator
		Random random = new Random();
		
		//counter for number if times in circle
		int countIn = 0;
		
		// counter for loop
		int counter = 0;
		
		// loop a set number of times 
		while (counter < NUM_ITER) {
			// assign a random x and y based on the constant R
			double x = (random.nextDouble() * 2 * R) - R;
			double y = (random.nextDouble() * 2 * R) - R;
			
			// verify if point is in circle
			if (Math.sqrt(x*x + y*y) <= R) {
				countIn++;
			}
			
			// incremet loop counter
			counter++;
		}
		
		System.out.println("Number of times in the circle: " + countIn);
		System.out.println("PI estimate: " + ((double)countIn / (double)NUM_ITER) * 4);
	}

}
