package ch16ch08io_3.joson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestJaonObj2 {
	public static void main(String[] args) throws IOException {
		
		
		
		JSONObject jObj1 = new JSONObject();
		jObj1.put("no", "1");
		jObj1.put("name", "광민2");
		jObj1.put("email", "Lirodek@gamil.com");
		JSONObject jObj2 = new JSONObject();
		jObj2.put("no", "2");
		jObj2.put("name", "설레");
		jObj2.put("email", "loveYejin@gamil.com");
		JSONObject jObj3 = new JSONObject();
		jObj3.put("no", "3");
		jObj3.put("name", "성공한나");
		jObj3.put("email", "WinnerGwangmin@gamil.com");
		
		System.out.println(jObj1.toString(1));
		
		JSONArray jArr = new JSONArray();
		jArr.put(jObj1);
		jArr.put(jObj2);
		jArr.put(jObj3);
		System.out.println(jArr.toString(1));
		
		JSONObject rootObj = new JSONObject();
		rootObj.put("member", jArr);
		
		FileWriter writer = new FileWriter("members.json");
		writer.write(rootObj.toString(2));
		writer.close();
		
		
		
	}
}
