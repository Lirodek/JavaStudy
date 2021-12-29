package org.Lirodek.interfaceEx01;

public class PhoneMain extends SamsungPhone{
	
	public static void main(String[] args) {
		SamsungPhone phone = new SamsungPhone();
		phone.sendCall();
		phone.printLogo();
		phone.receiveCall();
		phone.flash();
		
	}

}
