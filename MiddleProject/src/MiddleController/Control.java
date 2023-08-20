package MiddleController;

import MiddlePro.Menu;
import MiddlePro.PhoneManager;

public class Control {
	private Container pc = new Container();
	private PhoneManager pm = new PhoneManager();
	public void action() {
		pm.SaveFile();
		if(R.choice==0) {
			pc.run(R.vMenu);
		}
		switch(R.choice) {
		case 1:
			R.aList = pm.AllSearch();
			pc.run(R.vIdx);
			break;
		case 2:
			pc.run(R.vInput);
			pm.insert(R.pInfo);
			break;
		case 3:
			pc.run(R.vSearch);
			R.pInfo = pm.search(R.pInfo);
			if(R.pInfo.getName().equals(Menu.FAIL)) {
				System.out.println("검색에 실패하였습니다.");
			} else {
				System.out.println(R.pInfo.toString(1));
			}
			break;
		case 4:
			pc.run(R.vSearch);
			R.pInfo = pm.search(R.pInfo);
			if(R.pInfo.getName().equals(Menu.FAIL)) {
				System.out.println("검색에 실패하였습니다.");
			} else {
				pc.run(R.vUpdate);
				pm.upDate(R.pInfo);
			}
			break;
		case 5:
			pc.run(R.vDel);
			R.pInfo = pm.delete(R.pInfo);
			if(R.pInfo==null) {
				System.out.println("검색에 실패하였습니다.");
			} else if(R.pInfo.getName().equals(Menu.CACEL)) {
				System.out.println("삭제를 취소했습니다.");
			} else {
				System.out.println(R.pInfo+"의 정보를 삭제하였습니다.");
			}
			break;
		case 6:
			pc.run(R.vAllDelete);
			if(pm.allDalete()) {
				System.out.println("데이터 삭제를 완료했습니다.");
			} else {
				System.out.println("데이터 삭제를 취소했습니다.");
			}
			break;
		case 7:
			pc.run(R.vEnd);
			System.exit(0);
			break;
		}
		R.choice=0;
	}
}
