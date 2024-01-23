package q1;

public class String_연습문제_240117 {

	public static void main(String[] args) {
		// 1. 1에서 1000사이에 0은 몇번, 1은 몇번, ..., 9는 몇번 사용되었는가?
		String numStr = "";
		for (int i = 1; i <= 1000; i++) {
			numStr += i;
		}
		for (int k = 0; k <= 9; k++) {
			int count = numStr.length() - numStr.replace(Integer.toString(k), "").length();
			System.out.println(k + "의 갯수" + count);
		}
		// 2. 디지털 시계, 00:00 ~ 23:59
		// 하루동안 3이 표시되는 시간은 몇초인가?
		int totalSec = 0;
		for (int h = 0; h < 24; h++) {
			for (int m = 0; m < 60; m++) {
				if (h % 10 == 3 || Math.floor(m / 10) == 3 || m % 10 == 3) {

					totalSec += 60;
				}
			}
		}
		System.out.println("3이 표시된 초는" + totalSec);
		// 3. 두개의 세자리수를 곱해서 나온 결과가 palindrome일때
		// 가장 큰 palinderome 수와 어떤 수를 곱해서 나온 결과인가?
		int maxPal = 0, max1 = 0, max2 = 0;
		for (int i = 100; i <= 999; i++) {
			for (int k = i; k <= 999; k++) {
				int mul = i * k;
				if (printMines(Integer.toString(mul))) {
					if (mul > maxPal) {
						maxPal = mul;
						max1 = i;
						max2 = k;
					}
				}
			}
		}
		System.out.println(max1 + "x" + max2 + "=" + maxPal);

		// 4. C:/Workspace/WebProject/03.JavaScript/ch07.표준내장객체/04.String연습.js
		// 에서 파일명(04.String연습.js)만 출력하세요.
		String path = "C:/Workspace/WebProject/03.JavaScript/ch07.표준내장객체/04.String연습.js";

		int fileIndex = path.lastIndexOf("/");
		System.out.println(path.substring(fileIndex + 1));
	}

	static boolean printMines(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}
}