package MiddleView;

import MiddleController.R;
import MiddlePro.PhoneInfo;

public class MiddleViewUpdate extends MiddleView {
	@Override
	public void display() {
		getLine("수정");
		String phone = setString("번호 : ");
		int age = setInteger("나이 : ");
		String relation = setString("관계 : ");
		R.pInfo = new PhoneInfo(R.pInfo.getName(),phone,age,relation);
		
	}
}
