package D17Ex02;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Ex02 {
	public  Scanner sc=null ;
	public static FileOutputStream fout =null;
	public static FileWriter fw = null;
	public static FileReader fin = null;
	public static BufferedWriter bw = null;
	BufferedOutputStream bout=null; 
	StringBuffer sb = null;
	public static File file = new File("c:\\temp\\test2.txt");
	public static File file2 = new File("C:\\Users\\Administrator");
	
	public Ex02() {
		start();
	}

	private void start() {
//		FileWriteEx();//파일 쓰는거 
//		FileReaderEx();// 파일 읽는거
//		Fosbynary(); //바이너리데이터 작성
//		FinS(); //파일 인풋 바이너리 데이터
//		bos();//BufferdOutputStream
//		BufferedIO();
		FileExEx(file2);
		System.out.println(file2.getPath()+", "+file2.getParent()+", "+
		file2.getName());
		String res ="";
		if(file2.isFile()) res = "파일";// 파일
		else if(file2.isDirectory()) res = "디렉토리"; //디렉토리
		System.out.println(file2.getPath()+"은 "+res+"입니다.");// 파일의 형태는?
		
		
		
	}
	private void FileExEx(File dir) {
		System.out.println("-----" +dir.getPath()+"의 서브 리스트입니다.-----");
		File[] subFiles = dir.listFiles();
		for(int i=0;i<subFiles.length;i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t파일 크기 : "+f.length());
			System.out.printf("\t수정한 시간 : %td %td %ta %tT\n",t,t,t
					);
			
		}
		
	}

	private void BufferedIO() {
		try {
			fin = new FileReader(file);
			int c;
			bout = new BufferedOutputStream(System.out, 5);
			while((c=fin.read())!=-1)
				bout.write(c);
			new Scanner(System.in).nextLine();
			bout.flush();
			fin.close();
			bout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void bos() {
		System.out.println("\nbos출력----");
		bout = new BufferedOutputStream(System.out, 20);
		try {
			fin = new FileReader("c:\\windows\\system.ini");
			int c;
			while((c=fin.read())!=-1) {
				bout.write((char)c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void FinS() {
		byte b[]= new byte[6];
		try {
			FileInputStream fin = new FileInputStream("c:\\temp\\test.out");
			int n = 0,c;
			while((c=fin.read())!=-1) {
				b[n] = (byte)c;
				n++;
			}
			System.out.println("c:\\temp\\test.out에서 읽은 배열을 출력합니다.");
			for(int i=0;i<b.length;i++) {
				System.out.print(b[i]+" ");
			}
			fin.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	private void Fosbynary() {
		byte b[] = {45 , 51, 3, 4, -1, 24};
		try {
			fout = new FileOutputStream("c:\\temp\\test.out");
			for(int i=0; i<b.length;i++) {
				fout.write(b[i]);
			}
			fout.close();
		} catch (FileNotFoundException e) {
			System.out.println("경로 ㅇㄷ?");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("혹시 다른 Exception?");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void FileWriteEx() {
		sc = new Scanner(System.in);
		int c;
		try {
			fw = new FileWriter(file);
			while(true) {
				String line = sc.nextLine();
				if(line.length()==0)
					break;
				fw.write(line, 0,line.length());
				fw.write("\r\n", 0, 2);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
		
	}

	private void WriteStream() {
		sc = new Scanner(System.in);
		try {
			fw = new FileWriter(file);
			sb = new StringBuffer();
			bw = new BufferedWriter(fw);
			System.out.println("입력하고싶은 문자열 ㄱㄱ");
			while(true) {
				String line = sc.nextLine();
				if(line.trim().equals("")) break;
				sb.append(line);
				
			}
			bw.write(sb.toString());
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		
		
	}

	private void FileReaderEx(){
		System.out.println("\nFileReadeEx");
		try {
			//이거 작동안하네
			FileInputStream fin = new FileInputStream("c:\\temp\\test.out");
			InputStreamReader in = new InputStreamReader(fin,"UTF8");
			int c;
			while((c=in.read())!=-1) {
				System.out.print((char)c);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void FileREaderEx() {
		System.out.println("FileREaderEx");
		try {
			fin = new FileReader(file);
			BufferedReader br = new BufferedReader(fin);
			System.out.println(br.readLine());
			int c;
			while((c=fin.read())!=-1) {
				System.out.print((char)c);
			}
			fin.close();
			br.close();
		} catch (IOException e) {
			System.out.println("입출력 오류 ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Ex02();
	}

}
