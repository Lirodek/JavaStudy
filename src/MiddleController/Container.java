package MiddleController;

import MiddleView.MiddleView;

public class Container {
	public void Boundary() {
		System.out.println("---------------------");
	}
	public void run(MiddleView view) {
		view.display();
	}
}
