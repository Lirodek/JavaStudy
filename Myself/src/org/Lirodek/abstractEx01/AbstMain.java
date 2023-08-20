package org.Lirodek.abstractEx01;

public class AbstMain {

	public static void main(String[] args) {
		PeronalNumberStorage storage = new PersonalNumberStorageImpl(100);
		storage.addPersonalInfo("오사장", "010-4444-5555");
		storage.addPersonalInfo("이사장", "010-7777-6666");
		
		System.out.println(storage.searchName("010-7777-666"));
		System.out.println(storage.searchName("010-4444-5555"));
		
		

	}

}
