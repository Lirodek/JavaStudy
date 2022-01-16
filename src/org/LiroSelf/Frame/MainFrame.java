
package org.LiroSelf.Frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.LiroSelf.Resource.R;
import org.LiroSelf.View.BtnTitle;
import org.LiroSelf.View.InfoTitle;
import org.LiroSelf.View.MakeTitle;
import org.LiroSelf.View.View;
import org.LiroSelf.View.ViewTitle;

public class MainFrame extends JFrame implements R{
	Container contentPane ;
	View viewTitle = new ViewTitle();
	View viewMake = new MakeTitle();
	View viewBtn = new BtnTitle();
	View viewInto = new InfoTitle();
	public MainFrame(String title, int w, int h) {
		contentPane = getContentPane();
		super.setTitle(title);
		super.setSize(w, h);
		setting(w, h);
		contentPane = getContentPane();
		display();
		
	}

	private void display() {
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.NORTH, viewTitle);
		contentPane.add(BorderLayout.WEST, viewMake);
		contentPane.add(BorderLayout.SOUTH, viewBtn);
		contentPane.add(BorderLayout.CENTER, viewInto);
		
	}
	private void setting(int w, int h) {
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrW = ( int ) tk.getScreenSize().getWidth();
		int scrH = ( int ) tk.getScreenSize().getHeight();
		int x = ( scrW/2 ) - ( w/2 );
		int y = ( scrH/2 ) - ( h/2 );
		this.setLocation(x, y);
		
	}

}
