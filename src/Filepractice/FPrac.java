package Filepractice;

import java.io.File;

public class FPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C\\Windows\\일레이나.ini");
		System.out.println(file.isFile()); // 파일이 있는지 없는지 리턴
		System.out.println(file.getParent()); 
		//속해있는 상위폴더 리턴
		//isFile이 false여도 작동
		System.out.println(file.getPath());
		//file의 풀네임을 리턴 String type
		System.out.println(file.getName());  
	}

}
