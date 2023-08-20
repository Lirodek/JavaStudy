package org.LirodekEx05;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx01 extends JFrame {
	private int w = 640, h = 480;
	Container         contentPane;
	JTable            table;
	DefaultTableModel tableModel;
	JScrollPane       scrollPane;
	
	Object[][] rowData;
	Object[]   colNames;
	
	static int size=0;
	
	private void init() {
		contentPane = getParent();
		contentPane.setBackground(Color.WHITE);
		setSize(w,h);
		mkTbl();
		
	}
	
	private void mkTbl() {
		colNames = new Object[] {"idx", "name", "phone"};
		rowData  = new Object[][] 
		{
			{1, "kim", "1111-1111"}, {2, "lee", "2222-2222"},
			{3, "park", "3333-3333"}, {4, "kang", "4444-4444"},
			{5, "Bae", "5555-5555"}
		};
		
		tableModel = new DefaultTableModel(rowData, colNames);
		table = new JTable(tableModel);
		
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		
		
		//------------update
		
//		tableModel.setDataVector(null, colNames);
//		tableModel.addRow(new Object[] {3, "ccc", "7777-7777" });
//		tableModel.addRow(new Object[] {4, "ddd", "8888-8888" });
//		tableModel.addRow(new Object[] {5, "eee", "9999-9999" });
		
	}

	public JTableEx01(String title) {
		init();
		setTitle(title);
		settingSize(w, h);
		
		setVisible(true);
	}
	private void settingSize(int w, int h) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrW = ( int ) tk.getScreenSize().getWidth();
		int scrH = ( int ) tk.getScreenSize().getHeight();
		int x = scrW / 2 - w / 2;
		int y = scrH / 2 - h / 2;
		this.setLocation(x, y);
	}
	public static void main(String[] args) {
		new JTableEx01("JTable연습");

	}

}
