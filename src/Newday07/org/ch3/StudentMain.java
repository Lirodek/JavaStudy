package Newday07.org.ch3;

import static java.lang.System.out;

public class StudentMain {
	final int MAX_CNT = 100;
	int cnt=0;
	SchoolStudent[] studentInfo = new SchoolStudent[MAX_CNT];
	public void studentGet() {
		out.print("이름 : ");
		String name = MenuViewer.sc.nextLine();
		out.print("평균 : ");
		double avg = MenuViewer.sc.nextDouble();
		studentInfo[cnt++]=new SchoolStudent(name,avg);
		out.println("데이터 입력이 완료되었습니다.");
	}
	public void searchData() {
		
	}
}
