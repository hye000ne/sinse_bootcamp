package gui.chat;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import gui.chat.ChatB;
public class ChatA extends Frame implements ActionListener, KeyListener {
	ChatB chatB;
	TextArea area;
	Panel p_south;
	TextField t_input;
	Button bt_open;

	public ChatA(){
		area= new TextArea();
		p_south = new Panel();
		t_input = new TextField(30);
		bt_open = new Button("열기");

		//스타일
		area.setBackground(Color.YELLOW);

		add(area);
		p_south.add(t_input);
		p_south.add(bt_open);
		add(p_south, BorderLayout.SOUTH);

		bt_open.addActionListener(this);
		t_input.addKeyListener(this);
		setSize(300,400);
		setVisible(true);
	}

	//ActionListener를 구현해야하므로 현재 클래스에서 오버라이딩
	public void actionPerformed(ActionEvent e){
		if(bt_open == (Button)e.getSource()) chatB = new ChatB(this);

	}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			area.append("나 : " + t_input.getText()+"\n");
			if(chatB != null) {
				chatB.area.append("상대방 : " + t_input.getText()+"\n");
			}
			t_input.setText("");
		}

	}
	public void keyTyped(KeyEvent e) {}

	public static void main(String[] args) {
		new ChatA();
	}
}