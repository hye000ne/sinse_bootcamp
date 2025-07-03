package gui.event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		//액션 이벤트가 발생했을때 처리할 로직을 작성 addEventListener("click", function(){});과 유사
		System.out.println("나 눌렀어?");
	}
}
