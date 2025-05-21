package gui.graphic;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class MyCanvas extends JPanel {
	Image img;

	public void setImg(Image img){
		this.img = img;
	}

	public void paint(Graphics g){
		g.drawImage(this.img, 0, 0, 600, 450, this);
	}
}
