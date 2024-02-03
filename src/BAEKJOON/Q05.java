package BAEKJOON;

import java.util.Scanner;

public class Q05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt(), B = scan.nextInt();
		int sum = A + B, sub = A-B, mul = A*B, div = A/B, per = A%B;
		System.out.println(sum + " " + sub + " " + mul + " " + div + " " + per);
	}
}