package socketPack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ClientEx {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	Scanner sc = new Scanner(System.in);
	
	public ClientEx() {
		// 서버 소켓과 연결 -Socket 생성 즉시 서버와 연결됨
		try {
			
			socket = new Socket(InetAddress.getLocalHost(), 9999);
			System.out.println("클라 서버 연결됨");
			JOptionPane.showMessageDialog(new JButton("확인"),"서버와 연결되었습니다.");
			// 서버와 입/ 출력 스트림을 연결
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 서버에 userID 보내기
			bw.write("user01" + "\n");
			bw.flush(); // 버퍼로 비워주는 역할을 한다.
			// 서버에서 보낸 메시지 받기
			while( true ) {
				String line = sc.nextLine();
				bw.write(line + "\n");
				bw.flush();
				String serverMessage = br.readLine();
				System.out.println(serverMessage);
			}
			
			// 종료 대기
			
		} catch (UnknownHostException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ClientEx();
	}
}
