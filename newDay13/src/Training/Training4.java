package Training;

import java.util.Scanner;

interface Strack{
	int length();
	int capacity();
	String pop();
	boolean push(String val);
}
class StringStack implements Strack{

	public static Scanner sc = new Scanner(System.in);
	public static Scanner sci = new Scanner(System.in);
	
	
	String[] pop = new String[100];
	int length;
	@Override
	public int length() {
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		int legth = sci.nextInt();
		return legth;
	}

	@Override
	public int capacity() {
		
		return 0;
	}

	@Override
	public String pop() {
		System.out.print("문자열 입력 >> ");
		String pop = sc.next();
		return pop;
	}

	@Override
	public boolean push(String val) {
		// TODO Auto-generated method stub
		return false;
	}
	public void StackApp(){
		this.length = length()+1;
		String s="";
		for(int i=1;;i++) {
	
			if(i<length) {
				this.pop[i] = pop();
			}
			else {
				s=pop();
				System.out.println("스택이 꽉 차서 푸시 불가!");
			}
			if(length>i?pop[i].equals("그만"):s.equals("그만")) break;
		}
		System.out.println("스택에 저장된 모든 문자열 팝 : ");
		for(int i=length-1;i>0;i--) {
			System.out.print(pop[i]+" ");
		}
	}
	
}
public class Training4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringStack s = new StringStack();
		s.StackApp();
	}

}
