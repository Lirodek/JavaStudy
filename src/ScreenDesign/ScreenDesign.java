package ScreenDesign;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScreenDesign extends Frame{
	
	int w = 680, h = 380;
	
	Panel PanelSide = new Panel( new GridLayout( 8, 1, 0, 0 ) );
	Panel SouthSide = new Panel( new FlowLayout() );
	Panel CenterSide = new Panel( new FlowLayout() );
	
	Label numberLabel = new Label("번  호 ");
	Label nameLabel = new Label("이  름 ");
	Label emailLabel = new Label(" 이메일");
	Label phoneLabel = new Label("전화번호");
	
	Panel numberGrid = new Panel();
	Panel nameGrid = new Panel();
	Panel emailGrid = new Panel();
	Panel phoneGrid = new Panel();

	TextField Number = new TextField(15);
	TextField name = new TextField(15);
	TextField email = new TextField(15);
	TextField phone = new TextField(15);
	
	TextArea area = new TextArea("", 30, 60, 3);
	
	
	public ScreenDesign() 
	{
		super.setTitle(" ");
		super.setSize( w, h );
		
		settingCenter();
		settingClosing();
		add(BorderLayout.LINE_START, PanelSide);
		add(BorderLayout.CENTER, CenterSide);
		
		CenterSide.add(area);
		
		PanelSide.add(numberGrid);
		numberGrid.add(numberLabel);
		numberGrid.add(Number);
		
		PanelSide.add(nameGrid);
		nameGrid.add(nameLabel);
		nameGrid.add(name);
		
		PanelSide.add(emailGrid);
		emailGrid.add(emailLabel);
		emailGrid.add(email);
		
		PanelSide.add(phoneGrid);
		phoneGrid.add(phoneLabel);
		phoneGrid.add(phone);
		
		add(BorderLayout.SOUTH, SouthSide);
		SouthSide.add( new Button(" 전체보기 ") );
		SouthSide.add( new Button(" 추  가  ") );
		SouthSide.add( new Button(" 삭  제  ") );
		SouthSide.add( new Button(" 검  색  ") );
		SouthSide.add( new Button(" 취  소  ") );
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
	
	public static void main(String[] args) {
		new ScreenDesign().setVisible(true);
	}
}
