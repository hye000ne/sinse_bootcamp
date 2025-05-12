package use; //개발자가 패키지를 선언하면 javac -d 옵션사용 시 선언한 패키지에 해당하는 디렉토리를 자동 생성해준다.
import animal.Dog; //환경변수 classpath 기준으로 밑의 animal 밑의 Dog.class를 임포트한다.
class UseDog {
	public static void main(String[] args){
		Dog d = new Dog();
		d.bark();
	}
}