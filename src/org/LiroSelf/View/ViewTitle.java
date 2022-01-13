package org.LiroSelf.View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.LiroSelf.Resource.R;

public class ViewTitle extends View{

	public ViewTitle(){
		display();
	}
	public void display() {
		JLabel labelTitle = new JLabel(title);
		labelTitle.setFont(new Font("Arial", Font.BOLD, 28));
		this.add(labelTitle);
		
		setBackground(Color.gray);
		labelTitle.setForeground(Color.darkGray);
		

	}

}
