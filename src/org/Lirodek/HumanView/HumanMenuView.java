package org.Lirodek.HumanView;

import org.Lirodek.HumanController.R;

public class HumanMenuView extends HumanView {
	
	public void display() {
		System.out.println("::::: MENU :::::");
		System.out.println("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료");
		System.out.print("선택 : ");
		int choice;
		while(true) {
			try {
				choice = sci.nextInt();
				while(choice>6||choice<1) {
					System.out.println("범위를 넘었습니다.");
					System.out.print("다시 선택 : ");
					choice = sci.nextInt();
				}
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("숫자만 입력해주세요!");
				sc.next();
				continue;
			}
		}
		R.choice = choice;
	}
}
	
