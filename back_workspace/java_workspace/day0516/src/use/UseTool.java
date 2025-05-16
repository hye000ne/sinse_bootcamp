package use;

import instrument.MusicTool;
import instrument.Piano;
import instrument.Drum;
import riding.Roller;

public class UseTool {
	public static void main(String[] args) {
		//추상클래스는 인스턴스화 될 수 없다.
		//MusicTool mt = new MusicTool();
		Piano p = new Piano();
		p.setVolume();

		//다형성 테스트
		MusicTool mtp = new Piano();
		mtp.setVolume();
		MusicTool d = new Drum();
		d.setVolume();

		Roller r = new Piano();
		r.roll();
	}
}
