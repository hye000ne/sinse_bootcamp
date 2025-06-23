package com.sinse.networkapp.multicast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements Runnable{
	JPanel p_north;
	JComboBox box_ip;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	Thread thread; //접속 스레드
	ClientChatThread chatThread;
	
	public Client() {
		p_north = new JPanel();
		box_ip = new JComboBox();
		t_port = new JTextField("9999",8);
		bt = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField();
		thread = new Thread(this);
		
		area.setBackground(Color.YELLOW);
		
		createIp();
		
		p_north.add(box_ip);
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		add(t_input, BorderLayout.SOUTH);
		
		bt.addActionListener(e->{
			//서버에 접속 시작 
			thread.start();
		});
		
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					chatThread.send(t_input.getText());
				}
			}
		});
		
		setBounds(100, 100, 300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	//접속이란, 서버의 ip와 포트번호를 이용하여 소켓을 생성하는 것!!
	public void connectServer() {
		String ip=(String)box_ip.getSelectedItem();
		int port=Integer.parseInt(t_port.getText());
		
		try {
			Socket socket = new Socket(ip, port);
			
			chatThread = new ClientChatThread(this, socket);
			chatThread.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		connectServer();
	}
	
	public void createIp() {
		box_ip.addItem("192.168.60.41");
		for(int i=15;i<=30;i++) {
			box_ip.addItem("192.168.60."+i);
		}
	}
	public static void main(String[] args) {
		new Client();
	}

}