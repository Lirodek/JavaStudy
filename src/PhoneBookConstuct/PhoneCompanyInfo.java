package PhoneBookConstuct;

public class PhoneCompanyInfo extends PhoneInfo {
	String company;
	PhoneCompanyInfo(){
		this("","","");
	}
	public PhoneCompanyInfo(String name, String phone, String company) {
		super(name,phone);
		this.company = company;
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("company : "+company);
	}
	@Override
	public String toString() {
		return "company : " + company + "\n";
	}
}
