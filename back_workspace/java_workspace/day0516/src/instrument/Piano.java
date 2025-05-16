package instrument;
import riding.Roller;
/*
	자바에서는 현실의 개념을 그대로 반영하여, 다중상속을 허용하지 않는다
	하지만 우리의 현실에서 제품을 개발할때 다중상속적 특성이 상당히 반영되어있다.

	인터페이스는 객체가 아니라 하위 객체들이 구현해야할 메서드만을 보유한 명세이다.
	따라서 하위 객체들이 이 인터페이스를 상속받아도 객체가 아니므로 다중상속 금지에 해당하지않음
	어차피 인터페이스가 보유한 메서드는 추상메서드이기 때문에 ㅕㄹ도 abstract 수식자를 명시하지않는다.
*/
public class Piano extends MusicTool implements Roller {
	String type = "grand"; // 종류 : ["grand", "upright", "digital"]
	int volume = 0; // 볼륨

	//오버라이딩 볼륨 조절
	public void setVolume(){
		System.out.println("피아노 볼륨 조절");
	}

	public void roll(){
		System.out.println("피아노를 타고 가요.");
	}
}