package Training;
interface Shape1{
	final double PI = 3.14;
	void draw() ;
	double getArea();
	default public void redraw() {
		System.out.print("--- 다시 그립니다.  ");
		draw();
	}
}
class Oval implements Shape1{
	int x,y;
	Oval(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public void draw() {
		System.out.printf("%dx%d 에 내접하는 타원입니다.\n",x,y);
		
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return PI*x*y;
	}
	
}
class Rect1 implements Shape1{
	int x,y;
	Rect1(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public void draw() {
		System.out.printf("%dx%d 크기의 사격형입니다.\n",x,y);
		
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return x*y;
	}
	
}
class Circle1 implements Shape1{
	int radius;
	Circle1(int radius){
		this.radius = radius;
	}
	@Override
	public void draw() {
		System.out.printf("반지름이 %d인 원입니다.\n",radius);
		
	}

	@Override
	public double getArea() {
		return PI*radius*radius;
	}
	
}
public class Training7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape1[] list = new Shape1[3];
		list[0] = new Circle1(10);
		list[1] = new Oval(20,30);
		list[2] = new Rect1(10,40);
		for(int i=0;i<list.length;i++) list[i].redraw();
		for(int i=0;i<list.length;i++) System.out.println("면적은 "+list[i].getArea() );
		
	}

}
