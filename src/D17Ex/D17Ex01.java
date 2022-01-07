package D17Ex;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class D17Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("c:\\temp\\phone.txt");
		FileReader fin = null;
		try {
			fin = new FileReader(file);
			int c;
			
			while((c = fin.read())!=-1) {
				System.out.println((char)c);
				//자바에서는char이 정수형도 돼서 가능하다.
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없어");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fin !=null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
