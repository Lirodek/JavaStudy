package Ex03;

public class MyPoint{
	int x, y;
	public MyPoint(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x =x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public boolean equals(Object a) {
		// TODO Auto-generated method stub
		MyPoint p = (MyPoint)a;
		if(this.x==p.x&&this.y==p.y)
			return true;
		return false;
		
	}
	@Override
	public String toString() {
	
		return "Point("+x+","+y+")";
	}

}
