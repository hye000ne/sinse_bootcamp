package com.sinse.ioproject;

/*언체크 예외의 경우, 개발자가 예외를 커스텀할 수 있음
RuntimeException을 상속받아야함*/
public class MyArrayException extends ArrayIndexOutOfBoundsException {

	public MyArrayException(String msg) {
		super(msg);
	}

}
