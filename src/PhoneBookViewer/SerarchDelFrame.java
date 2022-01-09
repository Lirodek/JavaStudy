package PhoneBookViewer;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


public class SerarchDelFrame extends JFrame {
	private static GraphicsConfiguration title;
	JTextField srchFiled = new JTextField(15);
	JButton srchBtn = new JButton("SEARCH");
	
	JTextField delFiled = new JTextField(15);
	JButton delBtn = new JButton("DEL");
	
	JTextArea textArea = new JTextArea(20, 25);
	public SerarchDelFrame(String string) {
		super(title);
		setBounds(100,200,330,450);
		setLayout(new BorderLayout());
		Border border = BorderFactory.createEtchedBorder();
		
		Border serchBorder = BorderFactory.createTitledBorder(border, "Search");
		JPanel srchPanel = new JPanel();
		srchPanel.setBorder(serchBorder);
		srchPanel.setLayout(new FlowLayout());
		srchPanel.add(srchFiled);
		srchPanel.add(srchBtn);
		
		Border delBorder = BorderFactory.createTitledBorder(border, "Delete");
		JPanel delPanel = new JPanel();
		srchPanel.setBorder(delBorder);
		srchPanel.setLayout(new FlowLayout());
		srchPanel.add(delFiled);
		srchPanel.add(delBtn);
		
		JScrollPane scrollTextArea = new JScrollPane(textArea);
		Border textBorder = BorderFactory.createTitledBorder(border, "Infomation Board");
		scrollTextArea.setBorder(textBorder);
		
		add(srchPanel,BorderLayout.NORTH);
		add(delPanel,BorderLayout.NORTH);
		add(scrollTextArea, BorderLayout.CENTER);
		
		srchBtn.addActionListener(new searchEventHandler(srchFiled, textArea));
		delBtn.addActionListener(new DeleteEventHandler(delFiled,textArea));
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
}
