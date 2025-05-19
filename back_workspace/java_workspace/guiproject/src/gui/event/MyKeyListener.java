package gui.event;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/* OS를 거쳐 JVM으로부터 전달되는 키 이벤트 */
public class MyKeyListener implements KeyListener {

	public void keyPressed(KeyEvent e)	{
		System.out.println("눌렀다 뗐다");
	}
	//눌렀다 뗄 때
	public void keyReleased(KeyEvent e) {
		System.out.println("눌렀어");
	}

	public void keyTyped(KeyEvent e) {
	}
}