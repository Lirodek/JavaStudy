package org.LiroSelf.Model;

import java.util.Objects;
import java.util.Vector;

public class DataMake {
	private int no;
	private String name;
	private int age;
	private String phoneNumber;
	private String sex;
	private String nation;
	private String ranguage;
	private String specialNumber;

	public DataMake() {
		this(0, "", 0, "", "", "", "");

	}

	public DataMake(int no, String name, int age, String phoneNumber, String sex, String nation, String ranguage) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.nation = nation;
		this.ranguage = ranguage;
		this.phoneNumber = phoneNumber;
	}
	public DataMake(int no, String name, int age, String phoneNumber, String sex, String nation, String ranguage, String specialNumber) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.nation = nation;
		this.ranguage = ranguage;
		this.phoneNumber = phoneNumber;
		this.specialNumber = specialNumber;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String isSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSex() {
		return sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getRanguage() {
		return ranguage;
	}

	public void setRanguage(String ranguage) {
		this.ranguage = ranguage;
	}

	public String getSpecialNumber() {
		return specialNumber;
	}

	public void setSpecialNumber(String specialNumber) {
		this.specialNumber = specialNumber;
	}

	public Vector<String> getVectorAll() {
		Vector<String> v = new Vector<>();
		v.add(specialNumber);
		v.add(name);
		String age1 = String.valueOf(this.age);
		v.add(age1);
		v.add(phoneNumber);
		v.add(sex);
		v.add(nation);
		v.add(ranguage);
		return v;
	}

	public Vector<String> getVector() {
		Vector<String> v = new Vector<>();
		v.add(nation);
		v.add(name);
		String age = String.valueOf(this.age);
		v.add(age);
		v.add(sex);
		return v;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, nation, no, phoneNumber, ranguage, sex, specialNumber);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataMake other = (DataMake) obj;
		return age == other.age && Objects.equals(name, other.name) && Objects.equals(nation, other.nation)
				&& no == other.no && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(ranguage, other.ranguage) && Objects.equals(sex, other.sex)
				&& Objects.equals(specialNumber, other.specialNumber);
	}

	@Override
	public String toString() {
		return "DataMake [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", sex=" + sex + ", nation="
				+ nation + ", ranguage=" + ranguage + "]";
	}

}
