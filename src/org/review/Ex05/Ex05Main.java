package org.review.Ex05;

import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Ex05Main {
	public static Scanner sc;
	public static final int MAX=4;
	private Vector<Student> sv = new Vector<Student>(); 
	{
		sv.add(new Student("배광민","소프트웨어","1","4.5"));
		sv.add(new Student("개광민","정보보안","2","4.5"));
		sv.add(new Student("새광민","프론트앤드","3","4.5"));
		sv.add(new Student("너광민","풀스택","4","4.5"));
	}
	Ex05Main(){
		start();
	}
	private void start() {
		//4명의 학생 정보 입력
		System.out.println("학생 이름, 학과 ,학번, 학점평균 입력하세요");
		sc = new Scanner(System.in);
//		for(int i=0;i<MAX;i++) {
//			System.out.print(">> ");
//			String studentInfomation = sc.nextLine();
//			StringTokenizer st = new StringTokenizer(studentInfomation);
//			String name =st.nextToken().trim();
//			String major =st.nextToken().trim();
//			String year =st.nextToken().trim();
//			String grade =st.nextToken().trim();
//			sv.add(new Student(name, major, year, grade));
//		}
		Iterator<Student> itr = sv.iterator();
		System.out.println("--------------");
		while(itr.hasNext()) {
			System.out.println(itr.next().toString(MAX));
			System.out.println("--------------");
		}
		while(true) {
			System.out.print("학생이름 >> ");
			String name = sc.next();
			if(name.equals("그만")) break;
			int idx = sv.indexOf(new Student(name,"","",""));
			if(idx!=-1) {
				System.out.println(sv.get(idx)); 
			} else {
				System.out.println(name+"학생은 없습니다.");
			}
		}
		sc.close();
		
	}
	
	public static void main(String[] args) {
		new Ex05Main();

	}

}
