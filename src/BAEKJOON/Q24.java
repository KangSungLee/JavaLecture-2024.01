package BAEKJOON;

import java.util.Scanner;

public class Q24 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		String longInt = "long ";
		String longIntSum = "";
		for (int i = 0; i < a/4; i++) {
			longIntSum += longInt;
		}
		System.out.println(longIntSum + "int");
	}

}
