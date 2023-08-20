package org.GamePlayer.Controller;

import org.GamePlayer.Model.GamerDAO;

public class GameControl {
	private GameContainer vc = new GameContainer();
	private GamerDAO dao = new GamerDAO();
	public void action() {

		if(R.choice==0) {
			vc.run(R.menuView);
		}
		switch(R.choice) {
		case 1:
			vc.run(R.inputView);
			dao.inputData(R.gameVo);
			break;
		case 2:
			vc.run(R.searchView);
			R.gameVo = dao.searchData(R.gameVo);
			if(R.gameVo==null) {
				System.out.println("");
				break;
			}else {
				R.gameVo.GamerDeepShow();
			}
			
			break;
		case 3:
			R.gameArr = dao.selectAll();
			vc.run(R.listView);
			break;
		case 4:
			vc.run(R.deleteView);
			dao.delete(R.gameVo);
			break;
		case 5:
			R.type = R.SEARCH;
			vc.run(R.modiView);
			R.gameVo = dao.searchData(R.gameVo);
			if(R.gameVo==null) {
				break;
			}
			else{
				R.type = R.GOING;
				vc.run(R.modiView);
				switch(R.modiChoice) {
				case 1:
					dao.gameModiZerg(R.gameVo);
					break;
				case 2:
					dao.gameModiProtoss(R.gameVo);
					break;
				case 3:
					dao.gameModiTerran(R.gameVo);
					break;
				case 4:
					dao.gameModiTribe(R.gameVo);
					break;
				}
				R.modiChoice=0;
				break;
			}
		case 6:
			vc.run(R.tribeView);
			switch(R.tribeC) {
			case 1:
				dao.zergViewer();
				break;
			case 2:
				dao.protossViewer();
				break;
			case 3:
				dao.terranViewer();
				break;
			}
			R.tribeC=0;
			break;
		case 7:
			System.out.println("프로그램 종료");
			System.exit(0);
			break;
		}
		R.choice =0;
		action();
	}
	
}
