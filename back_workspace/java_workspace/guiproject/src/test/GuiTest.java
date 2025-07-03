package test;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.TextArea;
import java.awt.Checkbox;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;

class GuiTest {
	public static void main(String[] args) {
		Frame f = new Frame(); //윈도우 생성
		f.setLayout(new FlowLayout());

		//Button
		Button b = new Button("버튼");
		f.add(b);

		//input text
		TextField t = new TextField(20);// 20자 수용가능한 크기를 가지고 생성
		f.add(t);

		//select box
		Choice ch1 = new Choice();
		ch1.add("@naver.com");
		ch1.add("@gmail.com");
		ch1.add("@daum.net");
		f.add(ch1);

		//TextArea
		TextArea area = new TextArea(12,20); //12줄에 20칸
		f.add(area);

		//Checkbox
		Checkbox[] arr = new Checkbox[3];
		arr[0] = new Checkbox("JAVA", true);
		arr[1] = new Checkbox("JSP", false);
		arr[2] = new Checkbox("Oracle", true);
		for(int i=0;i<arr.length;i++) f.add(arr[i]);

		//label
		Label la = new Label("제목 등 일반 텍스트");
		f.add(la);

		//메뉴바와 메뉴 만들기
		Menu m_file, m_edit, m_style, m_view, m_help;
		m_file = new Menu("파일");
		m_edit = new Menu("편집");
		m_style = new Menu("스타일");
		m_view = new Menu("보기");
		m_help = new Menu("도움말");

		MenuBar bar = new MenuBar();

		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_style);
		bar.add(m_view);
		bar.add(m_help);

		f.setMenuBar(bar);

		f.setSize(600,500);//자바의 윈도우를 사용하려면 너비, 높이를 지정해야한다.
		f.setVisible(true); // 또한 윈도우 디폴트 보기옵션은 비활성화되어 있어서 활성화 시켜야함
	}
}
