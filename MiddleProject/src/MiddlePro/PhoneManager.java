package MiddlePro;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.json.JSONTokener;

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
	MakeDirectory Directory;
	
	private PhoneInfo pInfo = new PhoneInfo();
	public boolean allDalete() {
		boolean b = checkAll("정말로 삭제하시겠습니까?(Y\\N)");
		if(b==true) {
			pMap.clear();
			File file = new File(Menu.FILE);
			if(file.exists()) {
				file.delete();
				System.out.println("파일을 삭제했습니다.");
			} else {
				System.out.println("파일이 존재하지 않습니다.");
			}
			return true;
		} else {
			return false;
		}
	}
	private boolean checkAll(String s) {
		sc = new Scanner(System.in);
		System.out.println(s);
		char answer;
		try {
			answer = sc.next().toUpperCase().charAt(0);
			if (answer != Menu.YES && answer != Menu.NO) {
				System.out.println(Menu.REPLZ);
				return checkAll(s);
			}
		} catch (Exception e) {
			System.out.println("캐치오류");
			sc.next();
			return checkAll(s);
		}
		switch (answer) {
		case Menu.YES:
			return true;
		case Menu.NO:
			return false;
		}
		return false;

	}
	public void bringFile() {
		
		File file = new File(Menu.FILE);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);

			JSONTokener jtk = new JSONTokener(bis);
			JSONObject fileObj = new JSONObject(jtk);
			JSONArray jArray = new JSONArray();
			jArray = fileObj.getJSONArray("members");
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject tempJobj = new JSONObject();
				tempJobj = (JSONObject) jArray.get(i);
				String name = tempJobj.getString("이름");
				String phone = tempJobj.getString("번호");
				int age = (int) tempJobj.get("나이");
				String relation = tempJobj.getString("관계");
				System.out.print(name+"  ");
				pInfo = new PhoneInfo(name, phone, age, relation);
				pMap.put(pInfo.getName(), pInfo);
				
			}
			System.out.println("의\n데이터를 성공적으로 불러왓습니다.");

		} catch (FileNotFoundException e) {
			System.out.println("저장소가 존재하지않습니다.");
			Directory = new MakeDirectory();
		} catch (JSONException e) {
			System.out.println("저장된 데이터가 없습니다.");
		}
	}

	public void SaveFile() {
		pList = new ArrayList<PhoneInfo>();
		try {
			FileWriter file = new FileWriter(Menu.FILE);
			JSONArray jArray = new JSONArray();
			itr = pMap.values().iterator();
			while (itr.hasNext()) {
				pInfo = itr.next();
				JSONObject pObject = new JSONObject();
				pObject.put("이름", pInfo.getName());
				pObject.put("번호", pInfo.getPhone());
				pObject.put("나이", pInfo.getAge());
				pObject.put("관계", pInfo.getRelation());
				jArray.put(pObject);

			}
			JSONObject root = new JSONObject();
			root.put("members", jArray);
			FileWriter writer = new FileWriter(Menu.FILE);
			writer.write(root.toString());
			writer.close();
			file.close();

		} catch (JSONException e) {
			System.out.println("저장할 데이터가 존재하지 않습니다.");
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
			boolean check = checkup(p, "해당 데이터를 정말로 수정하시겠습니까?(Y\\N)");
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
				return checkup(p, s);
			}
		} catch (Exception e) {
			sc.next();
			return checkup(p, s);
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
