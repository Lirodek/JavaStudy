package org.Lirodek.HumanView;
import java.util.Scanner;
public class HumanView {
	public static Scanner sc = new Scanner(System.in);
	public static Scanner sci = new Scanner(System.in);
	public void display() {
		System.out.println("Human view display . . .");
		
	}
	public String setString(String s) {
		System.out.print(s);
		String name= sc.next();
		return name;
	}
}
