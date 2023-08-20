package org.LiroSelf.Main;

import static org.LiroSelf.Resource.R.*;

import org.LiroSelf.Frame.MainFrame;
import org.LiroSelf.Model.MakeDir;



public class LirodekMain {
	MainFrame run = new MainFrame(title, frameWidth, frameHeight);
	public LirodekMain() {
		run.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MakeDir();
		new LirodekMain();
	}

}
