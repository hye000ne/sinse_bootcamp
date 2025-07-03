package gui.event;

import java.awt.*;
import gui.event.MyActionListener;
import gui.event.MyKeyListener;
import gui.event.MyItemListener;
import gui.event.MyMouseListener;


public class ActionTest {
	public static void main(String[] args) {
		Frame frame = new Frame();
		Button button = new Button("Click me !");
		TextField text = new TextField(20);
		Choice choice = new Choice();

		choice.addItem("choose your mail server");
		choice.addItem("@naver.com");
		choice.addItem("@gmail.com");
		choice.addItem("@daum.net");

		button.addActionListener(new MyActionListener());
		text.addKeyListener(new MyKeyListener());
		choice.addItemListener(new MyItemListener());
		frame.addMouseListener(new MyMouseListener());

		frame.setLayout(new FlowLayout());
		frame.add(button);
		frame.add(text);
		frame.add(choice);
		frame.setSize(300,400);
		frame.setVisible(true);
	}
}
