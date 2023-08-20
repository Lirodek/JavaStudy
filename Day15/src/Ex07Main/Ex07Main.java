package Ex07Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex07Main {
	public static Scanner sc  = new Scanner(System.in);
	HashMap<String, Double> scholarship = new HashMap<String, Double>();
	{
		scholarship.put("적당히", 3.1);
		scholarship.put("나탈락", 2.4);
		scholarship.put("개잘해", 4.3);
		scholarship.put("상당히", 3.9);
		scholarship.put("올", 4.0);
	}
	public Ex07Main() {
		start();
	}

	private void start() {
		
		System.out.println(scholarship);
		System.out.print("장학생 선발 학점 입력 >> ");
		double specialScore = sc.nextDouble();
		
		Set<String> keys = scholarship.keySet();
		Iterator<String> itr = keys.iterator();
		
		while(itr.hasNext()) {
			String name = itr.next();
			double next2 = scholarship.get(name);
			if(next2>specialScore)
				System.out.println(name+"   ");
		
					
		}

		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex07Main();
	}

}
