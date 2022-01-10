package Day19SwingAwtEx02Windows;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex03Frame extends Frame {
	
	
	class InnerClassClosing implements WindowListener
	{

		public void windowOpened(WindowEvent e) {}
		public void windowClosing(WindowEvent e) 
		{
			System.out.println("프로그램 종료");
			dispose();
			System.exit(0);
			
		}
		public void windowClosed(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
	}
	
	public Ex03Frame() 
	{
		InnerClassClosing icc = new InnerClassClosing();
		super.setLayout(new FlowLayout());
		super.add(new Button("Hello"));
		super.setTitle("연습 2번");
		super.setSize(200, 300);
		super.setVisible(true);
		
		
		this.addWindowListener(icc);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex03Frame();
	}

}
