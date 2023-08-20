package AlternativeEx;

public class MultiIngeriAlternative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPTV iptv = new IPTV();
		iptv.powerOn();
		TV tv = iptv;
		Computer comp = iptv;
		iptv.dataReceive();
	}

}
