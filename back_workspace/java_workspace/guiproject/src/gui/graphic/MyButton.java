/* 자바에서 대상 클래스가 final 선언되어 있지 않으면 언제나 상속 가능 */

package gui.graphic;
import javax.swing.JButton;
import java.awt.Graphics;
public class MyButton extends JButton {
	public MyButton(String text){
		super(text);
	}

	public void paint(Graphics g){
		g.drawOval(0,0,25,25);
	}
}
