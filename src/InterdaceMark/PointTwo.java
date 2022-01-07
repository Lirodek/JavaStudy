package InterdaceMark;

public class PointTwo {
	private int xPos, yPos;
	public PointTwo() {
		this(0,0);
	}
	public PointTwo(int xPos, int yPos) {
		// TODO Auto-generated constructor stub
		this.xPos =xPos;
		this.yPos =yPos;
	}
	@Override
	public String toString() {
		
		String posInfo =  "[xPos=" + xPos + ", yPos=" + yPos + "]";
		return posInfo;
	}
}
