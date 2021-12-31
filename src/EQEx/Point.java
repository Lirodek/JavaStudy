package EQEx;




public class Point {
	int x, y;
	public Point(int x, int y) {
		this.x =x;
		this.y = y;
	}
	public boolean equals(Object obj) {
		Point p = (Point)obj;
		if(x==p.x&&y==p.y) return true;
		else return false;
	}
	@Override
	public String toString() {
		
		return String.format("\t(%d,%d)\n",x,y);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}
