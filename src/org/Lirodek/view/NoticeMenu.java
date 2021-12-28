package org.Lirodek.view;

import org.Lirodek.controller.R;

public class NoticeMenu extends NoticeView {
	@Override
	public void display() {
		setLine("메뉴");
		System.out.println("1.입력 2.출력 3.수정 4.삭제 \n5.전체출력 6.이름별 검색 7.종료");
		System.out.println("-------------------------");
		R.choice = getInteger("입력 : ");
		
	}
}
