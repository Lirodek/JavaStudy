package org.Lirodek.view;

import org.Lirodek.controller.R;
import org.Lirodek.model.NoticeVo;

public class NoticeAllout extends NoticeView {
	public void display() {
		setLine("전부 출력");
		for(NoticeVo a : R.arr) {
			System.out.println(a);
		}
	}
}
