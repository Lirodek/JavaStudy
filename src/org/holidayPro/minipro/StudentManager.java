package org.holidayPro.minipro;
import static java.lang.System.out;
import java.util.Scanner;

public class StudentManager {
	public final Scanner sc = new Scanner(System.in);
	public final Scanner scs = new Scanner(System.in);
	
	public final int MAX = 100;
	public int curCnt=0;
	public int checkNum = 1;
	StudentInfo[] sInfo = new StudentInfo[MAX];
	{
		sInfo[curCnt++] = new StudentInfo(checkNum++,"김승호",60,60,75);
		sInfo[curCnt++] = new StudentInfo(checkNum++,"이상호",90,80,80);
		sInfo[curCnt++] = new StudentInfo(checkNum++,"박찬호",90,100,95);
		bubleSort();
	}
	private void bubleSort() {
		final int TEMP=99;
		for(int i=0;i<curCnt;i++) {
			for(int j=0;j<curCnt-1;j++) {
				if(sInfo[j].getAvg()<sInfo[j+1].getAvg()) {
					sInfo[TEMP]=sInfo[j];
					sInfo[j] = sInfo[j+1];
					sInfo[j+1]=sInfo[TEMP];
				}
			}
		}
		rankSort();
	}
	private void rankSort() {
		for(int idx = 0;idx<curCnt;idx++) {
			sInfo[idx].setRank(idx+1);
		}
	}

	private void end() {
		// TODO Auto-generated method stub
		out.println("---성적 관리 프로그램을 종료합니다.---");
		System.exit(0);
		
	}

	private void delete() {
		// TODO Auto-generated method stub
		out.println(":::::DELETE:::::");
		String name = setName("이름 : ");
		int idx = search(name);
		if(idx<0) out.println(name+"을 찾을수없습니다.");
		else {
			for(int i = idx;i<curCnt;i++) {
				sInfo[i]=sInfo[i+1];
			}
			out.println("---삭제가 완료되었습니다.--");
			curCnt--;
		}
		
	}

	private void modify() {
		// TODO Auto-generated method stub
		out.println(":::::MODIFY:::::");
		String name = setName("이름 : ");
		int idx = search(name);
		if(idx<0)out.println(name+"을 찾을수없습니다.");
		else {
			out.println("데이터를 수정합니다.");
			int kor = setNum("kor : ");
			int eng = setNum("eng : ");
			int mat = setNum("mat : ");
			sInfo[idx] = new StudentInfo(sInfo[idx].getnum(),name,kor,eng,mat);
			bubleSort();
		}
	}

	private int search(String name) {
		// TODO Auto-generated method stub
		for(int idx=0;idx<curCnt;idx++) {
			if(sInfo[idx].getName().equals(name)) {
				return idx;
			}
		}
		return -1;
		
	}
	private int setNum(String s) {
		int num;
		try {
			out.print(s);
			num = sc.nextInt();
		}
		catch (Exception e) {
			out.println("점수를 입력해주세요.");
			sc.nextLine();
			return setNum(s);
			
		}
		if(num<0||num>100) {
			System.out.println("0~100사이의 숫자를 입력해주세요.");
			return setNum(s);
		}
		return num;
	}
	
	private String setName(String s) {
		out.print(s);
		String name;
		name= scs.nextLine();
		return name;
	}

	private void input() {
		// TODO Auto-generated method stub
		out.println(":::::INPUT:::::");
		String name = setName("이름 : ");
		int kor = setNum("kor : ");
		int eng = setNum("eng : ");
		int mat = setNum("mat : ");
		sInfo[curCnt++] = new StudentInfo(checkNum++,name,kor,eng,mat);
		bubleSort();
	}

	private  void output() {
		System.out.println(":::::::::::::::::::::::::::: OUTPUT ::::::::::::::::::::::::::::");
		// 배열의 목록 출력
		// 번호, 성명, 국어, 영어, 수학, 총점, 평균, 학점, 등수, 등수를 기준으로 정렬
		for(int i=0;i<curCnt;i++) {
			if(sInfo[i].getName() == null) break;
			sInfo[i].printInfo();
		}
	}
	private void searchData() {
		out.println(":::::SEARCH:::::");
		String name = setName("이름 : ");
		int idx = search(name);
		if(idx<0) out.println(name+"을 찾을수 없습니다.");
		else {
			sInfo[idx].printInfo();
			out.println("---데이터 입력이 완료되었습니다.---");
		}
	}

	private int menu() {
		// TODO Auto-generated method stub
		int choice = 0;
		out.println("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료");
		
		choice = setNum("선택>>");
		return choice;
	}
	public void run() {
		while(true) {
			switch(menu()) {
			case 1: input(); break;
			case 2: output(); break;
			case 3: searchData(); break;
			case 4: modify(); break; 
			case 5: delete(); break;
			case 6: end(); break;
			default : out.println("---해당 사항이 없습니다.---");
			}
			out.println("--------------------------------------");
		}
	}
	
}
