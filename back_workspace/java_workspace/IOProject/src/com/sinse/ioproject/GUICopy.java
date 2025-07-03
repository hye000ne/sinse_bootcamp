package com.sinse.ioproject;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUICopy extends JFrame implements ActionListener {
	JLabel l_ori, l_dest;
	JTextField t_ori, t_dest;
	JButton bt_ori, bt_dest, bt_copy;
	JFileChooser chooser;

	public GUICopy() {
		l_ori = new JLabel("원본");
		l_dest = new JLabel("복사");
		t_ori = new JTextField();
		t_dest = new JTextField();
		bt_ori = new JButton("열기");
		bt_dest = new JButton("저장");
		bt_copy = new JButton("복사");
		chooser = new JFileChooser("C:\\lecture_workspace\\back_workspace\\java_workspace\\guiproject\\res");

		Dimension dl = new Dimension(60, 24);
		Dimension dt = new Dimension(430, 22);

		l_ori.setPreferredSize(dl);
		l_dest.setPreferredSize(dl);
		t_ori.setPreferredSize(dt);
		t_dest.setPreferredSize(dt);
		bt_ori.setPreferredSize(dl);
		bt_dest.setPreferredSize(dl);

		setLayout(new FlowLayout());

		bt_ori.addActionListener(this);
		bt_dest.addActionListener(this);
		bt_copy.addActionListener(this);

		add(l_ori);
		add(t_ori);
		add(bt_ori);
		add(l_dest);
		add(t_dest);
		add(bt_dest);
		add(bt_copy);

		setSize(600, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_ori) {
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				// 유저가 선택한 파일 정보를 이용하여 경로 추출
				File file = chooser.getSelectedFile();
				t_ori.setText(file.getAbsolutePath());
			}
		} else if (e.getSource() == bt_dest) {
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				// 유저가 선택한 파일 정보를 이용하여 경로 추출
				File file = chooser.getSelectedFile();
				t_dest.setText(file.getAbsolutePath());
			}
		} else if (e.getSource() == bt_copy) {
			copy();
			JOptionPane.showMessageDialog(this, "복사완료됐습니다");

		}

	}

	public static void main(String[] args) {
		new GUICopy();
	}

}
