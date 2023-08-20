package Ex11;

import java.util.Scanner;

class StringRun{
	String str,createStr;
	public static Scanner sc = new Scanner(System.in);
	public void run() {
		while(true) {
			Command();
		}
	}
	public void Command() {
		System.out.print(">>");
		str = sc.nextLine();
		System.out.print("명령 : ");
		createStr = sc.next();
		StringBuffer sb = new StringBuffer(str);
		if(createStr.equals("그만")) {
			System.out.println("종료합니다.");
			System.exit(0);
		}
		String[] cut =  createStr.split("!");
		if(cut.length!=2) {
			System.out.println("잘못된 명령입니다!");
		}
		else {
			if(cut[0].length()==0||cut[1].length()==0) {
				System.out.println("잘못된 명령입니다!");
			}
			int idx = str.indexOf(cut[0]);
			if(idx==-1) {
				System.out.println("찾을 수 없습니다!");
			}
			sb.replace(idx,idx+cut[0].length(),cut[1]);
			System.out.println(sb);
		}
	}
}
public class Ex11StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringRun sr = new StringRun();
		sr.run();
	}

}
