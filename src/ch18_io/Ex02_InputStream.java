package ch18_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Ex02_InputStream {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("c:/Temp/sample.txt");
//		is = new FileInputStream(new File("c:/Temp/README.txt"));
		
		// 읽는 방법 1
		while (true) {
			int data = is.read();	// 1바이트를 읽어서 정수형으로 반환
			if (data == -1)			// 마지막 데이터 (모든 비트가 1인게 -1)
				break;
			System.out.print((char)data);
		}
		// 읽는 방법 2
		is = new FileInputStream("c:/Temp/README.txt");
		byte[] arr = new byte[512];
		while (true) {
			int num = is.read(arr);
			System.out.println("읽은 바이트 수: " + num);
			if(num == -1)
				break;
		}
		System.out.println(new String(arr));
		is.close();
	}

}
