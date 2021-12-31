package ShapeExShape.org.org;

import java.util.Calendar;

public class PrintCal {
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	int hour = cal.get(Calendar.HOUR);
	int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
	int ampm = cal.get(Calendar.AM_PM);
	int minute = cal.get(Calendar.MINUTE);
	int second = cal.get(Calendar.SECOND);
	int millisecond = cal.get(Calendar.MILLISECOND);
	public int game() {
		System.out.println("    현재 초 시간 = "+second);
		return second;
	}
	public void printCalendar(String msg, Calendar cal) {
		//get()는 0~30까지의 정수 리턴.
//		System.out.print(msg + year+"/"+month+"/"+day+"/");
		switch(dayOfWeek) {
		case Calendar.SUNDAY : System.out.println("일요일");break;
		case Calendar.MONDAY : System.out.println("월요일");break;
		case Calendar.TUESDAY : System.out.println("화요일");break;
		case Calendar.WEDNESDAY : System.out.println("수요일");break;
		case Calendar.THURSDAY : System.out.println("목요일");break;
		case Calendar.FRIDAY : System.out.println("금요일");break;
		case Calendar.SATURDAY : System.out.println("토요일");break;
		}
		System.out.println("("+hourOfDay+"시)");
		System.out.println("현재시간은 "+hour + "시" + minute + "분 입니다.");
		if(hourOfDay>4&&hourOfDay<12)
			System.out.println("GoodMorning");
		else if(hourOfDay>12&&hourOfDay<18) 
			System.out.println("GoodAfternoon");
		else if(hourOfDay>22)
			System.out.println("GoodEvening");
		else
			System.out.println("GoodNight");
		
	}
}
