
package org.Lirodek.view;

import org.Lirodek.controller.R;
import org.Lirodek.model.NoticeVo;

public class NoticeName extends NoticeView {
	@Override
	public void display() {
		if(R.cnt ==0) {
			setLine("user 검색");
			String name = getString("이름 : ");
			R.nVo = new NoticeVo(0,name,"","");
			R.cnt=1;
		}
	}
}