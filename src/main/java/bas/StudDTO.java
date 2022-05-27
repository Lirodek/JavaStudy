package bas;

import java.util.Arrays;

public class StudDTO {

	String name;
	
	int [] jum;

	int tot, avg;
	public StudDTO(String name, String... jum) {
		
		this.name = name;
		this.jum = new int[jum.length];
		for (int i = 0; i < jum.length; i++) {
			this.jum[i] = 0;
			
			if(jum[i]!=null && !jum[i].trim().equals("")) {
				this.jum[i] = Integer.parseInt(jum[i]);
			}
		}
		
		calc();
	}
	
	void calc() {
		tot = 0;
		for (int i : jum) {
			tot += i;
		}
		avg = tot/ jum.length;
	}
	
	@Override
	public String toString() {
		return "StudDTO [name=" + name + ", jum=" + Arrays.toString(jum) + ", tot=" + tot + ", avg=" + avg + "]";
	}
	

	public String getDiv() {
		String res = "<div class='st'><div>"+name+"</div>";
		
		for (int i : jum) {
			res += "<div>"+i+"</div>";
		}
		res += "<div>"+tot+"</div><div>"+avg+"</div></div>";
		return res;
	}
	
	
}
