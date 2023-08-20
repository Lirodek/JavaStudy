package org.Lirodek.ch6Ex01;

import java.util.Scanner;

public class StringBEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 생각은 ?\n>>");
		StringBuffer sb = new StringBuffer(sc.nextLine());
		sb.append(" 라고 말했습니다.");
		System.out.println(sb);
		sb.insert(7, "아니라고");
		System.out.println(sb);
		sb.replace(10, 12," 그래서 뭐");
		System.out.println(sb);
		sb.delete(8, 13);
		System.out.println(sb);
		sb.setLength(5);
		System.out.println(sb);
		System.out.println(sb.indexOf("라고"));
	}
}
