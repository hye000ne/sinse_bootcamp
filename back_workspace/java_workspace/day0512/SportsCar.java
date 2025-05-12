class SportsCar {
	String color = "none";

	public SportsCar(){
		color = "black";
	}

	public SportsCar(String color){
		this.color = color;
	}

	public static void main(String[] args){
		SportsCar sc = new SportsCar("red");
		SportsCar sc2 = new SportsCar();

		System.out.println(sc.color);
		System.out.println(sc2.color);

	}
}