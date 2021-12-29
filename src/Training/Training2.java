package Training;

import java.util.Scanner;

abstract class Converter{
	abstract protected double conver(double src);
	abstract protected String getSrcString();
	abstract protected String getDestString();
	protected double ratio;
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println(getSrcString()+"을"+getDestString()+"로 바꿉니다.");
		System.out.println(getSrcString()+"을 입력하세요 : ");
		double val =sc.nextDouble();
		double res = conver(val);
		System.out.println("변환 결과 : "+res+getDestString()+"입니다.");
		sc.close();
	}
}
class Won2Doloar extends Converter{
	private double won;
	Won2Doloar(double won){
		this.won=won;
	}
	protected double conver(double src) {
		return src/won;
	}

	@Override
	protected String getSrcString() {
		return "원";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "달러";
	}
}
class km2Mile extends Converter{
	private double km;
	km2Mile(double km){
		this.km = km;
	}
	@Override
	protected double conver(double src) {
		
		return src/km;
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "Km";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "mile";
	}
	
}
public class Training2 {

	public static void main(String[] args) {
		km2Mile toMile = new km2Mile(1.6);
		toMile.run();

	}

}
