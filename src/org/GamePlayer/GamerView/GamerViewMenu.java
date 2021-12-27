package org.GamePlayer.GamerView;

import org.GamePlayer.Controller.R;

public class GamerViewMenu extends GamerView {
	@Override
	public void display() {
		getLine("목록");
		System.out.println("1.입력 2.상세보기 3.등록명부 4.데이터 삭제 5.데이터 수정 6.종족별보기 7.종료");
		int choice;
		while(true) {
			try {
				choice = setInteger("선택 : ");
				while(choice>8||choice<1) {
					System.out.println("범위를 벗어났습니다.");
					choice = setInteger("다시 선택 : ");
				}
				break;
			} catch (Exception e) {
				System.out.print("JustInteger.");
				sci.next();
				continue;
			}
		}
		R.choice = choice;
	}
}
