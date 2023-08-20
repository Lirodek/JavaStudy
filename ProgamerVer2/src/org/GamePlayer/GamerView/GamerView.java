package org.GamePlayer.GamerView;

import java.util.Scanner;

public class GamerView {
	public static Scanner sc = new Scanner(System.in);
	public static Scanner sci = new Scanner(System.in);
	public void display() {
		System.out.println("프로게이머 정보관리 . . .");
	}
	public void getLine(String s) {
		System.out.println("============ "+s+" ============");
	}
	public String setString(String s) {
		System.out.print(s);
		String name = sc.next();
		return name;
	}
	public int setInteger(String s) {
		System.out.print(s);
		int num = sci.nextInt();
		return num;
	}

}
