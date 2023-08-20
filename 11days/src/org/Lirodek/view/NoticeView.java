package org.Lirodek.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NoticeView {
	public static Scanner sc = new Scanner(System.in);
	public static Scanner sci = new Scanner(System.in);
	public void display() {
		setLine("디스플레이");
	}
	public void setLine(String s) {
		System.out.println("---------- "+s+" ----------");
	}
	public String getString(String s) {
		String getS;
		try {
			System.out.print(s);
			getS = sc.nextLine();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다");
			return getString(s);
		}
		return getS;
	}
	public int getInteger(String s) {
		int ienteger;
		try {
			System.out.print(s);
			ienteger = sci.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된입력입니다.(숫자를 입력해주세요.)");
			sci.next();
			return getInteger(s);
		}
		return ienteger;
	}
	public String getDate() {
		 LocalDateTime myDateObj = LocalDateTime.now();   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시mm분ss초 의 저장되었습니다.");  
	    String formattedDate = myDateObj.format(myFormatObj);   
	    return formattedDate;
	}
	public String updateDate() {
		 LocalDateTime myDateObj = LocalDateTime.now();   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시mm분ss초 의 수정되었습니다.");  
	    String formattedDate = myDateObj.format(myFormatObj);  
	    return formattedDate;
	}
	
}
