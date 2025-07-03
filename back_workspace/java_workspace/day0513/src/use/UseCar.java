package use;
class UseCar {
	public static void main(String[] args){
		Car car = new Car();

		System.out.println(car.handle.color);
		System.out.println(car.wheel.brand);
		car.door.open();
	}
}