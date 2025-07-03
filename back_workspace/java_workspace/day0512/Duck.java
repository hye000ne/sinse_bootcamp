/*메서드 오버로딩(OverLoading) : 메서드 중첩기법
	1) 메서드의 이름 동일
	2) 매개변수의 자료형이나 갯수가 달라야함
*/
class Duck {
	//오리가 난다.
	public void fly(){

	}
	//오리가 조금 높은 높이에서 난다.
	public void fly(int height){
		System.out.println("오리가 조금 높은 높이에서 난다.");
	}

}