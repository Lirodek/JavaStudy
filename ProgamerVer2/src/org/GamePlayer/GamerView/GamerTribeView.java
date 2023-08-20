package org.GamePlayer.GamerView;

import org.GamePlayer.Controller.R;
import org.GamePlayer.Model.GammerVo;

public class GamerTribeView extends GamerView{
	@Override
	public void display() {
		getLine("종족별 보기");
		System.out.println("1.저그현황 2.토스현황 3.테란현황");
		R.tribeC = setInteger("입력 : ");
		
	}
}
