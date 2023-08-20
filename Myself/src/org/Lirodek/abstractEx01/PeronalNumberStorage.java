package org.Lirodek.abstractEx01;

public abstract class PeronalNumberStorage {
	public abstract void addPersonalInfo(String name, String perNum);
	public abstract String searchName(String perNum);
}

class PersonalNumInfo{
	String name;
	String number;
	public PersonalNumInfo() {
		// TODO Auto-generated constructor stub
		this("","");
	}
	public PersonalNumInfo(String name, String number) {
		this.name = name;
		this.number = number;
	}
	String getName() {return name;}
	String getNumber() {return number;}
}
class PersonalNumberStorageImpl extends PeronalNumberStorage{
	PersonalNumInfo[] perArr;
	int numOfPerInfo;
	public PersonalNumberStorageImpl(int sz) {
		perArr = new PersonalNumInfo[sz];
		numOfPerInfo = 0;
	}
	public void addPersonalInfo(String name, String perNum) {
		perArr[numOfPerInfo] = new PersonalNumInfo(name, perNum);
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
