package org.LiroSelf.View;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

import org.LiroSelf.Resource.R;

public class ViewMain extends MyJFrame implements R{
	View viewTitle = new ViewTitle();
	View viewMake = new MakeTitle();
	View viewBtn = new BtnTitle();
	public ViewMain() {
		contentPane = getContentPane();
		setTitle(title);
		setSize(frameWidth,frameHeight);
		display();
		
	}

	private void display() {
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.NORTH, viewTitle);
		contentPane.add(BorderLayout.WEST, viewMake);
		contentPane.add(BorderLayout.SOUTH, viewBtn);
//		View viewInto = new InfoTitle();
		
	}
	public static void main(String[] args) {
		new ViewMain().setVisible(true);;
	}

}
