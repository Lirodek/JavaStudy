package org.Lirodek.gulex;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindowListener extends Frame implements WindowListener{
	
	FrameEventEx02 target;
	
	public MyWindowListener(FrameEventEx02 frameEventEx02) 
	{
		target = frameEventEx02;
	}
	
	public void windowClosing(WindowEvent e) 
	{
		System.out.println("프로그램을 종료합니다.");
		target.disable();
		System.exit(0);
	}

	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e)
	{
		System.out.println("뭘까");
	}
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		System.out.println("뭐야");
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		System.out.println("뭐가");
		
	}

}
