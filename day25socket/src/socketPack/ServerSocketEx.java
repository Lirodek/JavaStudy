package socketPack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ServerSocketEx {
	ServerSocket listenr = null;
	
	
	public ServerSocketEx() {
		Socket socket = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		Scanner sc = new Scanner(System.in);
		try {
			// ServerSocket을 생성하고 클라 접속 대기
			listenr = new ServerSocket(9999);
			JOptionPane.showMessageDialog(new JButton("확인"), "서버 대기중");
			// 클라 접속 대기 - 접속이 되면 소켓을 반환한다.
			socket = listenr.accept(); //클라와 연결된 소켓
			JOptionPane.showMessageDialog(new JButton("확인"), "클라이언트와 접속이 되었습니다.");
			// 클라 ( 입/출 ) 스트림을 연결합니다.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 클라 userID를 읽어오기
			String userID = br.readLine();
			JOptionPane.showMessageDialog(new JButton("확인"), "서버에 "+userID+"님이 접속이 되었습니다.");
			// 칼라에 에코를 전달한다.
			while( true ) {
				// 반복해서 읽어들인다
				String line = br.readLine();
				System.out.println(">>> " + line);
				// 클라이언트로 다시 전송
				
				bw.write("Server>>>" + line+"\n");
				bw.flush();
				
			}
			// 종료 대기
		} catch (SocketException e) {
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//Socket Server
		new ServerSocketEx();
	}
}
