package ch18_io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Q22_WordCount {

	public static void main(String[] args) {
		List<Byte> byteList = new ArrayList<>();
		try {
			InputStream is = new FileInputStream("c:/Temp/kakaoApiKey.txt");
			int numSum = 0;
			byte[] arr = new byte[512];
			while (true) {
				int num = is.read(arr);
				if (num == -1)
					break;
				numSum = num;
			}
			for (byte bl: arr) {
				if(bl == 0) {
					break;
					}
				byteList.add(bl);
			}
			
			int twinSum = findTwinSum(byteList);
			System.out.println("겹친 갯수" + twinSum + "고유 갯수" + byteList.size() + "갯수: " + numSum);
				byteList.forEach(x -> System.out.println(x));
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	static int findTwinSum (List<Byte> byteList) {
		int twinSum = 0;		
		for (int i = 0; i < byteList.size(); i++) {
			for (int k = 1; k < byteList.size(); k++) {
				if (byteList.get(i) == byteList.get(k)) {
					byteList.remove(k);
					twinSum++;
				}
			}
		}
		return twinSum;
		
	}
}
