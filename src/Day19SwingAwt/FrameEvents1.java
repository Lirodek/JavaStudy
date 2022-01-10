package Day19SwingAwt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEvents1 extends Frame implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e)      {}//윈도우 열렷을때 호출	
	public void windowClosing(WindowEvent e)     {}//윈도우가 닫히고있을때 호출
	public void windowClosed(WindowEvent e)      {}//윈도우가 닫혔을때 호출
	public void windowIconified(WindowEvent e)   {}//윈도우가 아이콘화 되었을때 호출
	public void windowDeiconified(WindowEvent e) {}//윈도우가 정상화되었을때 호출
	public void windowActivated(WindowEvent e)   {}//윈도우가 활성화 되었을때 호출
	public void windowDeactivated(WindowEvent e) {}//윈도우가 비 활성화 되었을때 호출

}
