package day15.ch07.ex06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX=4, ZERO=0;
	private HashMap<String, Location> locMap = new HashMap<String, Location>();
	private Scanner sc = new Scanner(System.in);
	{
		locMap.put("서울", new Location("서울",37,126));
		locMap.put("갈비", new Location("갈비",34,-118));
		locMap.put("모기", new Location("모기",2,48));
		locMap.put("시들어", new Location("시들어",151,-33));
	}
	public Main() {
		play();
	}

	private void play() {
		list();
		while(true) {
			Location loc = search();
			if(loc!=null&&loc.getCity().equals("그만")) break;
			System.out.println(loc==null?"도시가 없습니다.":loc);
		}
		System.out.println("프로그램을 종료합니다.");
	}
	private void list() {
		Set<String> keys = locMap.keySet();
		Iterator<String> it = keys.iterator();
		Iterator<Location> itr = locMap.values().iterator();
		System.out.println("---------------");
		while(it.hasNext()) {
			String city = it.next();
			System.out.println(locMap.get(city));
		}
		System.out.println("---------------");
		
		System.out.println("---------------");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("---------------");
		
	}

	private Location search() {
		System.out.print("도시 이름 >> ");
		String city = sc.next();
		if(city.equals("그만")) {
			return new Location("그만",0,0);
		}
		if(locMap.get(city)==null) {
			return null;
		} else {
			return locMap.get(city);
		}
		
	}
	private void input() {
		System.out.println("4개의 도시, 위도, 경도를 입력하세요.");
		for(int i=ZERO;i<MAX;i++) {
			System.out.print(">> ");
			String value = sc.nextLine();
			StringTokenizer st = new StringTokenizer(value,", ");
			String city = st.nextToken();
			int latitude = Integer.parseInt(st.nextToken());
			int hardness = Integer.parseInt(st.nextToken());
			Location loc = new Location(city, latitude, hardness);
			locMap.put(city, loc);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
