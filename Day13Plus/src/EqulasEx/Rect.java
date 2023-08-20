package EqulasEx;

public class Rect {
	int width, height;
	public Rect(int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
	}
	public boolean equals(Object obj) {
		Rect p = (Rect)obj;
		if(width*height==p.width*p.height) {
			return true;
		}
		else {
			return false;
			
		}
	}
	
}
