package org.Test.Pack;

import java.util.Scanner;

import static java.lang.System.out;

class Student {
	public int no; // 번호
	public String name; // 이름
	public int kor, eng, mat ;
	public int sum; // 국영수의 총점
	public double avg,wait; // 국영수 총점의 평균
	public String grade; // 학점
	public int rank; // 등수
	
	public Student(int no) {
	}

	public Student(int no, String name, int kor, int eng, int mat) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		sum = kor+eng+mat;
		avg = (double)sum /3;
		wait = avg*100;
		avg = (int)wait /100;
		getGrade();
		
		// 총점, 평균, 학점을 만들어준다.
		
	}

	public void getGrade() {
		if(avg>90) grade = "A";
		else if(avg>80) grade = "B";
		else if(avg>70) grade = "C";
		else if(avg>60) grade = "D";
		else grade = "낙제";
	}
	// 객체를 사용하면 toString()이 자동 호출 된다.
	public void studentPrint() {
		out.println(no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t"
				+ sum + "\t"+ avg +"\t"+  grade + "\t" + rank);
	}
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t"
				+ sum + "\t"+ avg +"\t"+  grade + "\t" + rank;
	}
}
// Student st1 = new Student();
// st1.name = "홍길동"
// Student st2 = new Student(1, "김길동", 60, 70, 80);

public class test {
	public static final Scanner scan = new Scanner(System.in);
	public static final Scanner scanN = new Scanner(System.in);
	
	public static final int MAX = 100;
	static Student[] sArr = new Student[MAX];
	static int top = 0; // 스텍 자료구조처럼.
	public static int sequence = 1;
	
	
	// static 초기화 블럭
	static {
		sArr[top++] = new Student(sequence++, "배광민", 60, 60, 75);
		sArr[top++] = new Student(sequence++, "김현용", 90, 80, 80);
		sArr[top++] = new Student(sequence++, "이정능", 90, 100, 95);	
		appointedRank();
	}
	public static void appointedRank() {
		int temp=99;
		for(int i = 1; i < top; i++) {
			for(int j = 0; j < top - i; j++) {
				if(sArr[j].avg < sArr[j+1].avg) {
					sArr[temp] = sArr[j];
					sArr[j] = sArr[j+1];
					sArr[j+1]=sArr[temp];
				}
			}
		}
		rankCheck();
	}
	public static int getNum() {
		int n;
		try{
			n = scan.nextInt();
		}catch(Exception e) {
			out.println("잘못된 입력입니다.");
			scan.nextLine();
			return getNum();
		}
		if(n>6||0>n) {
			
			out.println("잘못된 입력입니다. 1~6중 입력해주세요.");
			return getNum();
		}
		return n;
	}
	
	public static int menu() {
		out.println("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료");
		out.print("선택>> ");
		int no = getNum();
		// 예외처리 및 유효성 검사
		return no;
	}
	
	public static void run() {
		switch(menu()) {
		case 1 : input(); break;
		case 2 : output(); break;
		case 3 : searchData(); break;
		case 4 : modify(); break;
		case 5 : delete(); break;
		case 6 : end(); break;
		default : out.println("--- 해당 사항 없습니다! ---");
		}
		System.out.println("------------------------------------");
	}
	public static void rankCheck() {
		for(int idx=0;idx<top;idx++) {
			sArr[idx].rank = idx+1;
		}
	}
	public static String getName() {
		out.print("이름 : ");
		String name = scanN.nextLine();
		return name;
	}
	
	public static void searchData() {
		// TODO Auto-generated method stub
		System.out.println("::::: SEARCH :::::");
		out.println("학생의 성적을 검색합니다.");
		String name = getName();
		int dataIdx = search(name);
		if(dataIdx<0) out.println("해당 학생의 성적이 입력되지 않았습니다.");
		else {
			sArr[dataIdx].studentPrint();
			out.println("데이터 검색이 완료되었습니다.");
			
			
		}
	}

	private static void end() {
		System.out.println("::::: END :::::");
		System.out.println("프로그램 종료!");
		System.out.println("수고하셨습니다!");
		System.exit(0);
	}

	private static void delete() {
		System.out.println("::::: DELETE :::::");
		// 이름으로 검색 후 삭제
		out.println("학생의 성적을 삭제합니다.");
		String name = getName();
		int dataIdx = search(name);
		
		if(dataIdx<0) {
			out.println("해당 학생을 찾을수 없습니다.");
		}else {
			
			for(int idx=dataIdx;idx<top;idx++) {
				sArr[idx].no = sArr[dataIdx+1].no;
				sArr[idx] = sArr[idx+1];
			}
			top--;
			out.println("-----데이터 삭제를 완료했습니다.-------");
		}
	}

	private static void modify() {
		System.out.println("::::: MODIFY :::::");
		// 이름으로 검색 후 수정
		out.println("학생의 성적을 수정합니다.");
		String name = getName();
		int dataIdx = search(name);
		if(dataIdx<0) {
			out.println("찾으시는 학생의 정보가 없습니다.");
		}else {
			out.println(sArr[dataIdx].name+"의 정보를 수정합니다.");
			out.print("kor : ");
			int kor = scan.nextInt();
			out.print("eng : ");
			int eng = scan.nextInt();
			out.print("math : ");
			int math = scan.nextInt();
			sArr[dataIdx] = new Student(sArr[dataIdx].no, name,kor, eng, math);
			appointedRank();
		}
	}

	private static int search(String name) {
		// 이름으로 검색
		for(int idx =0;idx<top;idx++) {
			Student sIdx = sArr[idx];
			if(name.compareTo(sIdx.name)==0)
				return idx;
		}
		return -1;
	}

	private static void output() {
		System.out.println(":::::::::::::::::::::::::::: OUTPUT ::::::::::::::::::::::::::::");
		// 배열의 목록 출력
		// 번호, 성명, 국어, 영어, 수학, 총점, 평균, 학점, 등수, 등수를 기준으로 정렬
		for(Student std : sArr) {
			if(std == null) break;
			out.println(std);
		}
	}

	private static void input() {
		System.out.println("::::: INPUT :::::");
		// 성명, 국어, 영어, 수학를 배열에 입력 받는다.
		// 입력 받은 국영수 점수의 총점과 평균, 평균의 학점, 
		// 입력 된 학생의 등수가 셋팅 된다.
		out.print("이름 : ");
		String name = scanN.nextLine();
		out.print("kor : ");
		int kor = scan.nextInt();
		out.print("eng : ");
		int eng = scan.nextInt();
		out.print("math : ");
		int math = scan.nextInt();
		sArr[top++] = new Student(sequence++, name,kor, eng, math);
		appointedRank();
		rankCheck();
		
	}

	public static void main(String[] args) {
		out.println("::::: 성적 출력 프로그램 :::::");
		while(true) {
			run();
		}
	}
}