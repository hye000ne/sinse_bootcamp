package springapp.gui;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public JTextField name() {
		return new JTextField(15);
	}
	
	@Bean
	public JTextField email() {
		return new JTextField(15);
	}
	
	@Bean
	public JButton btn() {
		return new JButton("버튼");
	}
	
	@Bean
	public MyWin myWin() {
		MyWin myWin = new MyWin(name(),email(),btn());
		
		return myWin;
	}
}
