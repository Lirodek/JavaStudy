package org.Lirodek.HumanModel;

public class HumanVo {//생성자
	private int member;
	private String name, phone,email;
	public HumanVo() {
		this(0,"","","");
	}
	public HumanVo(int member, String name, String phone, String email) {
		this.member =member;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "[" + member + "]\t" + name + "\t" + phone + "\t" + email;
	}
	
	
}
