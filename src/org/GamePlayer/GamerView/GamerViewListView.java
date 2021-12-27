package org.GamePlayer.GamerView;

import org.GamePlayer.Controller.R;
import org.GamePlayer.Model.GammerVo;

public class GamerViewListView extends GamerView {
	@Override
	public void display() {
		getLine("등록명부");
		for(GammerVo game : R.gameArr) {
			System.out.println(game);
		}
	}
}
