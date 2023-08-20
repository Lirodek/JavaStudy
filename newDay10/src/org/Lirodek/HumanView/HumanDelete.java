package org.Lirodek.HumanView;

public class HumanDelete extends HumanView {
	@Override
	public void display() {
		System.out.println("::::: 사람 정보 삭제 :::::");
		String name = setString("이름 : ");
	}
	public String setString(String s) {
		System.out.print(s);
		String name=sc.next();
		return name;
	}
}
