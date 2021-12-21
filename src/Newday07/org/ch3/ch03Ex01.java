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
		
		out.print("월 입력>> ");
		month = scan.nextInt();
		while(month<1 || month>12) {
			out.println("월 입력 오류: 범위를 벗어났습니다!");
			out.print("월 다시 입력(1~12사이)>> ");
			month = scan.nextInt();
		}
		out.print("일 입력>> ");
		day = scan.nextInt();
		while(day<1 || day>days[month-1]) {
			out.printf("일 입력 오류: 해당 월의 날짜는 %d일까 입니다.\n", days[month-1]);
			out.printf("일 다시 입력(1~%d사이)>> ", days[month-1]);
			day = scan.nextInt();
		}
		
		out.printf("%d월은 %d일까지 있다.\n", month, days[month-1]);
		out.printf("%d월의 남은 날짜는 %d일이다.\n", month, days[month-1]-day);
		// 1월1일부터 입력날짜까지 total에 누적.
		total = day;
		for(int i=0; i<month-1; i++) {
			total += days[i];
		}
		out.printf("1월 1일부터 %d월 %d일까지는 %d일 지났습니다.\n", month, day, total);
		
		// 1년중 남은 날짜 구하기
		total = days[month-1]-day;
		for(int i=month; i<days.length; i++) {
			total += days[i];
		}
		out.printf("%d월 %d일 이후 1년의 남은 날짜는 %d일입니다.\n", month, day, total);
		
		// 현재 달의 남은 날짜로 total 초기화
		out.print("몇일 후 날짜를 알고 싶나요? >>");
		int dd = scan.nextInt();
		//만약 현재 달의 남은 날짜보다 적은 숫자가 들어오면 그냥 현재달의 day+dd 이다
		total  = dd;
		total = total - (days[month-1]-day);
		int i=month%12;
		for(; total>days[i]; i++, i%=12) {
			total -= days[i];
		}
		
		nextMonth = i+1;
		nextDay = total;
		System.out.println(dd + "일 후는 "+ nextMonth + "월 "+ nextDay+"일입니다.\n");
	}
}