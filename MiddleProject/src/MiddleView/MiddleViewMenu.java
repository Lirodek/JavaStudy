package MiddleView;

import MiddleController.R;

public class MiddleViewMenu extends MiddleView{
	@Override
	public void display() {
		getLine("전화번호부");
		System.out.println("(1)목록 (2)추가 (3)검색 (4)수정\n(5)삭제 (6)전체삭제 (7)종료");
		int choice =0;
		while(choice>7||choice<1) {
			choice = setInteger("입력 : ");
		}
		R.choice = choice;
		
	}
	public MiddleViewMenu() {
		display();
	}
	public static void main(String[] args) {
		new MiddleViewMenu();
	}
}
