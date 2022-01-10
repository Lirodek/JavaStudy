package Acalculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Aclculator extends Frame{
	
	int w = 350, h = 430;
	
	Panel MainPanel = new Panel( new GridLayout(4,1) );
	
	Panel NorthPanel = new Panel( new FlowLayout() );
	Panel MiddleNorthPanel = new Panel ( new GridLayout( 2, 5, 5, 5 ) );
	Panel MiddleSouthPanel = new Panel ( new GridLayout( 2, 5, 5, 5 ) );
	Panel SouthPanel       = new Panel ( new GridLayout( 2, 5, 5, 5 ) );
	Panel FlowPanel        = new Panel ( new GridLayout( 2, 5, 5, 5) );
	
	TextArea area = new TextArea( "", 4, 41, 3 );
	
	public Aclculator() 
	{
		
		super.setTitle("계산기");
		super.setSize(w, h);
		
		add(BorderLayout.NORTH, MainPanel);
		MainPanel.add(NorthPanel);
		NorthPanel.add(area);
		MainPanel.add(MiddleNorthPanel);
		MainPanel.add(MiddleSouthPanel);
		MainPanel.add(FlowPanel);
		
		
		getMiddle1();
		getMiddle2();
		getMiddle3();

		settingMenubar();
		settingClosing();
		settingCenter();
		
	}
	
	private void settingMenubar() {
		
		
		MenuItem menuItem = new MenuItem("View");
		
		Menu menu = new Menu("View(V)");
		Menu Edit = new Menu("Edit(E)");
		Menu Help = new Menu("Help(H)");
		menu.add(menuItem);
		
		MenuBar menuBar = new MenuBar();
		menuBar.add(menu);
		menuBar.add(Edit);
		menuBar.add(Help);
		
		super.setMenuBar(menuBar);
	}

	private void getMiddle3() 
	{
		Button b1 = new Button("1");
		FlowPanel.add(b1);
		
		Button b2 = new Button("2");
		FlowPanel.add(b2);
		
		Button b3 = new Button("3");
		FlowPanel.add(b3);
		
		Button b4 = new Button("-");
		FlowPanel.add(b4);
		
		Button b5 = new Button("=");
		FlowPanel.add(b5);
		
		Button b6 = new Button("0");
		FlowPanel.add(b6);
		
		Button b7 = new Button("0");
		FlowPanel.add(b7);
		
		Button b8 = new Button(".");
		FlowPanel.add(b8);
		
		Button b9 = new Button("+");
		FlowPanel.add(b9);
		
		Button b10 = new Button("=");
		FlowPanel.add(b10);
		
	
	}

	private void getMiddle2() 
	{
		
		MiddleSouthPanel.add(new Button("7"));
		MiddleSouthPanel.add(new Button("8"));
		MiddleSouthPanel.add(new Button("9"));
		MiddleSouthPanel.add(new Button("/"));
		MiddleSouthPanel.add(new Button("%"));
		
		MiddleSouthPanel.add(new Button("4"));
		MiddleSouthPanel.add(new Button("5"));
		MiddleSouthPanel.add(new Button("6"));
		MiddleSouthPanel.add(new Button("*"));
		MiddleSouthPanel.add(new Button("1/x"));
	}

	private void getMiddle1() 
	{
		MiddleNorthPanel.add(new Button("MC"));
		MiddleNorthPanel.add(new Button("MR"));
		MiddleNorthPanel.add(new Button("MS"));
		MiddleNorthPanel.add(new Button("M+"));
		MiddleNorthPanel.add(new Button("M-"));
		
		MiddleNorthPanel.add(new Button("<-"));
		MiddleNorthPanel.add(new Button("CE"));
		MiddleNorthPanel.add(new Button("MS"));
		MiddleNorthPanel.add(new Button("C"));
		MiddleNorthPanel.add(new Button("v-"));
	}

	private void settingClosing() 
	{
		addWindowListener(
			new WindowAdapter() 
			{
				@Override
				public void windowClosing(WindowEvent e) 
				{
					System.out.println("프로그램종료");
					dispose();
					System.exit(0);
				}
			});
	}
	public void settingCenter() 
	{
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrW = ( int ) tk.getScreenSize().getWidth();
		int scrH = ( int ) tk.getScreenSize().getHeight();
		int x = scrW / 2 - w / 2;
		int y = scrH / 2 - h / 2;
		this.setLocation(x, y);
	}
	
	public static void main(String[] args) 
	{
		new Aclculator().setVisible(true);

	}

}
