package org.LirodekEx05;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class R {
	public static final HumanDao dao = new HumanDao();
	public static int SIZE=7;
	
	public static JTable table;
	public static DefaultTableModel tbModel;
	public static JScrollPane scrollPane;
	public static HumanDto rDto;
	public static String Rname;
	
	public static Vector data;
	public static Vector<String> columnNames;

	public static final JTextField txtFld1 = new JTextField(SIZE);
	public static final JTextField txtFld2 = new JTextField(SIZE);
	public static final JTextField txtFld3 = new JTextField(SIZE);
	public static final JTextField txtFld4 = new JTextField(SIZE);

	public static final JButton allBtn = new JButton("All");
	public static final JButton inputBtn = new JButton("Input");
	public static final JButton searchBtn = new JButton("Search");
	public static final JButton modifyBtn = new JButton("Modify");
	public static final JButton deleteBtn = new JButton("Delete");
	public static final JButton finishBtn = new JButton("Finish");

}
