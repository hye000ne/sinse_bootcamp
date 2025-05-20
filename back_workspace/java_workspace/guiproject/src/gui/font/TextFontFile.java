package gui.font;

import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.font.TextStyle;

public class TextFontFile extends Frame implements ActionListener {
	TextStyle textStyle;

	TextArea area;
	Panel south_panel;
	Button btn;

	public TextFontFile(){
		area = new TextArea();
		area.setBackground(Color.YELLOW);
		south_panel = new Panel();
		btn = new Button("서식");

		btn.addActionListener(this);
		this.add(area);

		south_panel.add(btn);
		this.add(south_panel, BorderLayout.SOUTH);

		this.setSize(300,400);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		System.out.println("눌름");
		textStyle = new TextStyle(this);
	}

	public static void main(String[] args) {
		new TextFontFile();
	}
}
