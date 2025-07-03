class LocalArea {
	int k = 7;

	public LocalArea(){
		k=9;
	}

	{
		//인스턴스 초기화 영역: 해당 클래스로부터 인스턴스를 생성할 때마다 실행되는 영역
		System.out.println("인스턴트 생성");
		k = 7;
	}

	public static void main (String args[]){
		new LocalArea();
		{
			int x = 5;
		}

		//x= 7;

	}
}