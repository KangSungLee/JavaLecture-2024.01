package ch18_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex04_Copy {

	public static void main(String[] args) throws Exception {
		String srcFile = "c:/temp/cat.jpg", dstFile = "c:/temp/고양이.jpg";
		InputStream is = new FileInputStream(srcFile);
		OutputStream os = new FileOutputStream(dstFile);

		byte[] buffer = new byte[1024]; // 1키로바이트
		while (true) {
			int num = is.read(buffer);
			if (num == -1)
				break;
			os.write(buffer, 0, num);
		}
		os.flush(); os.close(); is.close();
		System.out.println("Copy is done!");
	}

}
