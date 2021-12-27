package org.Lirodek.HumanController;

import org.Lirodek.HumanView.HumanView;

public class HumanViewTest {
	public static void main(String[] args) {
		ViewContainer vc = new ViewContainer();
		vc.run(R.insertView);
		vc.run(R.humanDelete);
		vc.run(R.humanDetail);
		vc.run(R.humanEdit);
		vc.run(R.humanEdit);
	}
}
