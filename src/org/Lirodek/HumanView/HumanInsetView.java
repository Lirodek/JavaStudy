package org.Lirodek.HumanView;

import org.Lirodek.HumanController.R;
import org.Lirodek.HumanModel.HumanVo;

public class HumanInsetView extends HumanView {
	@Override
	public void display() {
		System.out.println("::::: 입력기능 :::::");
		//성명, 전화, 이메일
		//R.humanvo저장후 controller로 이동
		String name = setString("이름 : ");
		String phone = setString("번호 : ");
		String email = setString("이메일 : ");
		R.humanVo = new HumanVo(0,name,phone,email);
		System.out.println("입력 완료!");
	}
	
}
