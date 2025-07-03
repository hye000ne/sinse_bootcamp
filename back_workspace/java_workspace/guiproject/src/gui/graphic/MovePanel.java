package gui.graphic;
import java.awt.*;
import javax.swing.*;

public class MovePanel extends JPanel{
	int x = 50;
	int y = 50;

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public void move() {
		x++;
		y++;
	}

	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillOval(this.x, this.y, 45, 45);
	}
}
