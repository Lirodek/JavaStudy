package ImpObjectPrintln;
class ClassPrinter{
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
}
class Point{
	private int xPos, yPos;
	Point(int x, int y){
		xPos=x;
		yPos=y;
	}
	@Override
	public String toString() {
		return "Point [xPos=" + xPos + ", yPos=" + yPos + "]";
	}
	
}
public class ImpObjectPrintln {
	public static void main(String[] args) {
		Point pos1 = new Point(1, 5);
		Point pos2 = new Point(5, 9);
		ClassPrinter.print(pos1);
		ClassPrinter.print(pos2);
	}
}
