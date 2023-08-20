package Newday07.org.ch3;
import static java.lang.System.out;
import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;

public class ch03Ex01 {
	
	static Scanner scan = new Scanner(in);

	public static void main(String[] args) {
		int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
		int month=0, day=0;
		int total=0;
		int nextMonth=0, nextDay=0;
		
		out.print("�� �Է�>> ");
		month = scan.nextInt();
		while(month<1 || month>12) {
			out.println("�� �Է� ����: ������ ������ϴ�!");
			out.print("�� �ٽ� �Է�(1~12����)>> ");
			month = scan.nextInt();
		}
		out.print("�� �Է�>> ");
		day = scan.nextInt();
		while(day<1 || day>days[month-1]) {
			out.printf("�� �Է� ����: �ش� ���� ��¥�� %d�ϱ� �Դϴ�.\n", days[month-1]);
			out.printf("�� �ٽ� �Է�(1~%d����)>> ", days[month-1]);
			day = scan.nextInt();
		}
		
		out.printf("%d���� %d�ϱ��� �ִ�.\n", month, days[month-1]);
		out.printf("%d���� ���� ��¥�� %d���̴�.\n", month, days[month-1]-day);
		// 1��1�Ϻ��� �Է³�¥���� total�� ����.
		total = day;
		for(int i=0; i<month-1; i++) {
			total += days[i];
		}
		out.printf("1�� 1�Ϻ��� %d�� %d�ϱ����� %d�� �������ϴ�.\n", month, day, total);
		
		// 1���� ���� ��¥ ���ϱ�
		total = days[month-1]-day;
		for(int i=month; i<days.length; i++) {
			total += days[i];
		}
		out.printf("%d�� %d�� ���� 1���� ���� ��¥�� %d���Դϴ�.\n", month, day, total);
		
		// ���� ���� ���� ��¥�� total �ʱ�ȭ
		out.print("���� �� ��¥�� �˰� �ͳ���? >>");
		int dd = scan.nextInt();
		//���� ���� ���� ���� ��¥���� ���� ���ڰ� ������ �׳� ������� day+dd �̴�
		total  = dd;
		total = total - (days[month-1]-day);
		int i=month%12;
		for(; total>days[i]; i++, i%=12) {
			total -= days[i];
		}
		
		nextMonth = i+1;
		nextDay = total;
		System.out.println(dd + "�� �Ĵ� "+ nextMonth + "�� "+ nextDay+"���Դϴ�.\n");
	}
}