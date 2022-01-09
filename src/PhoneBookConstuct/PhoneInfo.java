package PhoneBookConstuct;

import java.io.*;

public class PhoneInfo implements Serializable{
	String name;
	String phoneNumber;
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public void showPhoneInfo() {
		System.out.println("name : "+name);
		System.out.println("phone : "+phoneNumber);
	}
	@Override
	public String toString() {
		return "name : " + name + "\nphone : " + phoneNumber + "\n";
	}
	public int hashCode() {
		return name.hashCode();
	}
	public boolean equals(Object obj) {
		PhoneInfo cmp = (PhoneInfo)obj;
		if(name.compareTo(cmp.name)==0) return true;
		else return false;
	}
}

