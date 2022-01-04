package org.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class review {
	public final Scanner sc = new Scanner(System.in);
	public review() {
		
	}
	private void ex04() {
		Vector<Integer> precipitation = new Vector<Integer>();
		int sum;
		int num;
		int i=0;
		while(true) {
			System.out.print("강수량 입력 (0 입력시 종료) >> ");
			num = sc.nextInt();
			if(num==0) break;
			precipitation.add(num);
			sum=0;
			Iterator<Integer> itr  = precipitation.iterator();
			while(itr.hasNext()){
				int n = itr.next();
				sum+=n;
				System.out.print(n + " ");
			}
			System.out.println("\n현재 평균 "+sum/precipitation.size());
		}
		
	}
	private void ex03() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		System.out.println("나라 이름과 인구를 입력하세요.(예 : Korea 5000");
		while(true) {
			System.out.print("나라이름, 인구 >> ");
			String nations = sc.next();
			if(nations.equals("그만")) break;
			map.put(nations, sc.nextInt());
		}
		while(true) {
			System.out.print("인구 검색 >>");
			String nations = sc.next();
			if(nations.equals("그만")) break;
			if(map.containsKey(nations))
				System.out.println(nations+"의 인구는 "+map.get(nations));
			else
				System.out.println(nations+"나라는 없습니다.");
		}
		sc.close();
	}
	private void ex02() {
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)");
		ArrayList<Character> scoreList = new ArrayList<Character>();
		double avg=0;
		for(int i=0;i<6;i++) 
			scoreList.add(i,sc.next().charAt(0));
		sc.close();
		Iterator<Character> itr = scoreList.iterator();
		double sum = 0;
		while(itr.hasNext()) {
			Character score = itr.next();
			sum+=((69-score)<0?0:(double)(69-score));
		}
		System.out.println(sum/6);
		sc.close();
		
	}
	private void ex01() {
		Vector<Integer> v = new Vector<Integer>();
		int i=0;
		int max = 0;
		System.out.print("정수(-1이 입력될때 까지>>");
		while(true) {
			i = sc.nextInt();
			if(max<i) max=i;
			if(i==-1)	break;
			v.add(i);
		}
		System.out.println(max);
		
	}
	public static void main(String[] args) {
		new review();
	}
	

	

}
