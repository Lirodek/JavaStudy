package MiddleView;

import java.util.Scanner;

public class MiddleView {
	public static Scanner sc = new Scanner(System.in);
	public static Scanner sci = new Scanner(System.in);
	public void display() {
		System.out.println("======전화번호 입출력 프로그램======");
	}
	public void getLine(String s) {
		System.out.println("============"+s+"============");
	}
	public String setString(String s) {
		System.out.print(s);
		String name = sc.next();
		return name;
	}
	public int setInteger(String s) {
		System.out.print(s);
		int num;
		try {
			num = sci.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			sc.nextLine();
			return setInteger(s);
		}
		return num;
	}
	
}
