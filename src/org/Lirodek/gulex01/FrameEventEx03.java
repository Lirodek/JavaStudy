package org.Lirodek.gulex01;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEventEx03 extends Frame {
	
	private int width =640, height = 480;
	
	class InnerClassListener implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("윈도우 켜짐");
		}
		public void windowClosing(WindowEvent e) 
		{
			System.out.println("프로그램을 종료합니다.");
			dispose();
			System.exit(0);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			System.out.println("윈도우 꺼짐");
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("프로그램 최소화");
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("프로그램 열기");
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			setSize(300, 300);
			setTitle("한번껏다 켰네?");
			System.out.println("넌 뭐야");
			
		}
		
		
		
	}
	
	public FrameEventEx03()
	{
		setTitle("InnerClass활용한 이밴트 처리 연습");
		setSize(width, height);
		setLayout(new FlowLayout());
		setVisible(true);
		
		WindowListener l = new InnerClassListener();
		addWindowListener(l);
		
	}
	
	public static void main(String[] args) {
		new FrameEventEx03();


	}

}
