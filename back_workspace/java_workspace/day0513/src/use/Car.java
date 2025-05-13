package use;
class Car {
	int price;
	String name;

	//객체가 다른 객체를 멤버변수로 보유한 관계를 has a 관계라 한다.
	Handle handle; //has a 관계
	Wheel wheel;
	Door door;

	//생성자는 사물을 태어나게 하는 시점에 초기화에 관여하므로 특히 has a 관계에 있는
	//객체의 인스턴스를 생성할 떄 아주 유용함
	public Car(){
		int price = 5000;
		String name = "K9";
		Handle handle = new Handle();
		Wheel wheel = new Wheel();
		Door door = new Door();


	}
}