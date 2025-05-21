/* 그래픽 프로그래밍
	[현실]                         [프로그래밍]
	1) 화가                        컴포넌트
	2) 붓(그리는 행위)           컴포넌트가 보유한 그리는 메서드(paint())
	3) 팔레트 , 기타도구          paint(Graphics g)
	4) 그려질 대상                컴포넌트 자신
*/
package gui.graphic;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import gui.graphic.MyButton;
import gui.graphic.ImgPanel;


public class TestFrame extends JFrame {
	MyButton bt;
	ImgPanel ip;

	public TestFrame(){
		bt = new MyButton("버튼");
		ip = new ImgPanel();

		setLayout(new FlowLayout());
		add(bt);
		add(ip);

		setSize(300,400);
		setVisible(true);

		//윈도우 창을 닫을때, 프로세스 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TestFrame();
	}
}
