package Ex08Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main08 {
	public static Scanner sc = new Scanner(System.in);
	HashMap<String, Integer> pMap = new HashMap<String, Integer>();
	
	public Main08() {
		start();
	}
	private void start() {
		
		System.out.println("** 포인트 관리 프로그램입니다. **");
		while(true) {
			System.out.print("이름과 포인트 입력 >> ");
			String name = sc.next();
			int point = sc.nextInt();
			if(name.equals("그만")) break;
			if(pMap.containsKey(name)) {
				point += pMap.get(name);
			}
			pMap.put(name, point);
			Set<String> keys = pMap.keySet();
			Iterator<String> itr = keys.iterator();
			while(itr.hasNext()) {
				String keyN = itr.next();
				System.out.print("("+keyN+","+pMap.get(keyN)+")   ");
			}
			System.out.println();
			
			
		}
		
	}
	public static void main(String[] args) {
		new Main08();
	}
}
