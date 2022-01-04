package org.review.Ex06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;
class Location{
	String name;
	String latitude;
	String hardness;
	public Location() {
		this("","","");
	}
	public Location(String name, String latitude, String hardness) {
		this.name = name;
		this.latitude = latitude;
		this.hardness = hardness;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return  name + "  " + latitude + "  " + hardness ;
	}
}
public class Ex06Main {
	HashMap<String,Location> locMap = new HashMap<String,Location>();
	private static Scanner sc ;
	public Ex06Main() {
		start();
		
	}
	private void start() {
		final int ZERO=0,MAX=4;
		sc = new Scanner(System.in);
		System.out.println("도시, 경도, 위도를 입력하세요.");
		for(int i=ZERO;i<MAX;i++) {
			System.out.print(">> ");
			String location =sc.nextLine();
			StringTokenizer st = new StringTokenizer(location,",");
			String name =st.nextToken().trim();
			String latitude =st.nextToken().trim();
			String hardness =st.nextToken().trim();
			locMap.put(name, new Location(name,latitude,hardness));
		}
		Iterator<Location> itr = locMap.values().iterator();
		String line = "-----------------";
		System.out.println(line);
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println(line);
		while(true) {
			System.out.print("도시 이름 >>");
			String name = sc.next();
			if(name.equals("그만")) break;
			if(locMap.get(name)==null) {
				System.out.println(name+"도시는 존재하지 않습니다.");
			} else {
				System.out.println(locMap.get(name)); 
			}
				
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex06Main();
	}

}
