package use;
public class Account {
	private String num = "789-45678-89";
	private String bank = "하나은행";
	private String owner="Adams";
	int balance = 500000;

	//클래스 작성 시 데이터를 보호하고 이 보호된 데이터를 외부에서 사용하게 해주려면 공개된 메서드를 제공해주어야 하는데 이런한 클래스 정의 기법을 가리켜 은닉화 캡슐화 = encapsulation
	//데이터에 대해 읽기 쓰기가 가능하도록 메소드 정의

	public int getBalance(){
		return balance;
	}

	public void setBalance(int balance){
		this.balance = balance;
	}

	public String getNum(){
		return num;
	}

	public void setNum(String num){
		this.num= num;
	}

	public String getBank(){
		return bank;
	}

	public void setBank(String bank){
		this.bank= bank;
	}

	public String getOwner(){
		return owner;
	}

	public void setOwner(String owner){
		this.owner= owner;
	}
}