package org.Lirodek.gulex03;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.Lirodek.gulex02.FrameEventEx04;

public class FrameEventEx06 extends Frame implements WindowListener
{
	
	
	public FrameEventEx06() 
	{
		setTitle("테스트용");
		setSize(640, 480);
		setLayout(new FlowLayout());
		setVisible(true);
		divide();
		normal();
		innerCls();
		anonymous();
		adapter();
	}
	private void adapter() {
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.out.println("어뎁터 사용");
				dispose();
				System.exit(0);
			}
		});
		
	}
	private void anonymous() {
		addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent e) 
			{
				System.out.println("익클");
				dispose();
				System.exit(0);
			}
			public void windowOpened(WindowEvent e)      {}
			public void windowIconified(WindowEvent e)   {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowClosed(WindowEvent e)    {}
			public void windowActivated(WindowEvent e) {}
		});
		
	}
	private void innerCls() {
		WindowListener l = new InnerListener();
		addWindowListener(l);
		
	}
	class InnerListener implements WindowListener{
		public void windowClosing(WindowEvent e) 
		{
			System.out.println("이너클");
			dispose();
			System.exit(0);
		}
		public void windowOpened(WindowEvent e)      {}
		public void windowIconified(WindowEvent e)   {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e)    {}
		public void windowActivated(WindowEvent e) {}
	}
	
	

	private void normal() {
		addWindowListener(this);
		
	}

	private void divide() 
	{
		WindowListener l = new DivideCls(this);
		addWindowListener(l);
	}
	
	public static void main(String[] args) 
	{
		new FrameEventEx06();

	}
	public void windowClosing(WindowEvent e) 
	{
		System.out.println("내부");
		dispose();
		System.exit(0);
	}
	public void windowOpened(WindowEvent e)      {}
	public void windowIconified(WindowEvent e)   {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e)    {}
	public void windowActivated(WindowEvent e) {}
}
class DivideCls implements WindowListener{
	FrameEventEx06 target;
	
	DivideCls(FrameEventEx06 target)
	{
		this.target = target;
	}
	
	public void windowClosing(WindowEvent e) 
	{
		System.out.println("나눠진 클");
		target.dispose();
		System.exit(0);
	}
	
	public void windowOpened(WindowEvent e)      {}
	public void windowIconified(WindowEvent e)   {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e)    {}
	public void windowActivated(WindowEvent e) {}
	
}
