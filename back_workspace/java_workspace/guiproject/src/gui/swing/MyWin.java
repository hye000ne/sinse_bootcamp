/*swing : OS에 상관없는 중립적인 Look & Feel 디자인 유지. awt 컴포넌트 명에 접두어 J*/
package gui.swing;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.swing.Config;

public class MyWin extends JFrame implements ActionListener{
	JTextArea area;
	JPanel p_south;
	JButton bt;

	public MyWin(){
		area = new JTextArea(4,15); //행, 열
		area.setBackground(Color.YELLOW);

		p_south = new JPanel();
		bt = new JButton("환경설정");
		bt.addActionListener(this);

		add(area);
		p_south.add(bt);
		add(p_south, BorderLayout.SOUTH);

		setBounds(300,200,300,400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		new Config(this);
	}

	public static void main(String[] args) {
		new MyWin();
	}
}
