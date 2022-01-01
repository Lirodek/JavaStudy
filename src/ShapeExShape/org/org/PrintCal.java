package ShapeExShape.org.org;

import java.util.Calendar;
import java.util.Scanner;

public class PrintCal {
	Calendar now = Calendar.getInstance();
	Scanner sc = new Scanner(System.in);
	private String name, buffer;
	private int sec1, sec2;
	public PrintCal(String name) {
		this.name = name;
	}
	public int game() {
		System.out.println(name + "시작<Enter>키 >>");
		sec1=enter();
		sec2=enter();
		if(sec1<sec2) return sec2-sec1;
		else return (60-sec1)+sec2;
	}
	public int enter() {
		buffer = sc.nextLine();
		now = Calendar.getInstance();
		System.out.println("\t현재 초 시간 = "+now.get(Calendar.SECOND));
		return now.get(Calendar.SECOND);
	}
	
}
