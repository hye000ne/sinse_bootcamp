package gui.swing;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.swing.MyWin;
public class Config extends JFrame implements ActionListener {
	MyWin myWin;
	JTextField t_size;
	JButton bt;

	public Config(Object obj){
		myWin = (MyWin)obj;

		t_size = new JTextField(20);
		bt = new JButton("적용");
		bt.addActionListener(this);

		setLayout(new FlowLayout());
		add(t_size);
		add(bt);

		setBounds(600,200,300,150);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		myWin.area.setFont(new Font(null,0,Integer.parseInt(this.t_size.getText())));

		/*
			자바 기본 자료형
			1) 숫자
				- 정수 : byte < short < int < long
				- 실수 : float < double
			2) 문자 : char
			3) 논리값 : boolean

			** 래퍼클래스 : 기본 자료형과 객체자료형간 변환이 가능하도록 지원되는 객체
			1) 숫자
				- 정수 : Byte < Short < Integer < Long
				- 실수 : Float < Double
			2) 문자 : Character
			3) 논리값 : Boolean
		*/
	}
}
