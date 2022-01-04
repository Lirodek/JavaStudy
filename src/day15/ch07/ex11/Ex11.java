package day15.ch07.ex11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex11 {
	Scanner sc = new Scanner(System.in);
	HashMap<String, String> capital = new HashMap<String, String>();
	Set<String> keys = capital.keySet();
	
	
	{
		capital.put("한국", "서울");
		capital.put("북한", "평양");
		capital.put("일본", "도쿄");
		capital.put("천조국", "워싱턴DC");
		capital.put("짱깨", "천안문");
		capital.put("아르헨티나", "브에노스아이리스");
		capital.put("몽골", "울란바토르");
		capital.put("독일", "베를린");
		capital.put("아르헨티나", "브에노스아이리스");
		capital.put("나이지리아", "아부자");
		
	}
	public Ex11() {
		while(true) {
			start();
		}
		
	}
	private void start() {
		switch(manu()) {
		case 1:
			input();
			break;
		case 2:
			game();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		}
		
	}
	private void game() {
		Set<String> keys = capital.keySet();
		Iterator<String> itr = keys.iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			System.out.print(key+"의 수도는?");
			String uKey = sc.next();
			if(uKey.equals(capital.get(key))) {
				System.out.println("정답!");
			} else {
				System.out.println("아닙니다 !!");
			}
		}
		
	}
	private void input() {
		System.out.println("현재"+capital.size()+"개 나라와 수도가 입력되어 있습니다.");
		while(true) {
			System.out.print("나라와 수도 입력"+capital.size()+">> ");
			String nat = sc.next();
			if(nat.equals("그만"))break;
			String cap = sc.next();
			boolean a = duplication(nat);
			if(a==false)
				System.out.println(nat+"는 이미 있습니다.");
			else
				capital.put(nat, cap);
			
		}
		
		
	}
	private boolean duplication(String nat) {
		Set<String> keys = capital.keySet();
		Iterator<String> itr = keys.iterator();
		while(itr.hasNext()) {
			String eNat = itr.next();
			if(eNat.equals(nat))
				return false;
		}
		return true;
		
	}
	private int manu() {
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
		System.out.print("입력(1) 퀴즈(2) 종료(3) >> ");
		int choice = sc.nextInt();
		return choice;
	}
	public static void main(String[] args) {
		new Ex11();
	}

}
