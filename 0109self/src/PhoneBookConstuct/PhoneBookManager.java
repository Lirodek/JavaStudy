package PhoneBookConstuct;


import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

import PhoneBookExcept.MenuChoiceException;

public class PhoneBookManager {
	private final File dataFile = new File("PhoneBook.dat");
	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();
	
	static PhoneBookManager inst = null;
	
	public static PhoneBookManager createManagerInst() {
		if(inst == null) inst = new PhoneBookManager();
		return inst;
	}
	private PhoneBookManager() {
		readFromFile();
	}
	private String getString(String s) {
		System.out.print(s);
		String reString = MenuViewer.sc.nextLine();
		return reString;
	}
	private int getInteger(String s) {
		System.out.print(s);
		int reInteger = MenuViewer.sci.nextInt();
		return reInteger;
	}
	private PhoneInfo readFriendInfo() {
		String name = getString("이름 : ");
		String phone = getString("번호 : ");
		
		return new PhoneInfo(name,phone);	
	}
	private PhoneInfo readUnivInfo() {
		String name = getString("이름 : ");
		String phone = getString("번호 : ");
		String major = getString("전공 : ");
		int year = getInteger("학년 : ");
		return new PhoneUnivInfo(name,phone,major,year);
	}
	private PhoneInfo readCompanyInfo() {
		String name = getString("이름 : ");
		String phone = getString("번호 : ");
		String company = getString("회사 : ");
		return new PhoneCompanyInfo(name,phone,company);
	}
	public void input() throws MenuChoiceException{
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반 2.대학 3.회사");
		int choice = getInteger("선택 : ");
		PhoneInfo info=null;
		if(choice<INPUT_SELECT.NORMAL||choice>INPUT_SELECT.COMPANY) throw new MenuChoiceException(choice);
		switch(choice) {
			case INPUT_SELECT.NORMAL:
				info = readFriendInfo();
				break;
			case INPUT_SELECT.UNIV:
				info = readUnivInfo();
				break;
			case INPUT_SELECT.COMPANY:
				info = readCompanyInfo();
				break;
		}
		boolean isAdded = infoStorage.add(info);
		if(isAdded==true)System.out.println("데이터 입력이 완료되었습니다.\n");
		else System.out.println("이미 저장된 데이터 입니다.\n");
	}
	public String searchData(String name) {
		PhoneInfo info= search(name);
		if(info == null) return null;
		else return info.toString();
	}
	public boolean deleteData(String name) {
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while(itr.hasNext()) {
			PhoneInfo curInfo =itr.next();
			if(name.compareTo(curInfo.name)==0) {
				itr.remove();
				return true;
			}
		}
		return false;
	}
	private PhoneInfo search(String name) {
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while(itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0) return curInfo;
		}
		return null;
	}
	public void storeToFile() {
		try {
			FileOutputStream file = new FileOutputStream(dataFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			Iterator<PhoneInfo> itr=  infoStorage.iterator();
			while(itr.hasNext()) {
				out.writeObject(itr.next());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public void readFromFile() {
		if(dataFile.exists()==false)return;
		try {
			FileInputStream file = new FileInputStream(dataFile);
			ObjectInputStream in = new ObjectInputStream(file);
			
			while(true) {
				PhoneInfo info = (PhoneInfo)in.readObject();
				if(info==null) {
					break;
				}infoStorage.add(info);
			}in.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
