package ch16ch08io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch08Ex01_IO_StreamEx02 {
	public static String getLine() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		
		System.out.print("주소 입력 : ");
		String adress = getLine();
		StringTokenizer cut = new StringTokenizer(adress," ");
		while(cut.hasMoreTokens()) {
			System.out.println(cut.nextToken()+"");
		}
		
	}

}
