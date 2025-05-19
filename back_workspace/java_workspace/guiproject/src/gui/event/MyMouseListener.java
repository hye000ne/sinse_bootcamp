package gui.event;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MyMouseListener implements MouseListener {
	public void mouseClicked(MouseEvent e) {
		System.out.println("클릭!");
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("영역으로 들어옴");
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("영역 밖으로 나감");
	}
	public void mousePressed(MouseEvent e) {
		System.out.println("누름");
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("뗌");
	}
}
