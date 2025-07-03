package instrument;
/*
추상클래스란? 불완전한 클래스를 말함
불완전하다? 메서드 몸체가 없는 상태
추상 메서드를 하나라도 보유하고 있으면 추상클래스
완전하지 못하기에 new 생성자를 사용할 수 없다.
*/

public abstract class  MusicTool {
	abstract public void setVolume(); //가이드만 제시해야하므로 메서드 내용을 채우면 안됨
}
