package org.NewDay09.Project;
import static java.lang.System.out;
class GrandFather{
	public void nafal() {
		out.println("GrandFather's Nafal ! Fra~");
	}
}
class Father extends GrandFather{
	@Override
	public void nafal() {
		out.println("Father's Nafal !Frata!");
	}
}
class Me extends Father{
	@Override
	public void nafal() {
		out.println("me's Nafal !Firiri~");
	}
}
public class Overroad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrandFather[] family =  new GrandFather[5];
		family[0] = new GrandFather();
		family[1] = new Father();
		family[2] = new Me();
		family[3] = new Father();
		family[4] = new GrandFather();
		
		for(GrandFather h : family) {
			h.nafal();
		}
	}

}
