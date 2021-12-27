package org.GamePlayer.GamerView;

import org.GamePlayer.Controller.R;
import org.GamePlayer.Model.GammerVo;

public class GamerViewModi extends GamerView{
	@Override
	public void display() {
		getLine("입력정보 수정");
		if(R.type == R.SEARCH) {
			String name = setString("이름 : ");
			R.gameVo = new GammerVo(0,name,null,0,0,0);
			
		}
		if(R.type == R.GOING) {
			System.out.println("1.저그전승률변경");
			System.out.println("2.프로토스전승률변경");
			System.out.println("3.테란전승률변경");
			System.out.println("4.종족변경");
			R.modiChoice = setInteger("선택 : ");
			switch(R.modiChoice) {
			case 1:
				System.out.println("저그전 승률변경");
				int vsZerg = setInteger("저그전 :");
				R.gameVo = new GammerVo(0, R.gameVo.getName(), null, 0, 0, vsZerg);
				break;
			case 2:
				System.out.println("프로토스전 승률변경");
				int vsProtoss = setInteger("프로토스전 :");
				R.gameVo = new GammerVo(0, R.gameVo.getName(), null, 0, vsProtoss, 0);
				break;
			case 3:
				System.out.println("테란전 승률변경");
				int vsTerran = setInteger("테란전 :");
				R.gameVo = new GammerVo(0, R.gameVo.getName(), null, vsTerran, 0, 0);
				break;
			case 4:
				System.out.println("종족변경");
				String tribe = setString("종족 : ");
				int Zerg = setInteger("저그전 :");
				int Protoss = setInteger("프로토스전 :");
				int Terran = setInteger("테란전 :");
				R.gameVo = new GammerVo(0, R.gameVo.getName(), tribe, Terran, Protoss, Zerg);
				break;
			default : 
					System.out.println("올바른 숫자를 입력해주세요!");
			}
		}
				
	}
}
