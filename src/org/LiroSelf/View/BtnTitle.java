package org.LiroSelf.View;

import java.awt.Color;

import org.LiroSelf.Event.ButtonEvent;

public class BtnTitle extends View {
	public BtnTitle() {
		display();
	}
	@Override
	public void display() {
		add(btnSearch);
		add(btnInsert);
		add(btnModi);
		add(btnDelete);
		add(btnAll);
		
		ButtonEvent event = new ButtonEvent(this);
		btnSearch.addActionListener(event);
		btnInsert.addActionListener(event);
		btnModi.addActionListener(event);
		btnDelete.addActionListener(event);
		btnAll.addActionListener(event);
		
		setBackground(Color.gray);
		

	}

}
