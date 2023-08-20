package PhoneBookFileIO;

import java.io.IOException;

public class pMain {
	public pMain() throws IOException, ClassNotFoundException {
		start();
	}

	private void start() throws IOException, ClassNotFoundException {
		PhoneBookManager p= new PhoneBookManager();
		p.start();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		new pMain();

	}

}
