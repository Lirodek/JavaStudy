package Training;

import java.util.Scanner;

interface CAL{
	String ADD = "+",SUB="-",MUL="x",DIV="/";
}
class calculator{
	public static Scanner sc =new Scanner(System.in);
	int a, b;
	public void setValue(int a, int b) {
		this.a= a;
		this.b =b;
	}
	public int Add() {
		return a+b;
	}
	public int Sub() {
		return a-b;
	}
	public int Mul() {
		return a*b;
	}
	public double Div() {
		return a/b;
	}
	public void calcul(String s) {
		switch(s) {
		case CAL.ADD:
			System.out.println(Add());
			break;
		case CAL.SUB:
			System.out.println(Sub());
			break;
		case CAL.MUL:
			System.out.println(Mul());
			break;
		case CAL.DIV:
			System.out.println(Div());
		}
	}
	public void run() {
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		String s = sc.next();
		setValue(num1, num2);
		calcul(s);
		
	}
	public void loof() {
		while(true) {
			run();
		}
	}
	
}
public class Training6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculator c =new calculator();
		c.loof();
	}

}
