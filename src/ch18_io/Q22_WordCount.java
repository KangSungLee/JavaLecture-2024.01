package ch18_io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Q22_WordCount {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("찾을 파일> ");
		String filename = scan.nextLine();
		scan.close();

		grep(filename);

	}

	static void grep(String filename) {
		try {
			InputStream is = new FileInputStream(filename);
			int numSum = 0;
			byte[] arr = new byte[512];
			while (true) {
				int num = is.read(arr);
				if(num == -1)
					break;
				numSum = num;
			}
			String stringValue = new String(arr);
			System.out.println("읽은 바이트 수: " + numSum);
			is.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
