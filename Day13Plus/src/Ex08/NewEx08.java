package Ex08;

import java.util.Scanner;

class Ex08{
	char charString;
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요. 빈칸이 있어도 되고 영어 한글 모두 ㄱㄴ\n>>");
		String s = sc.nextLine();
		String sleng=s;
		for(int i=0;i<sleng.length();i++) {
			charString = s.charAt(0);
			s+=charString;
			s = s.substring(1);
			System.out.println("\t"+s);
		}
	}
}
public class NewEx08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex08 e =new Ex08();
		e.run();
	}

}
