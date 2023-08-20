package Ex03;

public class Circle {
	int x,y,z;
	public Circle(int x, int y, int z) {
		// TODO Auto-generated constructor stub
		this.x =x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return "Circle(" + x + "," + y + ")반지름" + z ;
	}
	@Override
	public boolean equals(Object obj) {
		Circle p = (Circle)obj;
		if(p.x == this.x&& p.y == this.y)
			return true;
		return false;
	}

}
