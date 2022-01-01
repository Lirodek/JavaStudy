package ExExtra;

import java.util.Scanner;

class Histogram{
	Scanner sc = new Scanner(System.in);
	String txt="";
	int txtLast;
	int txtIndex;
	char[] car = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	int[] charidx = new int[car.length];
	int idx = 0;
	public void run() {
		System.out.println("영문 TxT를 입력하고 땀을 찍으세요.");
		while(true) {
			txt += sc.nextLine();
			txtLast = txt.length()-1;
			if(txt.charAt(txtLast)==';')
				break;
		}
		txtIndex = txt.length();
		hisGram();
		getHis();
	}
	private void getHis() {
		idx=0;
		for(char c : car) {
			System.out.printf("%s,%d ",car[idx],charidx[idx]);
			for(int i=0;i<charidx[idx];i++)
				System.out.print("-");
			System.out.println();
			idx++;
		}
	}
	public void hisGram(){
		txt = txt.toUpperCase();
		for(int i=0;i<car.length;i++) {
			LoofcharIndex();
		}
	}
	public void LoofcharIndex() {
		charidx[idx]=0;
		for(int i=0;i<txtIndex;i++) {
			if(car[idx]==txt.charAt(i)) {
				charidx[idx]= charidx[idx]+1;
			}
		}
		idx++;
	}
	
}
public class ExtraHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Histogram hs = new Histogram();
		hs.run();
	}

}
