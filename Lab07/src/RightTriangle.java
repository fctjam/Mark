import doodlepad.*;

public class RightTriangle extends Triangle {

	public RightTriangle(double x, double y, double width, double height)
	{
		// invoke parent triangle constructor passing in arguments based on RightTriangle inputs
		super(x, y, x , y + height, x + width, y + height);
	}
}
		