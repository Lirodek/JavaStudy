package InterdaceMark;

public class PointOne implements UpperCasePrintable{
	private int xPos, yPos;
	public PointOne() {
		this(0,0);
	}
	public PointOne(int xPos, int yPos) {
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
