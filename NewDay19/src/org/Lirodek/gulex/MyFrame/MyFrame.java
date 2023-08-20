package org.Lirodek.gulex.MyFrame;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	
	public MyFrame() {
		this("MyFrame", 200, 200);
	}

	public MyFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		//중앙화면 가져오기
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrW = ( int ) tk.getScreenSize().getWidth();
		int scrH = ( int ) tk.getScreenSize().getHeight();
		int x = scrW/2 - w/2;
		int y = scrH/2 - h/2;
		this.setLocation(x, y);
		//이밴트 핸들러
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e) 
			{
				System.out.println("프로그램을 종료합니다.");
				dispose();
				System.exit(0);
			}
		});//WindowAdt의 끝
		
	}
}
