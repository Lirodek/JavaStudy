package socketPackEx02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientService {
	
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	Scanner sc = new Scanner(System.in);
	
	public ClientService() {
		try {
			
			socket = new Socket(InetAddress.getLocalHost(), 9999);
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			System.out.print("유저아이디 : ");
			String userID = sc.nextLine();
			bw.write(userID+"\n");
			bw.flush();
			
			while(true) {
				System.out.print("입력 >> ");				
				String line = sc.nextLine();
				bw.write(line+"\n");
				bw.flush();
				System.out.println(br.readLine());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ClientService();

	}
	// 메세지를 받는 쓰래드 선언
	
}
