package gui.graphic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gui.graphic.MovePanel;
public class MoveTest extends JFrame implements ActionListener {
	JPanel p_north;
	MovePanel p_center;
	JButton bt;

	public MoveTest(){
		p_north = new JPanel();
		p_center = new MovePanel();
		bt = new JButton("Move");
		bt.addActionListener(this);

		p_north.add(bt);
		p_north.setPreferredSize(new Dimension(600,50));
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 600,650);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		p_center.move();
		repaint();
	}

	public static void main(String[] args) {
		new MoveTest();
	}
}
