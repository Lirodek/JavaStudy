package AlternativeEx;

public class IPTV extends TV implements Computer{
	ComputerImpl comp = new ComputerImpl();
	public void powerOn() {
		// TODO Auto-generated method stub
		dataReceive();
		onTV();
	}
	@Override
	public void dataReceive() {
		// TODO Auto-generated method stub
		comp.dataReceive();
		
	}

}
