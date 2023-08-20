package MiddleView;

import MiddleController.R;
import MiddlePro.PhoneInfo;

public class MiddleViewSearch extends MiddleView{
	@Override
	public void display() {
		
		getLine("전화번호부 검색");
		String name = setString("이름 : ");
		R.pInfo = new PhoneInfo(name, null, 0, null);
	}
}
