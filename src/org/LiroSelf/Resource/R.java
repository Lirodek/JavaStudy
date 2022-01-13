package org.LiroSelf.Resource;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public interface R {
	String title = "Title Pro";
	final int frameWidth=720, frameHeight=480;
	
	public static final int txtSIZE = 10; 
	public static final int firstSIZE = 3;
	public static final int phoneSIZE = 4;
	
	JTextField txtName = new JTextField(txtSIZE);
	JTextField txtSmall = new JTextField(firstSIZE);
	JTextField txtFirst = new JTextField(phoneSIZE);
	JTextField txtlast = new JTextField(phoneSIZE);
	
	JRadioButton radiMan = new JRadioButton();
	JRadioButton radiWoman = new JRadioButton();
	
	String countryValue[] = {"한국", "미국", "일본", "중국", "독일"};
	JComboBox<String> combocountry = new JComboBox<String>(countryValue);
	
	JCheckBox range = new JCheckBox();
	
	JCheckBox checkJava = new JCheckBox("자바");
	JCheckBox checkCottle = new JCheckBox("코틀린");
	JCheckBox checkPhyton = new JCheckBox("파이썬");
	JCheckBox checkC = new JCheckBox("C언어");
	
	JButton btnSearch = new JButton("검색");
	JButton btnInsert = new JButton("추가");
	JButton btnModi = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnExit = new JButton("종료");
	
	
	

}
