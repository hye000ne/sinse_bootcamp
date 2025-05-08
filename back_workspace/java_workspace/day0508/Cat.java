class Cat {
	String name = "tomcat";
	int age = 5;

	public int getAge(){
		return this.age;
	}

	//java.exe 호출 시 main 메서드 자동 호출
	//cmd > java 클래스명 문자열1 문자열2  : main 메서드 매개변수로 String 값을 넘김.
	//ex) java Cat 사과 오렌지
	public static void main(String args[]){
		/* for(int i=0;i<args.length;i++){
			System.out.println("args["+i+"] : " + args[i]);
		} */

		int x = 7;
		Cat cat = new Cat();
		System.out.println(cat.getAge());
	}
}