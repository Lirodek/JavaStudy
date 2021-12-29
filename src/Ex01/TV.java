package Ex01;

class TV {
	private int size;
	public TV(int n) {
		size =n;
	}
}
class ColorTv extends TV{
	private int Colors;
	public ColorTv(int colors, int size) {
		super(size);
		this.Colors = colors;
	}
}
