package Ex09;

import java.util.*;

class Player{
	public static Scanner sc = new Scanner(System.in);
	private int choice;
	public int play() {
		System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
		choice = sc.nextInt();
		if(choice==4)
			System.exit(0);
		playerPrint();
		return choice;
		
		
	}
	public void playerPrint() {
		switch(choice) {
		case 1:
			System.out.print("철수(가위) : ");
			break;
		case 2:
			System.out.print("철수(바위) : ");
			break;
		case 3:
			System.out.print("철수(보) : ");
			break;
		}
	}

}
class autoPlayer{
	private int autoChoice;
	public int autoPlayer() {
		Random r = new Random();
		autoChoice = 1+r.nextInt(3);
		autoPrint();
		return autoChoice;
	}
	public void autoPrint() {
		switch(autoChoice) {
		case 1:
			System.out.print("컴퓨터(가위)");
			break;
		case 2:
			System.out.print("컴퓨터(바위)");
			break;
		case 3:
			System.out.print("컴퓨터(보)");
			break;
		}
	}
}
class Ex09{
	Player p =new Player();
	autoPlayer autoP = new autoPlayer();
	int compareP,compareA;
	public void run(){
		while(true) {
			play();
			System.out.println();
		}
	}
	private void play() {
		compareP = p.play();
		compareA = autoP.autoPlayer();
		if(compareP==1&&compareA==3)
			System.out.print("\n철수가 이겼습니다.");
		if(compareP==2&&compareA==1)
			System.out.print("\n철수가 이겼습니다.");
		if(compareP==3&&compareA==2)
			System.out.print("\n철수가 이겼습니다.");
		if(compareP==3&&compareA==1)
			System.out.print("\n컴퓨터가 이겼습니다.");
		if(compareP==1&&compareA==2)
			System.out.print("\n컴퓨터가 이겼습니다.");
		if(compareP==2&&compareA==3)
			System.out.print("\n컴퓨터가 이겼습니다.");
		else
			System.out.print("\n비겼습니다.");
	}
}
public class Ex09RandNumber {
	public static void main(String[] args) {
		Ex09 e =new Ex09();
		e.run();
	}
}
