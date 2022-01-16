package org.LiroSelf.View;

import java.awt.Color;

import javax.swing.JScrollPane;

public class InfoTitle extends View {
	public InfoTitle() {
		cloumnIndentifiers.add(" 국 가 ");
		cloumnIndentifiers.add(" 이 름 ");
		cloumnIndentifiers.add(" 나 이 ");
		cloumnIndentifiers.add(" 성 별 ");
		tableModel.setColumnCount(4);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		display();
	}
	@Override
	public void display() {
		add(new JScrollPane(table));
		setBackground(Color.LIGHT_GRAY);

	}

}
