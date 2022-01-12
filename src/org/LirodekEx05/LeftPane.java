package org.LirodekEx05;

import java.awt.BorderLayout;


import java.awt.GridLayout;
import java.awt.Label;


import static org.LirodekEx05.R.*;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.Lirodek.gulex.MyFrame.MyJFrame;

public class LeftPane extends JPanel {

	public LeftPane() {
		

		JPanel rowPan1 = new JPanel();
		rowPan1.add(new Label("ID : "));
		rowPan1.add(txtFld1);
		JPanel rowPan2 = new JPanel();
		rowPan2.add(new Label("NAME : "));
		rowPan2.add(txtFld2);
		JPanel rowPan3 = new JPanel();
		rowPan3.add(new Label("E-MAIL : "));
		rowPan3.add(txtFld3);
		JPanel rowPan4 = new JPanel();
		rowPan4.add(new Label("PHONE : "));
		rowPan4.add(txtFld4);

		JPanel gridPan = new JPanel(new GridLayout(5, 1));
		
		gridPan.add(new Label("::: Input Data :::"));
		gridPan.add(rowPan1);
		gridPan.add(rowPan2);
		gridPan.add(rowPan3);
		gridPan.add(rowPan4);

		this.add(gridPan);
	}

}
