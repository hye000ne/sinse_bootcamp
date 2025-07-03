package gui.layout;
import java.awt.*;

public class  LoginForm2{
	public static void main(String[] args) {
		Frame frame = new Frame("로그인 폼");

		//상단 텍스트 패널
		Panel panel_center = new Panel();
		Label label_id = new Label("ID");
		TextField text_id = new TextField(10);
		Label label_pw = new Label("Password");
		TextField text_pw = new TextField(10);
		//하단 버튼 패널
		Panel panel_south = new Panel();
		Button bt_login = new Button("login");
		Button bt_join = new Button("join");

		//크기 조절
		Dimension dim = new Dimension(100,25);
		label_id.setPreferredSize(dim);
		label_pw.setPreferredSize(dim);
		text_id.setPreferredSize(dim);
		text_pw.setPreferredSize(dim);

		panel_center.add(label_id);
		panel_center.add(text_id);
		panel_center.add(label_pw);
		panel_center.add(text_pw);

		panel_south.add(bt_login);
		panel_south.add(bt_join);

		frame.add(panel_center, BorderLayout.CENTER);
		frame.add(panel_south, BorderLayout.SOUTH);

		frame.setSize(300, 140);
		frame.setVisible(true);
	}
}
