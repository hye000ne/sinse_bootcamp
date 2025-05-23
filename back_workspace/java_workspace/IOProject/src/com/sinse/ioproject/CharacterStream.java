package com.sinse.ioproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 스트림의 분류 1)방향 - 입력 - 출력 2) 데이터 처리방법 - 바이트 : 1byte씩 - 문자 : 1문자씩 (문자 이해 스트림) -
 * 버퍼기간
 */
public class CharacterStream {

	// 바이트 기반 스트림의 특징 : 입력 InputStream, 출력 OutputStream
	// 문자 기반 스트림 : 입력 read 출력이면 write
	FileInputStream fis; // 파일을 대상으로한 바이트 기반의 입력 스트림
	FileOutputStream fos; // 파일을 대상으로한 바이트 기반의 출력 스트림

	InputStreamReader is; // 기존에 존재하는 바이트 기반의 입력 스트림을 덧붙여 사용
	OutputStreamWriter os; // 기존에 존재하는 바이트 기반의 출력 스트림을 덧붙여 사용

	// 아래의 두 클래스는 파일에 국한되므로 , 파일 관련된 작업에만 유용하므로 범용성 떨어짐
	FileReader reader; // 파일을 대상으로 한 문자 기반 입력스트림
	FileWriter writer;

	String str = "C:\\lecture_workspace\\back_workspace\\java_workspace\\IOProject\\res\\memo.txt";
	String str2 = "C:\\lecture_workspace\\back_workspace\\java_workspace\\IOProject\\res\\memo_copy.txt";

	public CharacterStream() {
		try {
			fis = new FileInputStream(str);
			fos = new FileOutputStream(str2);

			is = new InputStreamReader(fis);
			os = new OutputStreamWriter(fos);

			int data = -1;
			while (true) {
				data = is.read();
				if (data == -1)
					break;
				os.write(data);
				System.out.println((char) data);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new CharacterStream();
	}
}
