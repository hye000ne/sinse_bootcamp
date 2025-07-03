package gui.chat;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ChatB extends Frame implements KeyListener{

	ChatA chatA;
	TextArea area;
	Panel p_south;
	TextField t_input;

	public ChatB(Object obj){
		System.out.println(obj);
		chatA = (ChatA)obj;
		area= new TextArea();
		p_south = new Panel();
		t_input = new TextField(30);

		//스타일
		area.setBackground(Color.WHITE);

		add(area);
		p_south.add(t_input);
		add(p_south, BorderLayout.SOUTH);

		t_input.addKeyListener(this);

		setSize(300,400);
		setVisible(true);
	}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			area.append("나 : " + t_input.getText()+"\n");
			chatA.area.append("상대방 : " + t_input.getText()+"\n");
			t_input.setText("");
		}

	}
	public void keyTyped(KeyEvent e) {}

}