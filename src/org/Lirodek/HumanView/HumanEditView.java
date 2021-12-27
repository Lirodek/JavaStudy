package org.Lirodek.HumanView;

import org.Lirodek.HumanController.R;
import org.Lirodek.HumanModel.HumanVo;

public class HumanEditView extends HumanView {
	@Override
	public void display() {
		System.out.println("::::: 정보 수정 :::::");
		int member = setMember("회원 번호 : ");
		String name = setString("이름 : ");
		String phone = setString("번호 : ");
		String email = setString("메일 : ");
		R.humanVo = new HumanVo(member,name,phone,email);
		System.out.println("입력 완료!");
	}
	public int setMember(String s) {
		System.out.print(s);
		int member = sci.nextInt();
		return member;
	}
}
