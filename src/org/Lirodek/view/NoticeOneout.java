package org.Lirodek.view;

import org.Lirodek.controller.R;
import org.Lirodek.model.NoticeVo;

public class NoticeOneout extends NoticeView {
	@Override
	public void display() {
		setLine("메모 출력");
		R.no = getInteger("메모번호 : ");
		R.nVo = new NoticeVo(R.no,"","","");
	}
}
