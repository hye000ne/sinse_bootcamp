/*
	모든 GUI 프로그램은 컴포넌트들을 조합하여 화면을 구성하기 때문에, 각자의 배치(Layout)방법을 지원한다.
	AWT의 배치방법은
	1) BorderLayout :
	2) FlowLayout :
	3) GridLayout : 모눈종이(행과열 존재). 행과 열을 지원하는 배치방법
	4) GridBagLayout
*/
package test;
import java.awt.*;
class  GridLayoutTest{
	public static void main(String[] args) {
		Frame frame = new Frame("그리드 배치방식"); //윈도우 생성

		frame.setLayout(new GridLayout(3,4));

		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++) {
				frame.add(new Button("["+i+", "+j+"]"));
			}
		}


		frame.setSize(400,400);
		frame.setVisible(true);

	}
}
