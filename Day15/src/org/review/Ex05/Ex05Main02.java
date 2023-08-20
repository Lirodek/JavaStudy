package org.review.Ex05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Ex05Main02 {
	
	public static Scanner sc;
	public static final int MAX=4;
	private HashMap<String, Student> smap = new HashMap<String, Student>();
	private Vector<Student> sv = new Vector<Student>(); 
	{
		smap.put("배광민", new Student("배광민","소프트웨어","1","4.5"));
		smap.put("개광민", new Student("개광민","정보보안","2","4.5"));
		smap.put("새광민", new Student("새광민","프론트앤드","3","4.5"));
		smap.put("너광민", new Student("너광민","풀스택","4","4.5"));
	}
	Ex05Main02(){
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
//		Iterator<Student> itr = smap.values().iterator();
//		System.out.println("--------------");
//		while(itr.hasNext()) {
//			System.out.println(itr.next().toString(MAX));
//			System.out.println("--------------");
//		}
		ArrayList<Student> sList = new ArrayList<Student>();
		sList.addAll(smap.values());
		Collections.sort(sList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if((Integer.parseInt(o1.year)<Integer.parseInt(o2.year))){
					return 1;
				}
						
				if((Integer.parseInt(o1.year)>Integer.parseInt(o2.year)))
						return -1;
				else
					return 0;
			}
			
		});
		for(int i=0;i<sList.size();i++) {
			System.out.println(sList.get(i).toString(1));
		}
		while(true) {
			System.out.print("학생이름 >> ");
			String name = sc.next();
			if(name.equals("그만")) break;
			if(smap.get(name)==null) {
				System.out.println(name+"학생은 없습니다.");
			}
			else {
				System.out.println(smap.get(name).toString(MAX)); 
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Ex05Main02();

	}

}
