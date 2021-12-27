package HumanControl;

import org.Lirodek.HumanController.R;
import org.Lirodek.HumanController.ViewContainer;
import org.Lirodek.HumanModel.HumanDAO;

public class HumanControl {
	ViewContainer vc = new ViewContainer();
	private HumanDAO dao = new HumanDAO();
	
		// TODO Auto-generated method stub
	public void action() {
		if(R.choice == 0) {
			vc.run(R.menuView);//동적바인딩 처리
		}
		switch(R.choice) {
		case 1:
			vc.run(R.insertView);
			dao.insert(R.humanVo);
			break;
		case 2:
			R.humanArr = dao.selectAll();
			vc.run(R.humanListView);
			break;
		case 3:
			R.type = R.SEARCH;
			vc.run(R.humanDetail);
			R.type = R.DETAIL;
			R.humanVo = dao.selectOne(R.humanVo);
			vc.run(R.humanDetail);
			break;
		case 4:
			vc.run(R.humanEdit);
			dao.update(R.humanVo);
			break;
		case 5:
			vc.run(R.humanDelete);
			dao.delete(R.humanVo);
			break;
		case 6:System.out.println("프로그램 종료");System.exit(0);break;
		default : System.out.println("해당기능은 존재하지 않습니다.");
		}
		R.choice = 0;
		action();
	}

}
