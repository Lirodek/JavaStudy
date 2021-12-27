package org.GamePlayer.GamerView;

import org.GamePlayer.Controller.R;
import org.GamePlayer.Model.GammerVo;

public class GamerViewDelete extends GamerView {
	@Override
	public void display() {
		getLine("데이터 삭제");
		String name = setString("이름 : ");
		R.gameVo = new GammerVo(0,name,null,0,0,0);
	}
}
