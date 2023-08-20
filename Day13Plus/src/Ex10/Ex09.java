package Ex10;
import java.util.*;
class Person1{
	Random r = new Random();
	Scanner sc = new Scanner(System.in);
	String name;
	int i=0;
	boolean win;
	int randA,randB,randC;
	Person1(){}
	Person1(String name){
		this.name = name;
	}
	public void play() {
		System.out.printf("[%s]:<Enter>",name);
		sc.nextLine();
		win = wOr();
		i++;
		System.out.printf("%d번    %d  %d  %d  ",i,randA,randB,randC);
		if(win==true) {
			System.out.println("\t"+name+"님이 이겼습니다!");
			System.exit(0);
		}
		else System.out.println("아쉽군요!");
			

	}
	private boolean wOr(){
		randA = 1+r.nextInt(3);
		randB = 1+r.nextInt(3);
		randC = 1+r.nextInt(3);
		if(randA==randB&&randA==randC)
			return true;
		return false;
	}
	
}
class palyGamble{
	public static Scanner sc = new Scanner(System.in);
	String name;
	Person1[] pArr;
	private int arrCnt;
	public void run() {
		System.out.print("겜블링 게임에 참여할 선수 숫자 >>");
		int i = sc.nextInt();
		pArr = new Person1[i];
		getName();
		arrCnt=0;
		while(true) {
			pArr[arrCnt++].play();
			if(arrCnt==pArr.length)
				arrCnt=0;
			
			
		}
	}
	public void getName() {
		while(arrCnt<pArr.length) {
			System.out.printf("%d번째 선수 이름>>",arrCnt+1);
			name = sc.next();
			pArr[arrCnt++] = new Person1(name);
		}
	}
}
public class Ex09 {

	public static void main(String[] args) {
		palyGamble pGame = new palyGamble();
		pGame.run();
	}

}
