package BAEKJOON;

import java.util.Scanner;

public class Q23 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int n = scan.nextInt();
		int sum = 0;

		for (int i = 0; i < n; i++) {
			int a = scan.nextInt();
			int b = scan.nextByte();
			sum += a * b;
		}
		if (x == sum) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}