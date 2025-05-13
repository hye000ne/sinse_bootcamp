package test;

public class Dog {
	public String name="멍멍이";
	public int age = 5;

	/**
	강아지 울음소리 출력
	*/
	public void bark(){
		System.out.println("멍멍");
	}

	/**
	강아지 자기소개
	*/
	public void intro(){
		System.out.println("안녕 내 이름은 " + this.name + "고, 나이는 " + this.age + "야");
	}
}