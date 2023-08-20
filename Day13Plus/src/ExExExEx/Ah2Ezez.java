package ExExExEx;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ah2Ezez {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		StringTokenizer st = new StringTokenizer("a/3/b/5/c/6/","/");	
		String s;
		while(st.hasMoreTokens()) {
			s = st.nextToken();
			try{
				sum += Integer.parseInt(s);
				System.out.println(s);
				
				
			}catch(NumberFormatException e) {
				System.out.println(s);
			}
			
			
		}
		System.out.printf("합은%d",sum);

		
	}
}
