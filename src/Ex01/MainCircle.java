package Ex01;
abstract class Shape{
	public void paint() {
		draw();
	}
	abstract public void draw();
}
class Circle extends Shape{
	private int radius;
	public Circle(int radius) {
		this.radius = radius;
	}
	double getArea() {
		return 3.14*radius*radius;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(radius);
	}
}
public class MainCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle(10);
		c.paint();
	}

}
