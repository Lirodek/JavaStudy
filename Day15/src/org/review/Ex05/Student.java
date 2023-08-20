package org.review.Ex05;

import java.util.Objects;

class Student{
	String name;
	String major;
	String year;
	String grade;
	public Student() {
		this("","","","");
	}
	public Student(String name, String major, String year, String grade) {
		this.name = name;
		this.major= major;
		this.year = year;
		this.grade= grade;
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
		Student other = (Student) obj;
		return Objects.equals(name, other.name);
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name + ", " + major + ", " + year + ", " + grade ;
	}
	public String toString(int i) {
		return "이름 : "+name+"\n학과 : "+major+"\n학번 : "+year+"\n학점평균 : "+grade;
	}
}