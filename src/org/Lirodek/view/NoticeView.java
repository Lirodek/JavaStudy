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
		System.out.print(s);
		String getS = sc.next();
		return getS;
	}
	public int getInteger(String s) {
		System.out.print(s);
		int ienteger = sci.nextInt();
		return ienteger;
	}
	public String getDate() {
		 LocalDateTime myDateObj = LocalDateTime.now();   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시mm분ss초 의 저장되었습니다.");  
	    String formattedDate = myDateObj.format(myFormatObj);  
	    System.out.println(formattedDate+"의 저장되었습니다.");  
	    return formattedDate;
	}
	public String updateDate() {
		 LocalDateTime myDateObj = LocalDateTime.now();   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시mm분ss초 의 수정되었습니다.");  
	    String formattedDate = myDateObj.format(myFormatObj);  
	    System.out.println(formattedDate+"의 수정되었습니다.");  
	    return formattedDate;
	}
	
}
