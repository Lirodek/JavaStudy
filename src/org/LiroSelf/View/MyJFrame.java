package org.LiroSelf.View;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class MyJFrame extends JFrame{
	Container contentPane=null;
	public MyJFrame() {
		this("무명", 300, 400);
	}
	public MyJFrame(String title, int w, int h) {
		super.setTitle(title);
		super.setSize(w, h);
		clossing();
		setting(w, h);
		
	}
	private void setting(int w, int h) {
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrW = ( int ) tk.getScreenSize().getWidth();
		int scrH = ( int ) tk.getScreenSize().getHeight();
		int x = scrW/2 - w/2;
		int y = scrH/2 - h/2;
		this.setLocation(x, y);
		
	}
	private void clossing() {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}