package org.LiroSelf.Frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.LiroSelf.Model.DataMake;

public class SearchFrame extends JFrame {

	Container contentPane;

	/**
	 * Create the frame.
	 */
	public SearchFrame(DataMake dto) {
		
		setVisible(true);
		setBounds(100, 100, 600, 150);
		setting(600,150);
		contentPane = getContentPane();
		JPanel panel = new JPanel(new GridLayout(2,1));
		Vector secretColumn = new Vector();
		secretColumn.add("회원번호");
		secretColumn.add("이   름");
		secretColumn.add("나   이");
		secretColumn.add("번   호");
		secretColumn.add("성   별");
		secretColumn.add("국   가");
		secretColumn.add("언   어");
		Vector data = new Vector();
		data.add(dto.getVectorAll());
		DefaultTableModel searchModel = new DefaultTableModel(data, secretColumn) {
			public boolean isCellEditable(int rowIdx, int mColIdx) {
				return false;
			}
		};
		
		searchModel.setColumnCount(7);
		JTable searchTable = new JTable(searchModel);
		panel.add(new JScrollPane(searchTable));
		JButton cencle = new JButton("확인");
		cencle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		JPanel btn = new JPanel(new GridBagLayout());
		btn.add(cencle);
		panel.add(btn);
		contentPane.add(panel);
	}
	
	private void setting(int w, int h) {
		Toolkit tk = getToolkit().getDefaultToolkit();
		int scrW = ( int )tk.getScreenSize().getWidth();
		int scrH = ( int )tk.getScreenSize().getHeight();
		int x = scrW/2 - w/2;
		int y = scrH/2 - h/2;
		setLocation(x, y);
	}

}
