package org.NewDay09.Project;
import static java.lang.System.out;
class Shape{
	public Shape next;
	public Shape() {next = null;}
	public void draw() {
		out.println("Shape");
	}
}
class Line extends Shape{
	public void draw() {
		out.println("Line");
	}
}
class Rect extends Shape{
	public void draw() {
		out.println("Rect");
	}
}
class Circle extends Shape{
	public void draw() {
		out.println("Circle");
	}
}
public class MethodOverridingEx {
	static void paint(Shape p) {
		p.draw();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Line line = new Line();
		paint(line);
		paint(new Shape());
		paint(new Circle());
		paint(new Rect());
		paint(new Line());
		

	}

}
