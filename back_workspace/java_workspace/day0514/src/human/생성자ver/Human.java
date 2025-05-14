package human;

public class Human {
	private String loc;
	private String lan;
	private String greeting;

	public void speak(){
		System.out.println(this.greeting);
	}

	public Human(){}

	public Human(String loc, String lan, String greeting){
		this.loc = loc;
		this.lan = lan;
		this.greeting = greeting;
	}

	public void setLoc(String loc){
		this.loc = loc;
	}

	public String getLoc(){
		return loc;
	}

	public void setLan(String lan){
		this.lan = lan;
	}

	public String getLan(){
		return lan;
	}

	public void setGreeting(String greeting){
		this.greeting = greeting;
	}

	public String getGreeting(){
		return greeting;
	}
}