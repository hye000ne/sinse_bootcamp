package gui.event.day0520;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class MyActionListener implements ActionListener{
	Button btnA = null;
	Button btnB = null;

	public MyActionListener(Button btnA, Button btnB) {
		this.btnA = btnA;
		this.btnB = btnB;
	}
	//사용자가 액션이벤트를 일으키면 OS로부터 이벤트 정보를 받은 JVM은 해당 이벤트 정보를 알맞는 이벤트 객체로 인스턴스화 시킴
	//그리고 생성된 이벤트 인스턴스는 재정의 메서드인 btnBctionPerformed()메서드로 전달해준다.
	//개발자는 자신이 알고싶은 이벤트 정보를 ActionEvent로 부터 모든 것을 알 수 있다.
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();

		if(obj == btnA){
			System.out.println("A 눌렀어?");
		} else if(obj == btnB) {
			System.out.println("B 눌렀어?");
		}

	}
}
