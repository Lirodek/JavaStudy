package MiddlePro;

import java.util.Objects;

public class PhoneInfo {
	private String name;
	private String phone;
	private int age;
	private String relation;
	public PhoneInfo() {
		this("","",0,"");
		
	}
	public PhoneInfo(String name, String phone, int age, String relation) {
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.relation = relation;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneInfo other = (PhoneInfo) obj;
		return Objects.equals(name, other.name);
	}
	public String toString(int i) {
		return Menu.LINE+"\n이름 : " + name + "\n번호 : " + phone + "\n나이 : " + age + "\n관계 : " + relation +"\n"+ Menu.LINE;
	}
	@Override
	public String toString() {
		return "이름 : " + name+"\n";
	}
	
}
