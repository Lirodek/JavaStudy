package org.LiroSelf.Resource;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class testMain extends JFrame {
	Container contentPan;
	JPanel panel = new JPanel();
	// 라디오 테스트 부분

	public testMain() {
		this.setTitle("콤보박스 테스트 라디오");
		this.setSize(400, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		radiTest();
		contentPan = getContentPane();
		borderTest();
		radiTest();
		comboTest();
		ceheckTest();
		contentPan.add(panel);
		String a = "한";
		int i = a.charAt(0);
		i/=1000;
		System.out.println(i);
		
		
	}

	private void ceheckTest() {
		Border border = BorderFactory.createEmptyBorder();
		Border srchBorder = BorderFactory.createTitledBorder("언어");
		JPanel checkPanel = new JPanel(new GridLayout(4,1,3,3));
		checkPanel.setBorder(srchBorder);
		JCheckBox checkJava = new JCheckBox("자바");
		JCheckBox checkCottle = new JCheckBox("코틀린");
		JCheckBox checkPhyton = new JCheckBox("파이썬");
		JCheckBox checkC = new JCheckBox("C언어");
		
		checkPanel.add(checkJava);
		checkPanel.add(checkCottle);
		checkPanel.add(checkPhyton);
		checkPanel.add(checkC);
		
		panel.add(checkPanel);
		
		
		
	}

	private void borderTest() {
		Border border = BorderFactory.createEmptyBorder();
		Border srchBorder = BorderFactory.createTitledBorder("전화번호");
		JPanel srchPanel = new JPanel();
		srchPanel.setBorder(srchBorder);
		srchPanel.setLayout(new FlowLayout());
		srchPanel.add(new JTextField(3));
		srchPanel.add(new JTextField(4));
		srchPanel.add(new JTextField(4));
		panel.add(srchPanel);

	}

	private void comboTest() {
		String countryValue[] = { "한국", "미국", "일본", "중국", "독일" };
		JComboBox<String> combocountry = new JComboBox<String>(countryValue);
		panel.add(combocountry);

	}

	private void radiTest() {
		JRadioButton radi[] = new JRadioButton[2];
		String radi_value[] = { "남자", "여자" };
		ButtonGroup groupRadi = new ButtonGroup();

		for (int i = 0; i < radi.length; i++) {
			radi[i] = new JRadioButton(radi_value[i]);
			groupRadi.add(radi[i]);
			panel.add(radi[i]);
		}
		radi[0].setSelected(false);
		radi[1].setSelected(true);

		this.add(panel);

	}

	public static void main(String[] args) {
		new testMain().setVisible(true);
	}
}
