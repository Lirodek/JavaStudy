package org.LiroSelf.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;

public class MakeTitle extends View {
	JPanel panLeft = new JPanel(new GridLayout(8,1));
	Border border = BorderFactory.createEmptyBorder();
	public MakeTitle() {
		display();
	}
	
	public void display() {
		add(panLeft);
		
		JPanel namePan = new JPanel();
		
		namePan.setPreferredSize(new Dimension(1, 1));
		namePan.add(new JLabel(" 이  름  "));
		txtName.addKeyListener(new KeyBoradUtill(txtName));
		namePan.add(txtName);
		panLeft.add(namePan);
		
		JPanel agePan = new JPanel(new FlowLayout());
		agePan.add(new JLabel(" 나  이  "));
		
		Border srchBorder = BorderFactory.createTitledBorder("전화번호");
		JPanel srchPanel = new JPanel();
		srchPanel.setBorder(srchBorder);
		srchPanel.setLayout(new FlowLayout());
		txtSmall.setText("  010");
		txtSmall.setEditable(false);
		srchPanel.add(txtSmall);
		txtFirst.addKeyListener(new KeyBoradUtill(txtFirst));
		srchPanel.add(txtFirst);
		txtLast.addKeyListener(new KeyBoradUtill(txtLast));
		srchPanel.add(txtLast);
		panLeft.add(srchPanel);
		
		agePan.add(spinAge);
		panLeft.add(agePan);
		
		JPanel sexualPan = new JPanel();
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
	class KeyBoradUtill extends KeyAdapter{
		JTextField txt;
		KeyBoradUtill(JTextField txtfirst){
			this.txt = txtfirst;
		}
		public void keyTyped(KeyEvent k) {
			String str = txt.getText();
			int c = str.length();
			if(c>3&& k.getKeyChar()==0)
				txt.setEditable(true);
			else if(c>3)
				txt.setEditable(false);
		}
	}
	
	

}
