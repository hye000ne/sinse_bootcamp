package gui.graphic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gui.graphic.MyCanvas;

public class Gallery extends JFrame implements ActionListener{
	JPanel p_north;
	JButton bt_prev;
	JButton bt_next;
	JLabel la_title;
	MyCanvas myCanvas;
	int[] x= new int[5];
	Image[] imgArray = new Image[9];
	Toolkit kit;
	int idx = 0 ;

	public Gallery(){
		p_north = new JPanel();
		bt_prev = new JButton("◀");
		bt_next = new JButton("▶");
		la_title = new JLabel("~~~ 파일명 ~~~");
		myCanvas = new MyCanvas();
		kit = Toolkit.getDefaultToolkit();

		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		p_north.setPreferredSize(new Dimension(600,50));
		add(p_north, BorderLayout.NORTH);

		add(myCanvas);

		createImg();
		showImg(idx);
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);

		setSize(600,500);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		JButton bt=(JButton)e.getSource();

		if(bt.getText() == "◀") showImg(--idx);
		if(bt.getText() == "▶") showImg(++idx);
	}

	public void createImg(){
		for(int i=1;i<imgArray.length+1;i++){
			imgArray[i-1] = kit.getImage("C:/lecture_workspace/back_workspace/java_workspace/guiproject/res/geographic/animal"+i+".jpg");
		}
	}

	public void showImg(int idx){
		myCanvas.setImg(imgArray[idx]);
		myCanvas.repaint();
	}

	public static void main(String[] args) {
		new Gallery();
	}
}
