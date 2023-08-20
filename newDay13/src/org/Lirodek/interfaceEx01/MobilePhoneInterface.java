package org.Lirodek.interfaceEx01;

public interface MobilePhoneInterface extends PhoneInterface {
	void sendSMS();//새로운 매서드 추가
	void receiveSMS();//새로운 추상 매서드 추가
}
interface MP3Interface{
	void play();
	void stop();
}
interface MusicPhoneInterface extends MobilePhoneInterface, MP3Interface{
	void playMP3RingTone();
}
interface Allnterface {
	void recongnizeSpeech();
	void synthesizeSpeech();
}
class AIPhone implements MobilePhoneInterface, Allnterface{
	public void sendCall() {
		System.out.println("띠리리");
	}
	public void receiveCall() {
		System.out.println();
	}
	@Override
	public void recongnizeSpeech() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void synthesizeSpeech() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sendSMS() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void receiveSMS() {
		// TODO Auto-generated method stub
		
	}
	public int touch() {
		return 0;
		
	}
	
}
