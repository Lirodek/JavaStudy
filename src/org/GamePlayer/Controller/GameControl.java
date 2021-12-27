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
			System.out.println(R.gameVo==null?"":R.gameVo);
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
			R.type =R.GOING;
			dao.gameModi(R.gameVo);
			break;
		case 6:
			vc.run(R.tribeView);
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
