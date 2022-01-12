package org.LirodekEx05;

import javax.swing.JButton;
import static org.LirodekEx05.R.*;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class BottomPane extends JPanel{
	public BottomPane(){
		this.add(allBtn);
		this.add(inputBtn);
		this.add(searchBtn);
		this.add(modifyBtn);
		this.add(deleteBtn);
		this.add(finishBtn);
	}
}
