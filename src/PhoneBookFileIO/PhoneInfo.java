package PhoneBookFileIO;

public class PhoneInfo {
	int spnum;
	String name;
	int age;
	String phone;
	String relation;
	public PhoneInfo(String string, String string2, String string3, String string4, String string5) {
		
	}
	public PhoneInfo(int spnum, String name, int age, String phone, String relation) {
		this.spnum = spnum;
		this.name = name;
		this.age= age;
		this.phone = phone;
		this.relation = relation;
	}
	@Override
	public String toString() {
		return "[" + spnum + "]  " + name + "\t" + age + "\t" + phone + "\t"
				+ relation ;
	}
	

}
