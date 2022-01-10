package org.Lirodek.gulex02;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEventEx04 extends Frame 
{
	
	
	public FrameEventEx04(String title) 
	{
		setTitle( title );
		setSize(640, 480);
		setVisible( true );
		//inteface를 구현하며 인스턴스 생성 가능 ( 익명 내부 클래스 )
		//휘발성 클래스                       1회용 클래스 객체
		addWindowListener( new WindowListener() 
		{
			public void windowOpened(WindowEvent e)      {}
			public void windowIconified(WindowEvent e)   {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowClosing(WindowEvent e) 
			{
				FrameEventEx04.this.dispose();
				System.exit(0);
			}
			public void windowClosed(WindowEvent e)    {}
			public void windowActivated(WindowEvent e) {}
		});
	}
	
	public static void main(String[] args)
	{
		new FrameEventEx04(
				
		"익룡 내부클래스를 활용한 이밴트 핸들러 구현"
				
		);

	}

}
