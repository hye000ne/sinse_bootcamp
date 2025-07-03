package com.sinse.ioproject;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FileCopy extends JFrame implements ActionListener {
	JLabel l_ori;
	JLabel l_dest;
	JTextField t_ori;
	JTextField t_dest;
	JButton btn;

	public FileCopy() {
		l_ori = new JLabel("원본");
		l_dest = new JLabel("복사");
		t_ori = new JTextField();
		t_dest = new JTextField();
		btn = new JButton("복사실행");

		setLayout(new FlowLayout());

		Dimension l_d = new Dimension(100, 25);
		Dimension t_d = new Dimension(350, 25);
		l_ori.setPreferredSize(l_d);
		l_dest.setPreferredSize(l_d);
		t_ori.setPreferredSize(t_d);
		t_dest.setPreferredSize(t_d);
		btn.addActionListener(this);

		add(l_ori);
		add(t_ori);
		add(l_dest);
		add(t_dest);
		add(btn);

		setSize(490, 150);
		setVisible(true);
	}

	public void copy() {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(t_ori.getText());
			fos = new FileOutputStream(t_dest.getText());
			int data = 0;
			while (data != -1) {
				data = fis.read();
				fos.write(data);
			}
			// 시각적으로 완료됐음을 alert
			JOptionPane.showMessageDialog(this, "복사완료됐습니다");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		copy();

	}

	public static void main(String[] args) {
		new FileCopy();
	}

}
