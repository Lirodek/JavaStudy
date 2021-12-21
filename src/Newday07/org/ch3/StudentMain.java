package Newday07.org.ch3;

import static java.lang.System.out;

public class StudentMain {
	final int MAX_CNT = 100;
	int cnt=0;
	SchoolStudent[] studentInfo = new SchoolStudent[MAX_CNT];
	public void studentGet() {
		out.print("�̸� : ");
		String name = MenuViewer.scN.nextLine();
		out.print("��� : ");
		double avg = MenuViewer.sc.nextDouble();
		studentInfo[cnt++]=new SchoolStudent(name,avg);
		out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
	}
	public void searchData() {
		out.println("�л��� ������ �˻��մϴ�.");
		
		out.print("�̸� : ");
		String name = MenuViewer.scN.nextLine();
		int dataIdx = search(name);
		if(dataIdx<0) out.println("�ش� �л��� ������ �Էµ��� �ʾҽ��ϴ�.");
		else {
			studentInfo[dataIdx].SchoolPrint();
			out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
		}
	}
	public void deletData() {
		out.println("�л��� ������ �����մϴ�.");
		out.print("�̸� : ");
		String name =MenuViewer.scN.nextLine();
		int dataIdx = search(name);
		if(dataIdx<0) out.println("�ش� �л��� ������ �Էµ��� �ʾҽ��ϴ�.");
		else {
			for(int idx =dataIdx;idx<cnt-1;idx++ ) {
				studentInfo[dataIdx]=studentInfo[idx+1];
			}
			cnt--;
			out.println("�����Ͱ� ���������� ���� �Ǿ����ϴ�.\n");
		}
	}
	public void allStudent() {
		out.println("�Էµ� �л� ������ ������ ����մϴ�.");
		if(cnt<0) {
			out.println("���� �л��� ������ �Էµ��� �ʾҽ��ϴ�.");
		}else {
			for(int idx = 0;idx<cnt;idx++) {
				studentInfo[idx].SchoolPrint();
			}
		}
	}
		
	private int search(String name) {
		for(int idx =0;idx<cnt;idx++) {
			SchoolStudent curStudent = studentInfo[idx];
			if(name.compareTo(curStudent.student)==0)
				return idx;
		}
		return -1;
	}
}
