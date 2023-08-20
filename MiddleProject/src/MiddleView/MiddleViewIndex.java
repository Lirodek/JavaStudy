package MiddleView;

import java.util.Iterator;

import MiddleController.R;
import MiddlePro.PhoneInfo;

public class MiddleViewIndex extends MiddleView {
	@Override
	public void display() {
		getLine("전화번호 목록");
		try {
			Iterator<PhoneInfo> itr = R.aList.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next().toString());
			}
		} catch (Exception e) {
			System.out.println("전화목록이 비어있습니다.");
		}
		
	}
}
