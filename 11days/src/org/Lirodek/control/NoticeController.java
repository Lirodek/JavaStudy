package org.Lirodek.control;

import org.Lirodek.controller.R;
import org.Lirodek.controller.ViewContainer;
import org.Lirodek.model.NoticeDao;

public class NoticeController {
	private final ViewContainer vc = new ViewContainer();
	private final NoticeDao dao = new NoticeDao();
	public void action(){
		if(R.choice==0)vc.run(R.menuView);
		switch(R.choice) {
		case 1:
			vc.run(R.insertView);
			dao.insert(R.nVo);
			break;
		case 2:
			vc.run(R.noeoutView);
			R.nVo = dao.selectByno(R.no);
			R.nVo.print();
			break;
		case 3:
			vc.run(R.updateView);
			dao.update(R.nVo);
			break;
		case 4:
			vc.run(R.deleteView);
			dao.delete(R.nVo);
			break;
		case 5:
			R.arr =dao.selectAll();
			vc.run(R.allView);
			break;
		case 6:
			vc.run(R.nameView);
			R.arr = dao.nameSearch(R.nVo);
			vc.run(R.nameView);
			R.cnt=0;
			break;
		case 7:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("1~8사이의 숫자를 입력해주세요.");
			break;
		}
		R.choice=0;
		R.no=0;
		R.arr=null;
	}
}
