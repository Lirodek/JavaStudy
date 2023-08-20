package org.Lirodek.view;

import org.Lirodek.controller.R;
import org.Lirodek.model.NoticeVo;

public class NoticeDelete extends NoticeView {
	@Override
	public void display() {
		setLine("메모삭제");
		System.out.println("몇번 메모를 삭제할까요?");
		R.no = getInteger("번호 : ");
		R.nVo = new NoticeVo(R.no,"","","");
		
	}
}
