package BlockBinaryCopyEx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockBinaryCopy {
	public static void main(String[] args) {
		File src = new File("C:\\Temp\\일레이나.jpg");
		File dest = new File("C:\\Users\\Administrator\\OneDrive\\새 폴더\\일렝이99.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			byte[] buf = new byte[1024*20];
			while(true) {
				int n= fi.read(buf);
				fo.write(buf,0,n);
				if(n<buf.length) {
					break;
				}
				fi.close(); fo.close();
				System.out.println(src.getPath()+"를 \n"+dest.getPath()+"로 복사했습니다.");
			}
		} catch (IOException e) {
			System.out.println("파일 복사 오류");
			e.printStackTrace();
			
		}
	}
}
