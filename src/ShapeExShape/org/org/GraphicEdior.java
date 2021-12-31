package ShapeExShape.org.org;

import java.util.Calendar;
import java.util.Scanner;

public class GraphicEdior {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintCal p = new PrintCal();
		String s[] = {"황기태","이재문"};
		int[] game= new int[2];
		int[] game1= new int[2];
		System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
		for(int i=0;i<s.length;i++) {
			System.out.print(s[i]+" 시작<Enter>키>>");
			sc.nextLine();
			Calendar c = Calendar.getInstance();
			game[i] = c.SECOND;
			game[i] = Math.abs(game[i]);
		
			System.out.println(game[i]);
			System.out.println("10초 예상 후 <Enter키>>>");
			sc.nextLine();
			game[i] = c.SECOND;
			game[i] = Math.abs(game[i]);
			System.out.println(game[i]);
		}
		
		System.out.println(p.game());
		
		
	}

}
