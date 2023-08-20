package org.Lirodek.ch6Ex01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringMethodTo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("자르고싶냐? \n>>");
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " /.");
		while (st.hasMoreTokens()) 
			System.out.println(st.nextToken());
	}


}
