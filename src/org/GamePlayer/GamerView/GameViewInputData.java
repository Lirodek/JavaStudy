package org.GamePlayer.GamerView;

import org.GamePlayer.Controller.R;
import org.GamePlayer.Model.GammerVo;

public class GameViewInputData extends GamerView {
	@Override
	public void display() {
		getLine("입력 ");
		String name = setString("이름 : ");
		String tribe = setString("종족 : ");
		int terran = setInteger("vsT : ");
		int protoss = setInteger("vsP : ");
		int zerg = setInteger("vsZ : ");
		R.gameVo = new GammerVo(0,name,tribe,terran,protoss,zerg);
		getLine("입력 완료!");
	}
}
