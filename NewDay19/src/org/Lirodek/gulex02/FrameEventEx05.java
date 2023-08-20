package org.Lirodek.gulex02;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEventEx05 extends Frame 
{
	
	
	public FrameEventEx05(String title) 
	{
		setTitle( title );
		setSize(640, 480);
		setVisible( true );
		//inteface를 구현하며 인스턴스 생성 가능 ( 익명 내부 클래스 )
		//휘발성 클래스                       1회용 클래스 객체
		
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e) {
				FrameEventEx05.this.dispose();
				System.exit(0);
				super.windowClosing(e);
			}
		});
		
	}
	
	public static void main(String[] args)
	{
		new FrameEventEx05(
				
		"익룡 내부클래스를 활용한 이밴트 핸들러 구현"
				
		);

	}

}
