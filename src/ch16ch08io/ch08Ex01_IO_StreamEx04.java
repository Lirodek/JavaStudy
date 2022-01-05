package ch16ch08io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

class FileTest{
	public static Scanner sc = new Scanner(System.in);
	public void ips() throws IOException {
		File file = new File("C:\\Users\\user\\OneDrive\\data2.txt");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("저장 할 문장을 입력하세요");
		
		String s = br.readLine();
		dos.writeUTF(s);
		dos.close();
		
	}
	public void inputStream() throws IOException {
		File file = new File("C:\\Users\\user\\OneDrive\\data2.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		String s=null;
		try {
			s = dis.readUTF();
			System.out.println(s);
		} catch(IOException e) {
			System.out.println("UTF읽기 오류 발생");
		} finally {
			dis.close();
		}
		
	}
	public void startWrite() throws IOException {
		File file = new File("C:\\Users\\user\\OneDrive\\data2.txt");
		InputStream is = System.in;
		FileWriter fw = new FileWriter(file);
		int i =0;
		//키보드로 데이터를 입력 받아서 fw 를 이용하여 데이터 txt를 파일에 기록해라
		System.out.println("데이터 입력 cnt+z시 종료");
		while(true) {
			String str = sc.next();
			if(str.equals("그만")) break;
			fw.write(str+"\n");
		}
		System.out.println("데이터 입력을 종료합니다.");
		fw.close();
	}
	public void ticherRead() throws IOException {
		File file = new File("C:\\Users\\user\\OneDrive\\data.txt");
		FileReader fr = new FileReader(file);
		char[] cbuf = new char[255];
		fr.read(cbuf);
		System.out.println(new String(cbuf).trim());
		fr.close();
	}
	public void ticherWrite() throws IOException {
		File file = new File("C:\\Users\\user\\OneDrive\\data2.txt");
		FileWriter fw = new FileWriter(file);
		String s = sc.nextLine();
		fw.write(s);
		fw.close();
	}
}
public class ch08Ex01_IO_StreamEx04 {
	public static void main(String[] args) throws IOException {
		FileTest ft = new FileTest();
		ft.ips();
		ft.inputStream();
	}
}
