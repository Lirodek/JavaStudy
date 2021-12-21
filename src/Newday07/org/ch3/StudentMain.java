package Newday07.org.ch3;

import static java.lang.System.out;

public class StudentMain {
	final int MAX_CNT = 100;
	int cnt=0;
	SchoolStudent[] studentInfo = new SchoolStudent[MAX_CNT];
	public void studentGet() {
		out.print("이름 : ");
		String name = MenuViewer.scN.nextLine();
		out.print("평균 : ");
		double avg = MenuViewer.sc.nextDouble();
		studentInfo[cnt++]=new SchoolStudent(name,avg);
		out.println("데이터 입력이 완료되었습니다.");
	}
	public void searchData() {
		out.println("학생의 성적을 검색합니다.");
		
		out.print("이름 : ");
		String name = MenuViewer.scN.nextLine();
		int dataIdx = search(name);
		if(dataIdx<0) out.println("해당 학생의 성적이 입력되지 않았습니다.");
		else {
			studentInfo[dataIdx].SchoolPrint();
			out.println("데이터 검색이 완료되었습니다.");
		}
	}
	public void deletData() {
		out.println("학생의 성적을 삭제합니다.");
		out.print("이름 : ");
		String name =MenuViewer.scN.nextLine();
		int dataIdx = search(name);
		if(dataIdx<0) out.println("해당 학생의 성적이 입력되지 않았습니다.");
		else {
			for(int idx =dataIdx;idx<cnt-1;idx++ ) {
				studentInfo[dataIdx]=studentInfo[idx+1];
			}
			cnt--;
			out.println("데이터가 성공적으로 삭제 되었습니다.\n");
		}
	}
	public void allStudent() {
		out.println("입력된 학생 전원의 정보를 출력합니다.");
		if(cnt<0) {
			out.println("아직 학생의 정보가 입력되지 않았습니다.");
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
