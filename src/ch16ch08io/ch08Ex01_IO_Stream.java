package ch16ch08io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ch08Ex01_IO_Stream {
	public static String getLine(){
		InputStreamReader isr = new InputStreamReader(System.in);
		//키보드로 받는 아스키값을 문자로 감싸주고 그감싸준값을 버퍼드리더로 감싸준다.
		//파일에 있는걸 읽으려면 파일에 있는값을 new로 생성해서 받아준다. (inputstream으로)
		//스캐너는 기능은 많은데 오류가있다. 그래서 원형기술로 만들어주는게 좋다.
		//ex 자동차 썬루프 옵션추가하면 좋지만 잔고장이 났을때 비용이 많이든다.
		BufferedReader br = new BufferedReader(isr);		
		String name;
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static int getNum() {
		String s= getLine();
		StringBuffer s2  = new StringBuffer();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ch>'0'&&ch<'9')
				s2.append(ch);
		}
		return Integer.parseInt(s2.toString());
		
	}
	public static void main(String[] args) {
		System.out.print("주소 입력 : ");
		String adress = getLine();
		System.out.print("나이 입력 : ");
		int age = getNum();
		System.out.println("입력된 주소는 "+adress);
		System.out.println("입력된 나이는 "+age);
		
		

	}

}
