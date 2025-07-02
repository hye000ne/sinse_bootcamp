package imageClient;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class UploadClient extends JFrame {
	JTextField t_title;
	JFileChooser chooser;
	JButton bt_file;
	JButton bt_regist;
	
	public UploadClient() {
		t_title = new JTextField(20);
		chooser = new JFileChooser();
		bt_file = new JButton("파일 선택");
		bt_regist = new JButton("업로드");
		
		setLayout(new FlowLayout());
		add(t_title);
		add(bt_file);
		add(bt_regist);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,170);
		setVisible(true);
	}
}
