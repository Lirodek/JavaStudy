package Ex7Ex;

import java.util.Scanner;
import java.util.StringTokenizer;
class Ex07{
	public static final Scanner sc = new Scanner(System.in);
	String a;
	void run() {
		while(true) {
			game();
		}
	}
	void game() {
		System.out.print(">>");
		a = sc.nextLine();
		if(a.equals("그만")) {
			System.out.println("종료합니다...");
			System.exit(0);
		}
		String split[] = a.split(" ");
		int ai = split.length;
		System.out.println("어절의 개수는 "+ai);
		
	}
}
public class StringTokenEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex07 e = new Ex07();
		e.run();
	}

}
