package org.holidayPro.minipro;

public class StudentInfo {
	private int no,kor,eng,mat,rank,sum;
	private String name;
	private double avg;
	private String grade;
	public StudentInfo() {}
	public StudentInfo(int no, String name, int kor, int eng, int mat) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = kor+eng+mat;
		int a = (sum/3)*100;
		this.avg = (double)a/100;
		gradeSort(avg);
	}
	public int getnum() {
		return no;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getRank() {
		return rank;
	}
	public String getName() {
		return name;
	}
	public double getAvg() {
		return avg;
	}
	public void gradeSort(double avg) {
		if(avg>90) {
			grade = "A";
		}
		else if(avg>80) {
			grade = "B";
		}
		else if(avg>70) {
			grade = "C";
		}
		else if(avg>60) {
			grade = "D";
		}
		else {
			grade = "낙제";
		}
		
	}
	public void printInfo() {
		System.out.println(  no +")" + name+"\tkor:" + kor + "\teng:" + eng + "\tmat:" + mat +  "\tsum:"
				+ sum  + "\tavg:" + avg + "  grade:" + grade +"  rank:" + rank);
	}
	
}
