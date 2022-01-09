package PhoneBookViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import PhoneBookConstuct.PhoneBookManager;

public class DeleteEventHandler implements ActionListener{
	JTextField delField;
	JTextArea textArea;
	public DeleteEventHandler(JTextField file,JTextArea area) {
		this.delField = file;
		this.textArea = area;
	}
	public void actionPerformed(ActionEvent e) {
		String name = delField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		boolean isDeleted = manager.deleteData(name);
		if(isDeleted) textArea.append("데이터 삭제를 완료하였습니다.");
		else textArea.append("해당하는 데이터가 존재하지 않습니다.");
		
	}
}
