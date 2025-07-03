class Member { //A;
	int age=23;
	static int money=23;

	public void talk(){
	}
}

public class UseMember{
	static int k=8;
	public static void main(String[] args){
		UseMember.k = 9;
		System.out.println(UseMember.k);
		k = 10;
		System.out.println(k);

	}
}
