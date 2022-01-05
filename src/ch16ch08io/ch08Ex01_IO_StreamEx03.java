package ch16ch08io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ch08Ex01_IO_StreamEx03 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\OneDrive\\data.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String s = null;
		while((s=br.readLine())!=null) {
			System.out.println(s);
		}
		fr.close();
		
	}
	public static void test05(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\user\\OneDrive\\data.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}
	public static void test04(String[] args) throws IOException {
		// File
		File file = new File("C:\\Users\\user\\OneDrive\\test_myfile.txt");
		if (file.exists()) {
			System.out.println(">>>> 있다!");
			if (file.isDirectory()) {
				String[] fileList = file.list();
				for (String fileName : fileList) {
					System.out.println(fileName);
				}
			} else {
				if (file.delete()) {
					System.out.println(">>>> 파일이 삭제 됨!");
				}
			}
		} else {
			System.out.println(">>>> 없다!");
			if (file.createNewFile()) {
				System.out.println("파일이 생성 되었습니다.");
			}
		}
	}

	public static void test03(String[] args) throws IOException {
		// 파일에서 데이터 읽어오기
		// InputStream is = System.in;
		File file = new File("C:\\Users\\user\\OneDrive\\data.txt");
		FileInputStream is = new FileInputStream(file);
		int data = 0;
		while ((data = is.read()) != -1) {
			System.out.write(data);
		}
		is.close();
		System.out.println("파일 읽기 완료!");
	}

	public static void test02(String[] args) throws IOException {
		// OutputStream os = System.out;
		FileOutputStream os = new FileOutputStream("C:\\Users\\user\\OneDrive\\data.txt");
		InputStream is = System.in;

		// int data = is.read(); // 아스키코드 a(97), A(65), 0(48), \n(13)
		// System.out.println(data);
		System.out.println("데이터를 입력 해 보세요. (끝내려면 Ctrl+z) :");
		int data = 0;
		while ((data = is.read()) != -1) { // EOF일때까지 (Ctrl + z)
			os.write(data);
		}
		os.close();
		System.out.println("입력 종료!");
	}

	public static void test01(String[] args) throws IOException {
		OutputStream os = System.out; // 업캐스팅
		byte[] by = new byte[255];

		System.out.print("문자 입력 << ");
		System.in.read(by);

		String s = new String(by).trim();
		os.write(s.getBytes());
	}

}
