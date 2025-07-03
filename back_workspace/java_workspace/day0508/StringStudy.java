class StringStudy {
	public static void main(String args[]){
		String s1 = "korea";
		String s2 = "korea";
		System.out.println(s1==s2);

		String s3 = new String("korea");
		String s4 = new String("korea");
		System.out.println(s3 == s4);
	}
}