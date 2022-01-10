package org.Lirodek.gulex.MyFrame;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame2 extends Frame{
	
	public MyFrame2() {
		this("테스트", 640, 480);
	}

	public MyFrame2(String tile, int w, int h) {
		super.setTitle(tile);
		super.setSize(w, h);
		
		//start
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) 
			{
				System.out.println("프로그램을 종료합니다.");
				dispose();
				System.exit(0);
				
			}
		}); 
		//end
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scW = ( int ) tk.getScreenSize().getWidth();
		int scH = ( int ) tk.getScreenSize().getHeight();
		
		int x = ( scW / 2 ) - ( w / 2 ) ;
		int y = ( scH / 2 ) - ( h / 2 ) ;
		setLocation(x, y);
	}
	
	

}
