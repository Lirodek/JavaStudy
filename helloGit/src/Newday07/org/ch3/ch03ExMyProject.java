package Newday07.org.ch3;

import static java.lang.System.out;

public class ch03ExMyProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentMain shcool = new StudentMain();
		int choice = 0;
		MenuViewer menu = new MenuViewer();
		out.println("학생 기록부 입니다.");
		while(true) {
			menu.showMenu();
			choice = menu.sc.nextInt();
			switch(choice) {
			case 1:
				shcool.studentGet();
				break;
			case 2:
				shcool.searchData();
				break;
			case 3:
				shcool.deletData();
				break;
			case 4:
				shcool.allStudent();
				break;
			default:
				System.exit(0);
			}
		}
		
	}

}
