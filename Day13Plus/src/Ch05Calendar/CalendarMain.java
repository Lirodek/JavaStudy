package Ch05Calendar;

import java.util.Calendar;

public class CalendarMain {

	public static void main(String[] args) {
		CalenfarEx p = new CalenfarEx();
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();
		p.printCalendar("현재",now);
		
		Calendar firstDate = Calendar.getInstance();
		firstDate.clear();
		firstDate.set(Calendar.HOUR_OF_DAY, 20); 
		firstDate.set(Calendar.HOUR, 30);
		firstDate.set(Calendar.MINUTE,45);
		firstDate.set(Calendar.SECOND,59);
		
		p.printCalendar("처음 데이트한 날은 ",firstDate);
		
		
	}

}
