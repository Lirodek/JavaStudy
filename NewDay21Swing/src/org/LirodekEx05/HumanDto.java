package org.LirodekEx05;

import java.util.Objects;
import java.util.Vector;

public class HumanDto {
	private int idx;
	private String name;
	private String email;
	private String phone;
	HumanDto(){
		this(0,"","","");
	}

	public HumanDto(int idx, String name, String email, String phone) {
		this.idx = idx;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idx);
	}

	@Override
	public boolean equals(Object obj) {
		HumanDto other = (HumanDto) obj;
		if (idx != other.idx)
			return false;
		return true;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public Vector toVector() {
		Vector vector = new Vector();
		vector.add(idx);
		vector.add(name);
		vector.add(email);
		vector.add(phone);
		return vector;
	}
	
}
