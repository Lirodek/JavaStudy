package org.Lirodek.abstractEx01;
interface PersonalNumberStorage{
	void addPersonalInfo(String name, String perNum);
	String searchName(String perNum);
}
class PersonalNumInfo1{
	String name;
	String number;
	PersonalNumInfo1(String name, String perNum){
		this.name = name;
		this.number = number;
	}
	String getName() {return name;}
	String getNumber() {return number;}
}
class PersonalNumberStorageImpl1 implements PersonalNumberStorage{
	PersonalNumInfo[] perArr;
	int numOfPerInfo;
	PersonalNumberStorageImpl1(int sz){
		perArr = new PersonalNumInfo[sz];
		numOfPerInfo = 0;
	}
	@Override
	public void addPersonalInfo(String name, String perNum) {
		perArr[numOfPerInfo] = new PersonalNumInfo(name,perNum);
		numOfPerInfo++;
	}

	@Override
	public String searchName(String perNum) {
		for(int i=0;i<numOfPerInfo;i++) {
			if(perNum.compareTo(perArr[i].getNumber())==0)
				return perArr[i].getName();
		}
		return null;
	}
	
}
public class interMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonalNumberStorage storage = new PersonalNumberStorageImpl1(1000);
		storage.addPersonalInfo("이국종", "123");
		storage.addPersonalInfo("장산범", "456");
		System.out.println(storage.searchName("123"));
		System.out.println(storage.searchName("904"));
	}

}
