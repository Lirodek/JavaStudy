package Ex01;
abstract class OddDetector{
	protected int n;
	public OddDetector(int n) {
		this.n = n;
	}
	public abstract boolean isOdd();
}
public class B extends OddDetector{
	public B(int n) {
		super(n);
	}

	@Override
	public boolean isOdd() {
		if(n%2==1||n==1)return false;
		else return true;
	}
	public static void main(String[] args) {
		B b = new B(5);
		System.out.println(b.isOdd());
	}

}
