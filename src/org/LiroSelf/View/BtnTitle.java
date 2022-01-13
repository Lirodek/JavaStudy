package org.LiroSelf.View;

public class BtnTitle extends View {
	public BtnTitle() {
		display();
	}
	@Override
	public void display() {
		add(btnSearch);
		add(btnInsert);
		add(btnModi);
		add(btnDelete);
		add(btnExit);

	}

}
