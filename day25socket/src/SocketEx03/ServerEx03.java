package SocketEx03;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.sound.midi.Receiver;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerEx03 extends JFrame implements ActionListener{
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	// JArea를 상속받고 Runnable 인터페이스를 구현한 클래스로써
	// 받은 정보를 담는 객체
	private Receiver receiver;
	private JTextField sender; // JTextField 객체로서 보내는 정보를 담는 객체
	
	public ServerEx03() {
		setTitle("서버 채팅 창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		receiver = new Receiver();
		receiver.setEditable(false);
		
		sender = new JTextField();
		sender.addActionListener(this);
		
		add(new JScrollPane(receiver), BorderLayout.CENTER);
		add(sender, BorderLayout.SOUTH);
		
		setSize(400, 200);
		setVisible(true);
	
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		
	}
	private void setupConnection() throws IOException{
		
		listener = new ServerSocket(9999);
		socket = listener.accept();
		
		receiver.append("클라이언트로부터 연결 완료");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	
	}
	private static void handleError(String string) {
		System.out.println(string);
		System.exit(0);
	}
	private class Receiver extends JTextArea implements Runnable{

		@Override
		public void run() {
			String msg = null;
			while(true) {
				try {
					msg = in.readLine();
				} catch(IOException e) {
					handleError(e.getMessage());
				}
				this.append("\n    client : "+msg);
				int pos =this.getText().length();
				this.setCaretPosition(pos);
			}
			
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == sender) {
			String msg = sender.getText();
			try {
				out.write(msg + "\n");
				out.flush();
				
				receiver.append("\n server<< "+msg);
				int pos = receiver.getText().length();
				sender.setText(null);
			} catch (IOException e1) {
				handleError(e1.getMessage());
			}
		}
		
	}
	

}
