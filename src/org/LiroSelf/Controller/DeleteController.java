package org.LiroSelf.Controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.LiroSelf.Model.DataMake;

public class DeleteController implements Controller{
	JButton ok = new JButton("확인");
	@Override
	public void service() {
		DataMake dto = new DataMake();
		String specialNumber = JOptionPane.showInputDialog("회원번호");
		boolean a = dao.dataDelete(specialNumber);
		if(a==true) {
			JOptionPane.showMessageDialog(ok, specialNumber+"님을 목록에서 제거했습니다");
		} else {
			JOptionPane.showMessageDialog(ok, specialNumber+"님을 찾지 못했습니다.");
		}
	}

}
