package use;
import animal.Bird;
import animal.Duck;

class UseDuck {
	public static void main(String[] args){
		Bird b = new Duck();
		b.age = 8;
		b.fly();
	}
}