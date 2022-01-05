package PhoneBookFileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class PhoneBookMenu {

	public static Scanner sc = new Scanner(System.in);

	public int Menu() {
		System.out.println("친구목록 관리");
		System.out.println("1.번호목록 추가 2.번호목록 삭제 3.전체보기 4.파일 읽어오기 5.종료");
		return getInteger("입력 : ");
	}

	public static int getInteger(String s) {
		System.out.print(s);
		int choice;
		try {
			choice = sc.nextInt();
			if (choice > 5 || choice < 1) {
				System.out.println("1~4사이의 숫자를 입력해주세요.");
				return getInteger(s);
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요 . ");
			sc.next();
			return getInteger(s);
		}
		return choice;
	}
}

interface MENU {
	final int ADD = 1, DEL = 2, VIEW = 3, GETFILE = 4,EXIT=5;
}

public class PhoneBookManager {
	private static PhoneInfo pInfo;
	private static PhoneBookMenu pMenu = new PhoneBookMenu();
	private static ArrayList<PhoneInfo> pList = new ArrayList<PhoneInfo>();
	Iterator<PhoneInfo> itr;
	private static int topCnt = 0;

	public void getFile() throws IOException, ClassNotFoundException {
		File file = new File("C:\\Users\\user\\OneDrive\\새 폴더\\PhoneIO.dat");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<PhoneInfo> readObject = (ArrayList<PhoneInfo>) ois.readObject();
		pList = readObject; 
		if (pList.size() == 0) {
			topCnt = 0;
		} else {
			topCnt = pList.size() - 1;
		}

	}

	{
		pList.add(new PhoneInfo(topCnt++, "광민", 23, "010", "나"));
	}

	public void start() throws IOException, ClassNotFoundException {
		while (true) {
			run();
		}
	}

	private void run() throws IOException, ClassNotFoundException {
		switch (pMenu.Menu()) {
		case MENU.ADD:
			phoneInsert();
			break;
		case MENU.DEL:
			phoneDelete();
			break;
		case MENU.VIEW:
			phoneView();
			break;
		case MENU.GETFILE:
			getFile();
			break;
		case MENU.EXIT:
			phoneSave();
			break;
		}
	}

	private void phoneSave() throws IOException {
		File file = new File("C:\\Users\\user\\OneDrive\\새 폴더\\PhoneIO.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		itr = pList.iterator();
		while (itr.hasNext()) {
			pInfo = itr.next();
			oos.writeObject(pInfo);
		}
		System.out.println("객체를 저장했습니다.");
		System.exit(0);

	}

	private void phoneView() {
		itr = pList.iterator();
		while (itr.hasNext()) {
			PhoneInfo viewPinfo = itr.next();
			System.out.println(viewPinfo);
		}

	}

	private void phoneDelete() {
		System.out.println("전화번호부의 삭제를 진행합니다.");
		String name = getString("삭제할 사람 : ");
		itr = pList.iterator();
		int i = 0;
		while (itr.hasNext()) {
			i++;
			if (name.equals(itr.next().name)) {
				System.out.println(pList.remove(i - 1) + "를 삭제했습니다.");
				return;
			}

		}
//		if(i!=100)
//			System.out.println(name+"을 찾지 못했습니다.");
	}

	private void phoneInsert() {
		System.out.println("전화번호 목록에 추가합니다.");
		String name = getString("이름 : ");
		int age = getInteger("나이 : ");
		String phone = getString("번호 : ");
		String relation = getString("나와의 관계 : ");
		pInfo = new PhoneInfo(topCnt++, name, age, phone, relation);
		pList.add(pInfo);

	}

	private int getInteger(String s) {
		System.out.print(s);
		int integer;
		try {
			integer = pMenu.sc.nextInt();
		} catch (Exception e) {
			System.out.println("나이를 입력해주세요.");
			return getInteger(s);
		}
		return integer;
	}

	private String getString(String s) {
		System.out.print(s);
		String getS;
		try {
			getS = pMenu.sc.next();
		} catch (Exception e) {
			System.out.println("이름을 입력해주세요.");
			pMenu.sc.nextLine();
			return getString(s);
		}
		return getS;

	}
}
