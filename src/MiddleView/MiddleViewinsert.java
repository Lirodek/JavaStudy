package MiddleView;

import MiddleController.R;
import MiddlePro.PhoneInfo;

public class MiddleViewinsert extends MiddleView{
	@Override
	public void display() {
		getLine("전화번호부 추가");
		String name = setString("이름 : ");
		String phone = setString("번호 : ");
		int age = setInteger("나이 : ");
		String relation = setString("관계 : ");
		R.pInfo = new PhoneInfo(name, phone, age, relation);
	}
}
