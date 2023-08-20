package MiddleView;

import MiddlePro.PhoneManager;

public class MiddleViewBring extends MiddleView{
	@Override
	public void display() {
		getLine("저장된 데이터 가져오는중..");
		PhoneManager mana = new PhoneManager();
		mana.bringFile();
	}

}
