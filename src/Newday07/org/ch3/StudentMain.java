package Newday07.org.ch3;

import static java.lang.System.out;

public class StudentMain {
	final int MAX_CNT = 100;
	int cnt=0;
	SchoolStudent[] studentInfo = new SchoolStudent[MAX_CNT];
	public void studentGet() {
		out.print("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		out.print("��� : ");
		double avg = MenuViewer.sc.nextDouble();
		studentInfo[cnt++]=new SchoolStudent(name,avg);
		out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
	}
	public void searchData() {
		
	}
}
