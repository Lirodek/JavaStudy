package Ex01;

public class sharpPencil {
	private int width;
	private int amount;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
class BallPen extends sharpPencil{
	private String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void refill(int n) {
		setAmount(n);
	}
}
class FountainPen extends sharpPencil{
	
}
