package org.LiroSelf.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class MakeTitle extends View {
	JPanel panLeft = new JPanel(new GridLayout(7,1));
	ButtonGroup groupRadi=null;
	Border border = BorderFactory.createEmptyBorder();
	public MakeTitle() {
		display();
	}
	
	public void display() {
		add(panLeft);
		
		JPanel namePan = new JPanel();
		
		namePan.setPreferredSize(new Dimension(1, 1));
		namePan.add(new JLabel(" 이  름  "));
		namePan.add(txtName);
		panLeft.add(namePan);
		
		JPanel agePan = new JPanel(new FlowLayout());
		agePan.add(new JLabel(" 나  이  "));
		SpinnerNumberModel model = new SpinnerNumberModel(24, 0, 100, 1);
		JSpinner spinAge = new JSpinner(model);
		agePan.add(spinAge);
		panLeft.add(agePan);
		
		JPanel sexualPan = new JPanel();
		groupRadi = new ButtonGroup();
		groupRadi.add(radiMan);
		groupRadi.add(radiWoman);
		Border radiBorder = BorderFactory.createTitledBorder(border, "성별");
		sexualPan.setBorder(radiBorder);
		
		sexualPan.add(new JLabel(" 남  자  "));
		sexualPan.add(radiMan);
		sexualPan.add(new JLabel(" 여  자  "));
		sexualPan.add(radiWoman);
		panLeft.add(sexualPan);
		
		JPanel comboPan = new JPanel();
		comboPan.add(new JLabel(" 국  가  "));
		comboPan.add(combocountry);
		panLeft.add(comboPan);
		
		JPanel ranguagePan = new JPanel(new GridLayout(2,2));
		Border ranguage = BorderFactory.createTitledBorder(border, "사용 언어");
		ranguagePan.setBorder(ranguage);
		ranguagePan.add(checkJava);
		ranguagePan.add(checkCottle);
		ranguagePan.add(checkPhyton);
		ranguagePan.add(checkC);
		panLeft.add(ranguagePan);
	}

}
