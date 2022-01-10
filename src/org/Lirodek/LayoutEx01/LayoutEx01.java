package org.Lirodek.LayoutEx01;

import org.Lirodek.gulex.MyFrame.MyFrame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;


public class LayoutEx01 extends MyFrame{
	public Button btn1 = new Button(" BTN1 ");
	public Button btn2 = new Button(" BTN2 ");
	public Button btn3 = new Button(" BTN3 ");
	public Button btn4 = new Button(" BTN4 ");
	public Button btn5 = new Button(" BTN5 ");
	
	public ArrayList<Button> btns = new ArrayList<Button>();
	{
		for(int i=0; i<100;i++)
		{
			btns.add(new Button( "BTN" + i ));
		}
	}
	
	public LayoutEx01() 
	{
		super("테스트시작",640,480);
		GridBagLayoutEx();
		
		super.setVisible(true);
	}
	
	private void CardLayoutEx() {
		setLayout(new CardLayout(200, 80));
		add(btn1);
	}

	private void GridBagLayoutEx()
	{
		//이미지 큰거하나 정가운대에 붙일때
		this.setLayout(new GridBagLayout());
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btns.get(10));
	}
	
	private void GridLayoutEx() 
	{
		setLayout(new GridLayout(3, 2, 5, 5));
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btns.get(10));
		
	}

	public void FlowLayoutEx() 
	{	
		setLayout(new FlowLayout());
		//FlowLayout - Left => Right
		for(Button btn : btns)
		{
			this.add(btn);
		}
		
	}
	
	public void borderLayoutEx() {
		// Window를 상속받은 Frame은
		// DefaultLayout이 BorderLayout( 테두리에 갖다붙인다 )
		add(BorderLayout.NORTH ,btn1);
		add(BorderLayout.SOUTH ,btn2);
		add(BorderLayout.EAST ,btn3);
		add(BorderLayout.WEST ,btn4);
		add(BorderLayout.CENTER ,btn5);

	}

	public static void main(String[] args) {
		new LayoutEx01();

	}

}
