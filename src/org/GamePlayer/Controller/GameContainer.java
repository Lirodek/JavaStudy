package org.GamePlayer.Controller;

import org.GamePlayer.GamerView.GamerView;

public class GameContainer {
	public void Boundary() {
		System.out.println("---------------------");
	}
	public void run(GamerView view) {
		view.display();
	}
}
