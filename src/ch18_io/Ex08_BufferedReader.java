package ch18_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class Ex08_BufferedReader {	
	// 버퍼드 중요 *****
	public static void main(String[] args) throws Exception {
		// 줄 단위로 읽을 수 있음
		BufferedReader br = new BufferedReader(new FileReader("c:/temp/README.txt"));
		
		int linewNo = 1;
		while (true) {
			String line = br.readLine();
			if(line == null)
				break;
			System.out.println(linewNo + ": " + line);
			linewNo++;
		}
		br.close();
	}

}
