import doodlepad.*;

public class Triangle extends Path {

	double x1;
	double y1;
	double x2;
	double y2;
	double x3;
	double y3;
	
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		
		// complete path to make triangle
		moveTo(x1,y1);
		lineTo(x2,y2);
		lineTo(x3,y3);
		closePath();
	}
	
	public double area() {
		// calculate the lenth of each side
		double a = Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));
		double b = Math.sqrt(Math.pow(x3 - x2,2) + Math.pow(y3 - y2,2));
		double c = Math.sqrt(Math.pow(x1 - x3,2) + Math.pow(y1 - y3,2));
		
		// calculate the semiperimeter
		double s = (a + b + c)/2;
		
		// calculate and return area
		return Math.sqrt(s * (s -a) * (s - b) * (s -c));
	}
}
		