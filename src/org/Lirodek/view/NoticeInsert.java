package org.Lirodek.view;

import org.Lirodek.controller.R;
import org.Lirodek.model.NoticeVo;

public class NoticeInsert extends NoticeView {
	@Override
	public void display() {
		setLine("입력");
		String name = getString("유저명 : ");
		String message = getString("메모 : ");
		String regDate = getDate();
		R.nVo = new NoticeVo(0,name,message,regDate);
	}
}
