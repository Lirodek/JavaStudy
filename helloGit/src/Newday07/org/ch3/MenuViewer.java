package Newday07.org.ch3;
import java.util.Scanner;
import static java.lang.System.out;
public class MenuViewer {
	public static Scanner sc = new Scanner(System.in);
	public static Scanner scN = new Scanner(System.in);
	public void showMenu() {
		
		out.print("1. 학생 성적 입력 ");
		out.println("\t2. 학생 기록 검색 ");
		out.print("3. 학생 기록 삭제 ");
		out.println("\t4. 등록 학생 검색");
		out.println("5. 프로그램 종료 ");
		out.print("입력 : ");
	}

}
