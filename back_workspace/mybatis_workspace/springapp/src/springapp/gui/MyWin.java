package springapp.gui;

import java.applet.AppletContext;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * 스프링은 웹 뿐 아니라, 데스크탑 기반, 안드로이드 개발에 적용 가능하다. 
 */
public class MyWin extends JFrame {
	JComponent name;
	JComponent email;
	JComponent btn;
	
	// 외부 환경인 스프링으로부터, 필요한 빈들을 주입받으려면 개발자는 두가지 중 선택할 수 있다
	// 1) 생성자 주입
	// 2) setter 주입
	public MyWin(JComponent name, JComponent email, JComponent btn) {
		this.name = name;
		this.email = email;
		this.btn = btn;
		
		setLayout(new FlowLayout());
		add(name);
		add(email);
		add(btn);
		
		setSize(200,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setName(JComponent name) {
		this.name = name;
	}

	public void setEmail(JComponent email) {
		this.email = email;
	}

	public void setBtn(JComponent btn) {
		this.btn = btn;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(MyWin.class);
	}
	
}
