package org.Lirodek.LayoutEx02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import org.Lirodek.gulex.MyFrame.MyFrame;
import org.Lirodek.gulex.MyFrame.MyFrame2;

public class LayoutEx02 extends MyFrame2
{
	
	ArrayList< Button > btns = new ArrayList< Button > ();
	{
		for(int i=1;i<7;i++) 
		{
			btns.add(new Button("btn"+i));
		}
	}

	public LayoutEx02() 
	{
		super("두번째", 640, 480);
		
//		BorderLayoutEx();
//		FlowLayoutEx();
		GridLayoutEx();
//		GridBagEx();
//		CardLayoutEx();
		
	}
	
	private void CardLayoutEx() {
		setLayout(new CardLayout(20,30));
		add(new Button("CardButton"));
	}

	private void GridBagEx() {
		setLayout(new GridBagLayout());
		
		for( Button btn :  btns)
		{
			add(btn);
		}
		
	}

	private void GridLayoutEx() {
		setLayout(new GridLayout(5, 6, 5, 5));
		for( Button btn :  btns)
		{
			add(btn);
		}
		
	}

	private void FlowLayoutEx()
	{
		setLayout(new FlowLayout());
		for( Button btn : btns )
		{
			add(btn);
		}
		
	}

	private void BorderLayoutEx() 
	{
		add(BorderLayout.WEST, btns.get(1));
		add(BorderLayout.EAST, btns.get(2));
		add(BorderLayout.SOUTH, btns.get(3));
		add(BorderLayout.NORTH, btns.get(4));
		add(BorderLayout.CENTER, btns.get(5));
//		add(BorderLayout.AFTER_LINE_ENDS, btns.get(6));
		
	}

	public static void main(String[] args) 
	{
		//화면에 보이는 설정은 맨 마지막.
		new LayoutEx02().setVisible(true);
	}

}
