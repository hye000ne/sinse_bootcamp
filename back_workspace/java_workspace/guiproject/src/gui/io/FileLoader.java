/* 실행 중인 java프로그램에서 디스크의 파일 접근하여 데이터를 읽고 프로그램을 불러들여 출력 */
package gui.io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class FileLoader {
	public static void main(String[] args) {
		/* 실행중인 프로그램이 파일 등의 자원 데이터를 읽기 위해서는 스트림 객체가 필요하다.
		 스트림이란 데이터의 흐름을 의미함
		 1) 프로그램에 들어오는 흐름을 Input(입력)
		 2) 프로그램에서 데이터가 나가면 Output(출력)
		*/
		//파일을 대상으로한 입력 객체
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:/lecture_workspace/back_workspace/java_workspace/guiproject/res/memo.txt");
			int data = 0;
			while(data != -1) {
				data = fis.read();
				System.out.print((char)data);
				if(data==32) System.out.println();
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 도중 문제가 발생했습니다.");
		} finally {
			if(fis != null){
				try{
					fis.close();	//스트림 닫기
				}catch(IOException e){
					//일반 유저가 아닌 개발자를 위한 로그 출력
					e.printStackTrace();
				}
			}
		}
	}
}
