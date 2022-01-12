package org.LirodekEx05;

import java.util.Objects;

public class PhoneInfo {
	private int number;
	private String name;
	private String email;
	private String phone;
	PhoneInfo(){
		this(0,"","","");
	}
	public PhoneInfo(int number, String name, String email, String phone) {
		this.number = number;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		PhoneInfo other = (PhoneInfo) obj;
		return Objects.equals(name, other.name);
	}
	
}
