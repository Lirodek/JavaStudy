package org.LiroSelf.Model;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
interface ConstDir{
	public final String FILE = "C://광민이2//Data.json";
	public final String FOLDER = "C://광민이2";
}
public class MakeDir {
	public MakeDir() {
		File file = new File(ConstDir.FILE);
		File folder = new File(ConstDir.FOLDER);
		if(!folder.exists()) {
			try {
				folder.mkdir();
				System.out.println(folder.getName()+"을 생성합니다.");
			} catch(Exception e) {
				e.getStackTrace();
			}
		} else {}
		try {
			if(file.createNewFile()){
				System.out.println(file.getName()+"을 생성합니다.");
			}
			else {}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
