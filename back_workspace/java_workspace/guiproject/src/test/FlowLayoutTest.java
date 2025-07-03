/*
	모든 GUI 프로그램은 컴포넌트들을 조합하여 화면을 구성하기 때문에, 각자의 배치(Layout)방법을 지원한다.
	AWT의 배치방법은
	1) BorderLayout : 아무것도 명시하지않으면 컨테이너류는 default로 borderLayout가 설정됨. frame 경계선까지 확장
	2) FlowLayout : 흐르는 배치방법. 컴포넌트 본여의 크기를 유지함.
	3) GridLayout
	4) GridBagLayout
*/
package test;
import java.awt.*;
class  FlowLayoutTest{
	public static void main(String[] args) {
		Frame frame = new Frame("플로우 배치방식"); //윈도우 생성

		frame.setLayout(new FlowLayout());

		for(int i=0;i<20;i++){
			frame.add(new Button("버튼 "+i));
		}

		frame.setSize(200,250);
		frame.setVisible(true);

	}
}
