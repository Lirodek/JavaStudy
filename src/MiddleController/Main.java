package MiddleController;

import MiddleView.MiddleView;
import MiddleView.MiddleViewBring;

public class Main {
	public Main() {
		MiddleView vBring = new MiddleViewBring();
		Container pc = new Container();
		pc.run(vBring);
		start();
	}
	private void start() {
		
		
		while(true) {
			R.pstart.action();
		}
		
	}
	public static void main(String[] args) {
		new Main();

	}

}
