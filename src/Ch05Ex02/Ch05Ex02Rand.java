package Ch05Ex02;

import java.util.HashSet;
import java.util.Random;
import java.util.random.*;

public class Ch05Ex02Rand {
	//자주 사용하는 컬렉션
	//set map list
	//set key 도없고 인덱스도 없다 순서가 없고 중복된 데이터 저장 x
	//map = 요소를 key와 value를 쌍으로 가진다
	//list = index가 있다.
	
	
	public static void main(String[] args) {
		Random rand = new Random();
		HashSet<Integer> a = new HashSet<Integer>();

		
		System.out.println("size => "+a.size());
		while(a.size()<6) {
			a.add(1+rand.nextInt(45));
		}
		System.out.println(a);
		
	}

}
