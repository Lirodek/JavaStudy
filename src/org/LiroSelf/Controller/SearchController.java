package org.LiroSelf.Controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.LiroSelf.Frame.SearchFrame;
import org.LiroSelf.Model.DataMake;

public class SearchController implements Controller{

	@Override
	public void service() {
		DataMake dto = new DataMake();
		String name = JOptionPane.showInputDialog("이름 검색");
		dto = dao.searchData(name);
		if(dto == null) {
			JOptionPane.showMessageDialog(new JButton("확인"), name+"을 찾지못했습니다.");
		} else {
			SearchFrame sFrame = new SearchFrame(dto);
		}
		
	}

}
