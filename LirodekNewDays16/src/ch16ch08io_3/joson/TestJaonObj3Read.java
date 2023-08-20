package ch16ch08io_3.joson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class TestJaonObj3Read {
	public TestJaonObj3Read() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		start();
	}

	private void start() throws FileNotFoundException {
		InputStream is = this.getClass().getResourceAsStream("members.json");
//		FileInputStream is = new FileInputStream("members.json");
		JSONTokener tk = new JSONTokener(is);
		JSONObject jObj = new JSONObject(tk);
		System.out.println(jObj.toString(2));
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		new TestJaonObj3Read();

	}

}
