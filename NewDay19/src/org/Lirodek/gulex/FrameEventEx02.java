package org.Lirodek.gulex;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowListener;

public class FrameEventEx02 extends Frame{
	
	private static final int WIDTH =600, HEIGHT=400;
	
	public FrameEventEx02() {
		
		super.setTitle("세번째 실습");
		super.setSize(WIDTH, HEIGHT);
		super.setLayout(new FlowLayout());
		super.setVisible(true);
		
		
		WindowListener l = new MyWindowListener(this);
		addWindowListener(l);
		
	}

	public static void main(String[] args) {
		new FrameEventEx02();

	}

}
