package org.LiroSelf.Controller;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.LiroSelf.Frame.SearchFrame;
import org.LiroSelf.Model.DataMake;

public class SearchController implements Controller{

	@Override
	public void service() {
		Vector<DataMake> vector = new Vector<DataMake>();
		String name = JOptionPane.showInputDialog("이름 검색");
		vector = dao.searchData(name);
		if(vector == null) {
			JOptionPane.showMessageDialog(new JButton("확인"), name+"을 찾지못했습니다.");
		} else {
			SearchFrame sFrame = new SearchFrame(vector);
			
		}
		
	}

}
