package socketPackEx02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ServerSurvice {
	
	ServerSocket listner = null;
	Scanner sc = new Scanner(System.in);
	public ServerSurvice() {
		
		Socket socket = null;
		
		BufferedReader br = null; // 클라의 데이터를 읽어옵니다.
		BufferedWriter bw = null; // 클라의 데이터를 넘깁니다.
		try {
			listner = new ServerSocket(9999);
			System.out.println("서버 대기중 . . .");
			
			socket = listner.accept();
			System.out.println("클라이언트와 연결되었습니다!");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String userID = br.readLine();
			System.out.println(userID+">>님이 입장했습니다.");
			
			
			
			while( true ) {
				String line = br.readLine();
				System.out.println(userID+">> "+line);
				System.out.print("입력 : ");
				String sLine = "Server<<"+sc.nextLine();
				bw.write(sLine+"\n");
				bw.flush();	
			}
			
		} catch (SocketException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new ServerSurvice();
	}

}
