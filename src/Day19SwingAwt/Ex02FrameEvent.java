package Day19SwingAwt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex02FrameEvent extends Frame implements WindowListener
{
	
	public Ex02FrameEvent() {
		
		setTitle("WindowEventListener 실습");
		setSize(640, 480);
		setVisible(true);
		
		this.addWindowListener( this );
		
	}

	public void windowOpened(WindowEvent e)      {}
	
	public void windowClosing(WindowEvent e)     
	{
		 // 닫기 버튼 눌렀을때 창 닫고 프로세스 끝내기.
		System.out.println("닫기버튼을 눌러서 \n프로세스가 종료됩니다.");
		dispose();               //할당 릴리즈 회수
		System.exit(0);          //강제종료
	}
	
	public void windowClosed(WindowEvent e)      {}
	public void windowIconified(WindowEvent e)   {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e)   {}
	public void windowDeactivated(WindowEvent e) {}
	
	public static void main(String[] args) 
	{
		new Ex02FrameEvent();

	}

}
