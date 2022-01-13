package org.Lirodek.ThreadEx01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadEx01 extends JFrame {
	int x = 700, h = 300;
	Container c;

	JLabel timmerLabel = new JLabel();
	JButton stopBtn = new JButton("STOP");
	JButton playBtn = new JButton("PLAY");

	public ThreadEx01() {

		add(BorderLayout.NORTH, timmerLabel);
		setTitle("timeless");
		setSize(x, h);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setting(x, h);
		c = getContentPane();

		final TimerThread tt = new TimerThread(timmerLabel, playBtn, stopBtn);
		tt.start();
		JPanel center = new JPanel(new GridBagLayout());
		timmerLabel.setFont(new Font("Arial", Font.BOLD, 50));
		center.add(timmerLabel);
		center.setBackground(Color.CYAN);
		center.add(stopBtn);
		center.add(playBtn);

		c.add(BorderLayout.CENTER, center);

		stopBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				synchronized (this) {
					tt.pauseThread();
				}

			}
		});
		playBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tt.replayThread();
			}
		});

	}

	private void setting(int w, int h) {
		this.getToolkit();
		Toolkit tk = Toolkit.getDefaultToolkit();
		int scrW = (int) tk.getScreenSize().getWidth();
		int scrH = (int) tk.getScreenSize().getHeight();
		int x = scrW / 2 - w / 2;
		int y = scrH / 2 - h / 2;
		this.setLocation(x, y);

	}

	public static void main(String[] args) {
		new ThreadEx01().setVisible(true);
	}
}

class TimerThread extends Thread {
	Boolean isPause = false;
	private static final Thread TimerThread = null;
	JButton start = new JButton();
	JButton stop = new JButton();
	private JLabel TimeLabel;
	int sec = 0;

	public TimerThread(JLabel timerLabel, JButton btn1, JButton btn2) {
		this.TimeLabel = timerLabel;
		this.start = btn1;
		this.stop = btn2;
	}

	public void replayThread() {
		synchronized (this) {
			isPause= false;
			this.notifyAll();
		}

	}

	public void run() {
		int ssec = 0;
		int sec = 0;
		int minute = 0;

		for (int i = 10;; i++) {
			if (ssec % 60 == 0)
				sec++;
			ssec %= 60;

			try {
				TimeLabel.setText("Timer >>> " + sec + ":" + ssec++);
				sleep(100 / 6);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("자는시간");
			}
			if (isPause == true)
				synchronized (this) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
		}
	}

	public void pauseThread() {
		isPause = true;

	}
}
