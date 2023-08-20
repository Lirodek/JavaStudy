package Ex01;
interface Device{
	default void on() {
		System.out.println("켜졌습니다.");
	}
	default void off() {
		System.out.println("종료합니다.");
	}
	default void watch(){
		System.out.println("방송중입니다.");
	}
}

public class TV2 implements Device{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV2 myTv = new TV2();
		myTv.on();
		myTv.watch();
		myTv.off();
	}

}
