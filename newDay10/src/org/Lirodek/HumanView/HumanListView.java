package org.Lirodek.HumanView;

import org.Lirodek.HumanController.R;
import org.Lirodek.HumanModel.HumanVo;

public class HumanListView extends HumanView {
	@Override
	public void display() {
		System.out.println("::::: 사람 정보 보기 :::::");
		for(HumanVo human : R.humanArr) {
			System.out.println(human);
		}
	}
}
