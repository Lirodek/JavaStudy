package org.Lirodek.HumanController;
import org.Lirodek.HumanView.HumanView;
//다른 패키지의 HumanView를 끌고온다

public class ViewContainer {
	public void Boundary() {
		System.out.println("=========================");
	}
	public void run(HumanView view) {//view부분을 끌어와서 실행시키는 함수
		 Boundary();
		 view.display();
		 Boundary();
	}
}
