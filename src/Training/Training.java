package Training;

import java.util.Scanner;

abstract class Shape{
	private Shape next;
	public Shape() {
		next =null;
	}
	public void setNext(Shape obj) {
		next = obj;
	}
	public Shape getNext() {
		return next;
	}
	public abstract void draw();
}
class Line extends Shape{
	public Line() {
		
	}

	@Override
	public void draw() {
		System.out.println("Line");
	}
}
class Rect extends Shape{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Rect");
	}
	
}
class Circle extends Shape{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Circle");
	}
	
}
class GraphicEditor{
	Line l = new Line();
	Rect r = new Rect();
	Circle c =new Circle();
	
	public static final Scanner sc = new Scanner(System.in);
	String[] d = new String[100];
	private int topCnt=0;
	public void run() {
		System.out.println("그래픽 에디터 beauty");
		while(true) {
			choice();
		}
	}
	public void choice() {
		
		System.out.print("삽입(1) 삭제(2), 모두 보기(3), 종료(4)>>");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.print("Line(1) Rect(2) Circle(3)>>");
			
			int a = sc.nextInt();
			switch(a) {
			case 1:
				d[topCnt++] = "Line";
				break;
			case 2:
				d[topCnt++] = "Rect";
				break;
			case 3:
				d[topCnt++] = "Circle";
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
			break;
		case 2:
			System.out.print("삭제할 도형의 위치 >>");
			int b;
			b = sc.nextInt();
			delete(b);
			break;
		case 3:
			for(int i=0;i<topCnt;i++) {
				System.out.println(d[i]);
			}
			break;
		case 4:
			System.out.println("beauty를 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("잘못된입력입니다.");
		
		}
		choice =0;
	}
	public void delete(int i) {
		if(topCnt<=i||0>i) {
			System.out.println("삭제할 수 없습니다.");
			return;
		}
		else {
			d[i-1]=null;
		}
	}
}
public class Training {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicEditor g = new GraphicEditor();
		g.run();
	}

}
