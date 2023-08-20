package Training;
class TV{
	private int size;
	public TV(int size) {
		this.size = size;
	}
	protected int getSize() {
		return size;
	}
}
class ColorTV extends TV{
	private int color;
	ColorTV(int size, int color){
		super(size);
		this.color = color;
	}
	public void printProperty() {
		System.out.printf("%d인치 %d컬러",getSize(),color);
	}
}
class IPTV extends ColorTV{
	String ipAdress;
	IPTV(int size, int color, String ipAdress){
		super(size, color);
		this.ipAdress = ipAdress;
	}
	@Override
	public void printProperty() {
		System.out.printf("나의 IPTV는 %s 주소의 ",ipAdress);
		super.printProperty();
		
	}
}
public class TraningT {
	public static void main(String[] args) {
		IPTV iptv = new IPTV(32,1024,"192.1.1.2");
		iptv.printProperty();
	}
}
