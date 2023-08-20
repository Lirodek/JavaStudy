package org.GamePlayer.GamerView;

import org.GamePlayer.Controller.R;
import org.GamePlayer.Model.GammerVo;

public class GamerViewSearchdata extends GamerView {
	@Override
	public void display() {
		getLine("상세 정보");
		String name = setString("이름 : ");
		R.gameVo = new GammerVo(0,name,null,0,0,0);
		getLine("입력 완료!");
	}
}
