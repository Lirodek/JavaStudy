package EQEx;

import java.util.ArrayList;
import java.util.Arrays;

public class PointEq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Point> pList = new ArrayList<Point>();
		pList.add(new Point(2,3));
		pList.add(new Point(4,5));
		pList.add(new Point(5,7));
		pList.add(new Point(6,7));
		pList.add(new Point(4,6));
		pList.add(new Point(1,2));
//		pList.set(2, new Point(100,200));
//		System.out.println(pList);
//		Point[] arr = new Point[pList.size()];
//		pList.toArray(arr);
//		System.out.println(Arrays.toString(arr));
//		indexOf() <= 같은 요소가 있다면 index 반환, 아니면 -1 반환
//		ArrayList에서 객체의 위치를 찾기 위해서는 equals를 재정의 해야함
//		다른 컬렉션에서도 검색이 기능하려면 HashCode도 재정의 해야함
		System.out.println(pList.indexOf(new Point(5,7)));
		System.out.println(pList.contains(new Point(5,7)));
	}

}
