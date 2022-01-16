package org.LiroSelf.Controller;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.LiroSelf.Model.DataMake;

public class InsertController implements Controller{

	@Override
	public void service() {
		checkText();
		settingeText();
		
		
		ctrlMap.get(btnAll).service();
	}
	private void checkText() {
		DataMake dm; 
		
		String ranguage = "";
		String name = txtName.getText();//이름
		if(name.length()<1) {
			JOptionPane.showMessageDialog(new JButton("확인"), "이름을 입력해주세요");
			return;
		}
		String nation = combocountry.getSelectedItem().toString();
		String firstPhone = txtFirst.getText();
		String secondPhone = txtLast.getText();
		String sex;
		boolean man = radiMan.isSelected();
		if(man==true) sex = "남자";
		else sex = "여자";
		int age = ( int )spinAge.getValue();
		boolean java = checkJava.isSelected();
		if(java==true) ranguage += "J ";
		boolean cottlean = checkCottle.isSelected();
		if(cottlean==true) ranguage += "Cott ";
		boolean phyton = checkPhyton.isSelected();
		if(phyton==true) ranguage += "P ";
		boolean C = checkC.isSelected();
		if(C==true) ranguage += "C ";
		String phoneNumber = firstPhone+" - "+secondPhone;
		
		dm = new DataMake(0, name, age, phoneNumber, sex, nation, ranguage);
		dao.dataInsert(dm);
	}
	private void settingeText() {
		txtName.setText("");
		txtName.setEditable(true);
		txtFirst.setText("");
		txtFirst.setEditable(true);
		txtLast.setText("");
		txtLast.setEditable(true);
	}
	
}
