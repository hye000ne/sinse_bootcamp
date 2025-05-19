package gui.layout;
import java.awt.*;

public class  LoginForm{
	public static void main(String[] args) {
		Frame frame = new Frame("로그인 폼");

		//상단 텍스트 패널
		Panel panel_center = new Panel();
		Label label_id = new Label("ID");
		TextField text_id = new TextField(20);
		Label label_pw = new Label("Password");
		TextField text_pw = new TextField(20);

		panel_center.setLayout(new GridLayout(2,2));
		panel_center.add(label_id);
		panel_center.add(text_id);
		panel_center.add(label_pw);
		panel_center.add(text_pw);

		//하단 버튼 패널
		Panel panel_south = new Panel();
		Button bt_login = new Button("login");
		Button bt_join = new Button("join");

		panel_south.add(bt_login);
		panel_south.add(bt_join);

		frame.add(panel_center, BorderLayout.CENTER);
		frame.add(panel_south, BorderLayout.SOUTH);

		frame.setSize(220 , 135);
		frame.setVisible(true);
	}
}
