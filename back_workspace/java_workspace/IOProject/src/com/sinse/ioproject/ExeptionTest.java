package com.sinse.ioproject;

public class ExeptionTest {
	public static void main(String[] args) {
		int[] arr = new int[3];
		try {
			arr[0] = 1;
			arr[1] = 3;
			arr[2] = 4;
			arr[3] = 5;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		throw new MyArrayException("배열 관련 에러 발생");
	}
}
