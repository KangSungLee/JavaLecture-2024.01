package ch18_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class Ex07_BufferedIO {
	// 버퍼드 중요 *****
	public static void main(String[] args) throws Exception {
		// buffer를 썻을 때와 안썼을 때 비교
		
		// Case 1) 미사용
		InputStream is = new FileInputStream("c:/temp/eiffel.jpg");
		OutputStream os = new FileOutputStream("c:/temp/에펠.jpg");
	
		long noBufferTime = copy(is, os);
		System.out.println("버퍼 미사용: " + noBufferTime + " ns");
		is.close(); os.close();
		//버퍼 미사용: 904895800 ns 0.9초
		
		// Case 2) 사용
		is = new BufferedInputStream(new FileInputStream("c:/temp/eiffel.jpg"));
		os = new BufferedOutputStream(new FileOutputStream("c:/temp/에펠.jpg"));
		
		long BufferTime = copy(is, os);
		System.out.println("버퍼 사용: " + BufferTime + " ns");
		is.close(); os.close();
		// 버퍼 사용: 9674300 ns 0.009초 100배 차이
	}
	
	static long copy(InputStream is, OutputStream os) throws IOException {
		long startTime = System.nanoTime();
		// 1바이트씩 읽고 쓰기
		while (true) {
			int data = is.read();
			if (data == -1)
				break;
			os.write(data);
		}
		os.flush();
		long endTime = System.nanoTime();
		return endTime - startTime;
	}

}
