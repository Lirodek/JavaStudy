package org.Lirodek.HumanView;

import org.Lirodek.HumanController.R;
import org.Lirodek.HumanModel.HumanVo;

public class HumanDetail extends HumanView {
	@Override
	public void display() {
		if(R.type==R.SEARCH) {
			System.out.println("::::: 사람 정보 검색 :::::");
			String name = setString("검색 할 이름 : ");
			R.humanVo = new HumanVo(0,name,null,null);
		}else {
			System.out.println("::::: 사람 정보 상세보기 :::::");
			System.out.println(R.humanVo);
		
		}
		
	}
}
