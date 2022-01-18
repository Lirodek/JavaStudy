package socketPackEx04;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import socketPackEx04.ServerSurvice.ReceiveThread;

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
         
         //receive실행
         
         
         while(true) {      
            String line = sc.nextLine();
            bw.write(line+"\n");
            bw.flush();
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
   class ReceiveThread extends Thread{
      //연결된 소켓의 입력 스트립 객체
      BufferedReader br = null;
      
      ReceiveThread(BufferedReader br){
         this.br = br;
      }
      
      @Override
      public void run() {
         while(true) {
            
            try {
               String line = br.readLine();
               System.out.println(line);
            } catch (IOException e) {
               e.printStackTrace();
            }
            
         }
      }
      
   }
}