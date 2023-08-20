package org.Lirodek.interfaceEx01;

public interface PhoneInterface {//인터페이스 선언
	public static final int TIMEOUT=100000;//상수 필드 public static final 생략가능
	public abstract void sendCall();//추상 메서드 public abstract 생략가능
	public abstract void receiveCall();// default 메소드 public 생략가능
	public default void printLogo() {
		System.out.println("** Phone **");
	};// default 메서드
}
class SamsungPhone implements PhoneInterface{

	@Override
	public void sendCall() {
		System.out.println("띠리리링");
	}

	@Override
	public void receiveCall() {
		System.out.println("전화가 왔습니다.");
	}
	public void flash() {
		System.out.println("전화기에 불이 켜졌습니다.");
	}
	
}
