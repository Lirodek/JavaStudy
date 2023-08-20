package txtCopyEx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TxtCopyEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("C:\\Users\\Administrator\\OneDrive\\배광민\\JAVA_2\\MiddleProject.json");
		File dest = new File("c:\\Temp\\system.txt");
		int c ;
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			while((c=fi.read())!=-1)
				fo.write((byte)c);
			fi.close(); fo.close();
			System.out.println(src.getPath()+"를"+dest.getPath()+"로 복사했어");
		} catch (IOException e) {
			System.out.println("파일 복사 오류");
			// TODO: handle exception
		}
	}

}
