package Training;
class Point{
	private int x,y;
Point(){
		x=0;
		y=0;
	}
	public Point(int x, int y) {this.x= x;this.y = y;}
	public int getX() {return x;}
	public int getY() {return y;}
	protected void move(int x, int y) {this.x = x; this.y = y;}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")의 점";
	}
}
class ColorPoint extends Point{
	String color;
	ColorPoint(){
		super(0,0);
		this.color = "BLACK";
	}
	ColorPoint(int x, int y){
		super(x,y);
		color="BLACK";
	}
	ColorPoint(int x, int y, String color){
		super(x,y);
		this.color = color;
	}
	public void setColor(String s) {
		this.color = s;
	}
	@Override
	public String toString() {
		return  color + "색의 ("+super.getX()+","+getY()+")의 점";
	}
}
class Point3D extends Point{
	private int z;
	Point3D(int x, int y, int z){
		super(x,y);
		this.z =z;
	}
	protected void move(int x, int y, int z) {
		// TODO Auto-generated method stub
		super.move(x, y);
		this.z = z;
	}
	public void moveUP(){
		this.z+=1;
	}
	public void moveDown(){
		this.z-=1;
	}
	@Override
	public String toString() {
		return "(" + super.getX() + ","+super.getY()+","+z+")의 점";
	}
}
class PointivePoint extends Point{
	PointivePoint(){}
	PointivePoint(int x, int y){
		move(x,y);
	}
	public void move(int x, int y) {
		if(x<0||y<0);
		else super.move(x,y);
	}
}

public class Training3 {

	public static void main(String[] args) {
		PointivePoint p = new PointivePoint();
		p.move(10, 10);
		System.out.println(p.toString()+"입니다.");
		p.move(-5, 5);
		System.out.println(p.toString()+"입니다.");
		PointivePoint p2 = new PointivePoint(-10,-10);
		System.out.println(p2.toString()+"입니다.");
		
	}

}
