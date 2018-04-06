
public class Lab05 {

	static final int n = 23678;
	
	public static double f(double x) {
		// evaluate 11 x2
		return 11 * x * x;
	}
	
	public static double myIntegrate(double x0, double xn, int n) {
		double h = (xn - x0) / n;
		double sum = 0.0;
		
		// iterate from x0 to xh with intervals if h
	
			// calculate integral at b both points, and add to sum
			sum += (f(x) + f(x + h)) * h / 2;
		}
		
		return sum;
	}
	
	public static double integrate(double x0, double xn, int n) {
		double x1, x2, fx1, fx2, area;
		double h = (xn - x0) / n;
		double sum = 0;
		
		// iterate from x0 to xh with intervals if h
		for (int i = 0; i < n; i++) {
			// calculate integral at b both points, and add to sum
			x1 = x0 + i * h;
			x2 = x1 + h;
			fx1 = f(x1);
			fx2 = f(x2);
			area = 0.5 * h * (fx1 + fx2);
			sum += area;
		}
		
		return sum;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Fernando's formula: " + myIntegrate(0,1,n));
		System.out.println("Teacher's formula: " + integrate(0,1,n));

	}

}
