
public class Triangles {

	public static void main(String[] args) {
		Triangle tri1 = new Triangle(10,10,120,10, 40,110);
		tri1.setFillColor(0,255,255);
		tri1.setStrokeColor(255,0,255);
		System.out.println("tri1 area is: " + tri1.area());
		
		RightTriangle rtri1 = new RightTriangle(150,220,120,50);
		rtri1.setFillColor(255,0,255);
		rtri1.setStrokeColor(100,100,100);
		System.out.println("rtri1 area is: " + rtri1.area());
		
		Triangle tri2 = new Triangle(110,130,10,40, 240,110);
		tri2.setFillColor(11,25,255);
		tri2.setStrokeColor(25,10,25);
		System.out.println("tri2 area is: " + tri2.area());
		
		RightTriangle rtri2 = new RightTriangle(250,228,240,150);
		rtri2.setFillColor(25,120,55);
		rtri2.setStrokeColor(10,10,11);
		System.out.println("rtri2 area is: " + rtri2.area());

	}

}
