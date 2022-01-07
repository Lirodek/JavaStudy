package MiddlePro;

import java.io.File;
import java.io.IOException;

public class MakeDirectory {
	public MakeDirectory() {
		MakeDir();
	}
	public void MakeDir() {
		File file = new File(Menu.FILE);
		File Folder = new File(Menu.FOLDER);
		if(!Folder.exists()) {
			try {
				Folder.mkdir();
				System.out.println("폴더를 생성합니다.");
			} catch(Exception e) {
				e.getStackTrace();
			}
		} else {
			System.out.println();
		}
		try {
			if(file.createNewFile()) {
				System.out.println("파일을 새로 만듭니다.");
			} else {
				System.out.println();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
