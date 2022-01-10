package org.Lirodek.LayoutEx02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.Lirodek.gulex.MyFrame.MyFrame;

public class LayoutEx01 extends MyFrame{
	
	//Panel을 이용한 세부 레이아웃 설정
	Panel centerPan = new Panel( new GridBagLayout() );
	Label centerLbl = new Label( "Hello Java World" );
	
	Panel southPan = new Panel( new GridLayout( 1, 3 ) );
	Panel innerPan = new Panel( new GridLayout( 2, 1 ) );
	
	Button btn1 = new Button("BTN1");
	Button btn2 = new Button("BTN2");
	Button btn3 = new Button("BTN3");
	Button btn4 = new Button("BTN4");
	
	public LayoutEx01()
	{
		layoutEx02();
	}
	
	public void layoutEx02()
	{
		// 중앙에 붙인다
		add(BorderLayout.CENTER, centerPan);
		centerPan.add(centerLbl);
		// 하단에 붙인다.
		southPan.add(btn1);
		southPan.add(btn2);
		southPan.add(innerPan);
		innerPan.add(btn3);
		innerPan.add(btn4);
		
		this.add(BorderLayout.NORTH, southPan);
		getButtonEvent(btn1, "버튼 1");
		getButtonEvent(btn2, "버튼 2");
		getButtonEvent(btn3, "버튼 3");
		getButtonEvent(btn4, "버튼 4");
		
		
		
		
	}
	public void getButtonEvent(Button btn, String s)
	{
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(s);
				
			}
		});
	}

	public static void main(String[] args) {
		new LayoutEx01().setVisible(true);
	}

}
