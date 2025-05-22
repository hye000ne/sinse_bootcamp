package gui.io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class BinaryLoader {
	FileInputStream fis;
	FileOutputStream fos;

	String url ="C:/lecture_workspace/back_workspace/java_workspace/guiproject/res/cute.png";
	String target = "C:/lecture_workspace/back_workspace/java_workspace/guiproject/res/cute_copy.png";

	public BinaryLoader() {
		try{
			fis = new FileInputStream(url);
			fos = new FileOutputStream(target);
			int data = 0;
			while(data!=-1){
				data = fis.read();
				//읽어들인 바이트 데이터를 출력
				fos.write(data);
			}
		} catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다. 파일명을 확인해주세요");
		} catch(IOException e) {
			System.out.println("입출력에 문제가 생겼습니다.");
		} finally {
			if(fis != null){
				try{
					fis.close();	//스트림 닫기
				}catch(IOException e){
					//일반 유저가 아닌 개발자를 위한 로그 출력
					e.printStackTrace();
				}
			}

			if(fos != null){
				try{
					fos.close();	//스트림 닫기
				}catch(IOException e){
					//일반 유저가 아닌 개발자를 위한 로그 출력
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new BinaryLoader();
	}
}
