package org.Lirodek.Interface;

import java.util.Scanner;

interface Week{
	int MON=1, TUE=2,WED=3,THU=4,FRI=5,SAT=6,SUN=7;
}
public class MeaningFulConst {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("오늘의 요일을 선택하세요.");
		System.out.println("1.월요일, 2.화요일, 3.수요일, 4.목요일");
		System.out.println("5.금요일, 6.토요일, 7.일요일");
		System.out.print("선택 : ");
		int choice = sc.nextInt();	
		
		switch(choice) {
		case Week.MON:
			System.out.println("주간회의가 있습니다.");
			break;
		case Week.TUE:
			System.out.println("프로젝트 기획이 있습니다.");
			break;
		case Week.WED:
			System.out.println("진행사항 보고하는 날입니다.");
			break;
		case Week.THU:
			System.out.println("사내 축구시합이 있는날입니다.");
			break;
		case Week.FRI:
			System.out.println("프로젝트 마감이 있는날입니다.");
			break;
		case Week.SAT:
			System.out.println("가족과 함께 즐거운 시간 보내세요.");
			break;
		case Week.SUN:
			System.out.println("오늘은 휴일입니다.");
		}
		sc.close();

	}

}
