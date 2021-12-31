package org.Lirodek.ch6Ex01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Day05Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String queryStr = "user=hong&msg=hello&job=killer";
		StringTokenizer st = new StringTokenizer(queryStr, "&");
		HashMap<String, String> messageMap = new HashMap<String, String>();
		while(st.hasMoreTokens()) {
			String tk = st.nextToken();
			String[] keyValue = tk.split("=");
//			System.out.println(Arrays.toString(keyValue));
			messageMap.put(keyValue[0], keyValue[1]);
		}
		System.out.println(messageMap.get("user"));
		System.out.println(messageMap.get("get"));
		System.out.println(messageMap.get("job"));
		Iterator<String> it = messageMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.printf("%s => %s",key,messageMap.get(key));
		}
	}

}
