package gui.layout;

import java.awt.*;
import gui.event.day0520.MyActionListener;

public class DoubleButton {

	public static void main(String[] args) {
		Frame frame = new Frame();
		Button btnA = new Button("A");
		Button btnB = new Button("B");
		frame.setLayout(new FlowLayout());
		frame.add(btnA);
		frame.add(btnB);

		MyActionListener listener = new MyActionListener(btnA,btnB);

		btnA.addActionListener(listener);
		btnB.addActionListener(listener);

		frame.setSize(300,400);
		frame.setVisible(true);
	}
}