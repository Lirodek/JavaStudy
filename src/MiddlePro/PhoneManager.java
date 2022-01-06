package MiddlePro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class pMana {

	abstract public PhoneInfo insert(PhoneInfo p);

	abstract public PhoneInfo delete(PhoneInfo p);

	abstract public PhoneInfo upDate(PhoneInfo p);
}

public class PhoneManager extends pMana {
	public static Scanner sc;
	private static HashMap<String, PhoneInfo> pMap = new HashMap<String, PhoneInfo>();
	private Iterator<PhoneInfo> itr;
	private Iterator<String> itrkeys;
	private ArrayList<PhoneInfo> pList;
	private static final String dir = "C:\\Users\\Administrator\\OneDrive\\배광민\\JAVA_2\\phone.json";
	private PhoneInfo pInfo = new PhoneInfo();
	{
		pMap.put("배광민", new PhoneInfo("배광민", "010-0000-0000", 24, "본인"));
		pMap.put("배강민", new PhoneInfo("배강민", "010-1111-1111", 22, "동생"));
		pMap.put("수선화", new PhoneInfo("수선화", "010-0000-0000", 2, "꽃"));

	}

	public void SaveFile() {
		pList = new ArrayList<PhoneInfo>();
		try {
			FileWriter file = new FileWriter(dir);
			JSONArray jArray = new JSONArray();
			itr = pMap.values().iterator();
			while (itr.hasNext()) {
				pInfo = itr.next();
				System.out.println(pInfo);
				JSONObject pObject = new JSONObject();
				pObject.put("이름", pInfo.getName());
				pObject.put("번호", pInfo.getPhone());
				pObject.put("나이", pInfo.getAge());
				pObject.put("관계", pInfo.getRelation());
				jArray.put(pObject);
				
			}
			JSONObject root = new JSONObject();
			root.put(dir, jArray);
			FileWriter writer = new FileWriter(dir);
			writer.write(root.toString());
			writer.close();
			System.out.println("데이터 저장을 완료했습니다.");
			System.exit(0);
			 
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<PhoneInfo> AllSearch() {
		pList = new ArrayList<PhoneInfo>();
		itr = pMap.values().iterator();
		while (itr.hasNext()) {
			pInfo = itr.next();
			pList.add(pInfo);
		}
		if (pList.size() <= 0) {
			return null;
		} else {
			return pList;
		}

	}

	public PhoneInfo search(PhoneInfo p) {
		if (pMap.containsKey(p.getName())) {
			pInfo = pMap.get(p.getName());
			return pInfo;
		}
		return new PhoneInfo(Menu.FAIL, null, 0, null);
	}

	@Override
	public PhoneInfo insert(PhoneInfo p) {
		itr = pMap.values().iterator();

		while (itr.hasNext()) {

			if (p.getName().equals(itr.next().getName())) {
				System.out.println(p.getName() + " 이름이 존재합니다. 동명 이인인가요?");
				boolean check = checkName(p);
				if (check == false) {
					return new PhoneInfo(Menu.CACEL, null, 0, null);
				} else {
					return p;
				}
			}

		}
		pMap.put(p.getName(), p);
		return p;

	}

	private boolean checkName(PhoneInfo p) {
		System.out.print("동명 이인을 입력합니다 (Y/N)>>");
		sc = new Scanner(System.in);
		char answer;
		try {
			answer = sc.next().toUpperCase().charAt(0);
			if (answer != Menu.YES && answer != Menu.NO) {
				System.out.println(Menu.REPLZ);
				return checkName(p);
			}
		} catch (Exception e) {
			sc.nextLine();
			return checkName(p);
		}
		switch (answer) {
		case Menu.YES:
			p.setName(p.getName() + "A");
			pMap.put(p.getName(), p);
			return true;
		case Menu.NO:
			return false;
		}
		return false;

	}

	@Override
	public PhoneInfo delete(PhoneInfo p) {
		Set<String> keys = pMap.keySet();
		itrkeys = keys.iterator();
		while (itrkeys.hasNext()) {
			if (itrkeys.next().equals(p.getName())) {
				boolean check = checkDel(p, "정말로 삭제하시겠습니까?(Y/N)");
				if (check == true) {
					return p;
				} else {
					return new PhoneInfo(Menu.CACEL, null, 0, null);
				}

			}
		}
		System.out.println("\n못찾았어");
		return null;
	}

	private boolean checkDel(PhoneInfo p, String s) {
		sc = new Scanner(System.in);
		System.out.println(s);
		char answer;
		try {
			answer = sc.next().toUpperCase().charAt(0);
			if (answer != Menu.YES && answer != Menu.NO) {
				System.out.println(Menu.REPLZ);
				return checkDel(p, s);
			}
		} catch (Exception e) {
			sc.next();
			return checkDel(p, s);
		}
		switch (answer) {
		case Menu.YES:
			pMap.remove(p.getName());
			return true;
		case Menu.NO:
			return false;
		}
		return false;

	}

	@Override
	public PhoneInfo upDate(PhoneInfo p) {
		pInfo = search(p);
		if (pInfo == null) {
			return null;
		} else {
			System.out.println(pInfo.toString(1));
			System.out.println(p.toString(1));
			boolean check = checkup(p, "해당 데이터를 정말로 수정하시겠습니까?");
			if (check == true) {
				pMap.put(p.getName(), p);
				return p;
			} else
				return new PhoneInfo(Menu.CACEL, null, 0, null);
		}
	}

	private boolean checkup(PhoneInfo p, String s) {
		sc = new Scanner(System.in);
		System.out.println(s);
		char answer;
		try {
			answer = sc.next().toUpperCase().charAt(0);
			if (answer != Menu.YES && answer != Menu.NO) {
				System.out.println(Menu.REPLZ);
				return checkDel(p, s);
			}
		} catch (Exception e) {
			sc.next();
			return checkDel(p, s);
		}
		switch (answer) {
		case Menu.YES:
			return true;
		case Menu.NO:
			return false;
		}
		return false;

	}

}
