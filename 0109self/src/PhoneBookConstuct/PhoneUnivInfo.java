package PhoneBookConstuct;

public class PhoneUnivInfo extends PhoneInfo{
	String major;
	int year;
	PhoneUnivInfo(){this("","","",0);}
	public PhoneUnivInfo(String name, String phone, String major, int year) {
		super(name,phone);
		this.major = major;
		this.year = year;
	}
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("major : "+major);
		System.out.println("year : "+year );
	}
	@Override
	public String toString() {
		return "major : " + major + "\nyear :" + year + "\n";
	}
	
}
