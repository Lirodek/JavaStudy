package PhoneBookViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import PhoneBookConstuct.PhoneBookManager;

class searchEventHandler implements ActionListener{
	JTextField searchField;
	JTextArea textArea;
	public searchEventHandler(JTextField srchFiled, JTextArea textArea2) {
		this.searchField = searchField;
		this.textArea = textArea;
	}
	public void actionPerformed(ActionEvent e) {
		String name = searchField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		String searchResult = manager.searchData(name);
		if(searchResult==null) System.out.println("해당하는 데이터가 존재하지 않습니다.\n");
		else {
			textArea.append("찾으시는 정보를 알려드립니다.\n");
			textArea.append(searchResult);
			textArea.append("\n");
		}
	}
}
