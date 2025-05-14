package human;
import human.Human;
class UseHuman {
	public static void main(String[] args){

		Human asian = new Human("Asia" ,"kor", "안녕하세요. 저는 아시아인입니다.");
		Human european = new Human("Europe" ,"eng", "Hi. i'm european");
		Human negro = new Human("Africa" ,"eng", "hi. im negro.");

		asian.speak();
		european.speak();
		negro.speak();
	}
}