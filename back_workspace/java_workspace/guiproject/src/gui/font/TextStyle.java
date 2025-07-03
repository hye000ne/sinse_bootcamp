package gui.font;

import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.font.TextFontFile;

public class TextStyle extends Frame implements ActionListener {
	TextFontFile file;
	Panel center_panel;
	Label l_size;
	TextField t_size;
	Label l_color;
	TextField t_color;
	Panel south_panel;
	Button btn;

	public TextStyle(Object obj){
		file = (TextFontFile)obj;

		center_panel = new Panel();
		l_size = new Label("폰트 사이즈");
		t_size = new TextField(20);
		l_color = new Label("폰트 색상");
		t_color = new TextField(20);

		south_panel = new Panel();
		btn = new Button("적용");

		Dimension d = new Dimension(110, 25);
		l_size.setPreferredSize(d);
		t_size.setPreferredSize(d);
		l_color.setPreferredSize(d);
		t_color.setPreferredSize(d);
		center_panel.add(l_size);
		center_panel.add(t_size);
		center_panel.add(l_color);
		center_panel.add(t_color);

		this.add(center_panel);

		south_panel.add(btn);
		this.add(south_panel, BorderLayout.SOUTH);

		this.setSize(300,400);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		//area 폰트 크기 조절
		//area 폰트 색상
		file.area.setForeground(Color.YELLOW);
	}
}
