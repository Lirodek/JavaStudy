package PhoneBookViewer;

import PhoneBookConstuct.INIT_MENU;
import PhoneBookConstuct.MenuViewer;
import PhoneBookConstuct.PhoneBookManager;
import PhoneBookExcept.MenuChoiceException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		SerarchDelFrame winFrame = new SerarchDelFrame("PhoneBookVer09");
		int choice;
		try {
			while(true) {
				MenuViewer.showMenu();
				choice = MenuViewer.sci.nextInt();
				if(choice<INIT_MENU.INPUT||choice>INIT_MENU.EXIT)throw new MenuChoiceException(choice);
				switch(choice) {
				case INIT_MENU.INPUT:
					manager.input();
					break;
				case INIT_MENU.EXIT:
					manager.storeToFile();
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					return;
				}
			}
		} catch (MenuChoiceException e) {
			// TODO Auto-generated catch block
			e.showWrongChoice();
			System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
		}
	}

}
