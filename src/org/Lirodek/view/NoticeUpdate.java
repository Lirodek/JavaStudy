package org.Lirodek.view;

import org.Lirodek.controller.R;
import org.Lirodek.model.NoticeVo;

public class NoticeUpdate extends NoticeView {
	@Override
	public void display() {
		System.out.println("메모수정");
		R.no = getInteger("수정할 메모번호 : ");
		String name = getString("작성자 : ");
		String massage = getString("메모 : ");
		String regDate = updateDate();
		R.nVo  = new NoticeVo(R.no,name,massage,regDate);
	}
}
