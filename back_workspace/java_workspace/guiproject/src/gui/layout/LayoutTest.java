package gui.layout;
import java.awt.Frame;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Color;

public class LayoutTest {
	public static void main(String[] args) {
		Frame frame = new Frame("배치 학습");

		Panel panel_south = new Panel();
		Panel panel_center = new Panel();

		Button bt_center1 = new Button("CENTER1");
		Button bt_center2 = new Button("CENTER2");
		Button bt_west = new Button("WEST");
		Button bt_south = new Button("SOUTH");

		panel_center.setBackground(Color.GRAY);
		panel_south.setBackground(Color.CYAN);

		panel_center.add(bt_center1);
		panel_center.add(bt_center2);
		panel_south.add(bt_south);

		frame.add(panel_center);
		frame.add(bt_west, BorderLayout.WEST);
		frame.add(panel_south, BorderLayout.SOUTH);

		frame.setSize(500,400);
		frame.setVisible(true);


	}
}
