package MiddleView;

import MiddleController.R;
import MiddlePro.PhoneInfo;

public class MiddleViewDelete extends MiddleView{
	@Override
	public void display() {
		getLine("전화번호부 삭제");
		String name = setString("이름 : ");
		R.pInfo = new PhoneInfo(name, null, 0, null);
	}
}
