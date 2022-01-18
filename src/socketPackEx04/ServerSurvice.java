package socketPackEx04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class ServerSurvice extends Thread {
	class User{
		Socket socket;
		BufferedReader br;
		PrintWriter pw;
		public User(Socket socket, BufferedReader br, PrintWriter pw) {
			this.socket =socket;
			this.br =br;
			this.pw = pw;
		}
	}
   // 글을 읽어와서 보내주는거
   HashMap<String, Socket> userMap = new HashMap<String, Socket>();
   ServerSocket listner = null;
   Scanner sc = new Scanner(System.in);
   String userID = "";
   Socket socket = null;
   BufferedReader br = null; // 클라의 데이터를 읽어옵니다.
   BufferedWriter bw = null; // 클라의 데이터를 넘깁니다.
   PrintWriter pw = null;

   public ServerSurvice() {
      try {
         listner = new ServerSocket(9999);
         System.out.println("서버 대기중 . . .");
         // 쓰레드에서 대기중
         this.start();

         // 서버에서 임의 메시지 전송
         while (true) {
            String sLine = "Server<<" + sc.nextLine();
            pw.printf("%s", sLine);
            pw.flush();
         }

      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            if (bw != null)bw.close();
            if (br != null)br.close();
            if (socket != null)socket.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      }

   }

   @Override
   public void run() {
      while (true) {
         System.out.println("ServerThread");
         acceptSocket();
         try {
            sleep(500);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }

   private void acceptSocket() {
      try {
         socket = listner.accept();
         System.out.println("클라이언트와 연결되었습니다!");

         br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//         bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

         try {
            // 라인 \n이다 \n이 없는 데이터는 readLine로 읽을수 없다.
            userID = br.readLine();
            // user ID가 있고 pw 가 있다면 사용자 맵을 추가한다.
            userMap.put(userID, socket);
            broadCast(">> " + userID + "님이 입장하셨습니다.");
            
            ReceiveThread receive = new ReceiveThread(br, userID);
            receive.start();

         } catch (Exception e) {
            System.out.println("사용자 소켓 생성 예외 발생");
         }
      } catch (IOException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }

   }

   private void broadCast(String message) {
      // userMap에 저장된 모든 사용자들에게 메세지를 전달한다
      System.out.println(">>>BroadCast . . .");
      Iterator<String> keys = userMap.keySet().iterator();
      while (keys.hasNext()) {
         String key = keys.next();
         Socket socket = userMap.get(key);
         try {
            // BufferedReader in = new BufferedReader(new
            // InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new PrintWriter(socket.getOutputStream()));
            
            System.out.println(message);
            out.write(message+ "\n");
            out.flush();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

   }

   public static void main(String[] args) {
      new ServerSurvice();
   }

   class ReceiveThread extends Thread {
      // 연결된 소켓의 입력 스트립 객체
      BufferedReader in = null;
      String userID;

      ReceiveThread(BufferedReader in, String userID) {
         this.in = in;
         this.userID = userID;
      }

      @Override
      public void run() {
         while (true && in != null) {

            try {
               String line = in.readLine();
               if (".quit".equalsIgnoreCase(line)) {
                  System.out.println(".quit가 입력되어서 끝낸다!");
                  break;
               }
               broadCast(userID + ">> " + line);
               try {
                  Thread.sleep(100);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            } catch (IOException e) {
               e.printStackTrace();
            }

         }
      }

   }
}