package com.sinse.networkapp.multicast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//접속자가 감지되었을때, 소켓을 넘겨받아, 그 소켓과 연결된 클라이언트와 끝없는 
//메시지를 주고 받자 
public class ServerChatThread extends Thread{
	GUIServer guiServer;
	
	Socket socket; //서버로부터 넘겨받은 소켓, 스트림을 뽑을 수있으므로 .
	BufferedReader buffr;
	BufferedWriter buffw;
	
	public ServerChatThread(GUIServer guiServer, Socket socket) {
		this.guiServer=guiServer;
		this.socket=socket;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void run() {
		while(true) {
			listen();
		}
	}
	
	//듣기
	public void listen() {
		String msg=null;
		try {
			msg=buffr.readLine(); //클라이언트가 전송한 메시지 청취
			guiServer.area.append(msg+"\n");
			
			//서버에 접속한 모든 유저와 1:1 대응하는 ServerChatThread 수만큼 반복하면서 메시지를 보내자
			for(int i=0;i<guiServer.vec.size();i++) {
				ServerChatThread st=guiServer.vec.get(i);
				st.send(msg);
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			guiServer.vec.remove(this);//상대방 클라이언트가 나가버리면 나는 더이상 접속자 명단에 있으면 안되므로 나를 제거하자
			guiServer.area.append("현재 접속자 " + guiServer.vec.size() + "\n");
		}
	}
	
	//말하기
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}