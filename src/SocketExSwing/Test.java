package SocketExSwing;

import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		String message = "Asdasdasd asdasd asdasd";
		StringTokenizer st = new StringTokenizer(message, " ");
		if(st.nextToken().equals("Asdasdasd"))
			System.out.println("맞아");
		
	}
}
