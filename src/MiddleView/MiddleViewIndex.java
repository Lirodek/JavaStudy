package MiddleView;

import java.util.ArrayList;
import java.util.Iterator;

import MiddleController.R;
import MiddlePro.PhoneInfo;

public class MiddleViewIndex extends MiddleView {
	@Override
	public void display() {
		getLine("전화번호 목록");
		Iterator<PhoneInfo> itr = R.aList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
		
	}
}
