package ch16ch08io_3.joson;

import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class TestJasonObj {
	public TestJasonObj() {
		start();
	}
	private void start() {
		InputStream is = this.getClass().getResourceAsStream("members.json");
		JSONTokener tk = new JSONTokener(is);
		JSONObject jObj = new JSONObject(tk);
		System.out.println(jObj);
		
	}
	public static void main(String[] args) {
		new TestJasonObj();
	}
}
