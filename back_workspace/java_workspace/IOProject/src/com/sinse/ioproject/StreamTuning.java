package com.sinse.ioproject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamTuning {
	FileInputStream fis;
	InputStreamReader reader;
	BufferedReader buffr;

	public StreamTuning() {
		try {
			fis = new FileInputStream(
					"C:\\lecture_workspace\\back_workspace\\java_workspace\\IOProject\\res\\memo.txt");

			reader = new InputStreamReader(fis);
			buffr = new BufferedReader(reader);

			String data = null;
			int count = 0;
			while (true) {
				data = buffr.readLine();
				if (data == null)
					break;
				count++;
				System.out.println(data);
			}
			System.out.println(count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffr != null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		new StreamTuning();
	}
}
