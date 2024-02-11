package BAEKJOON;

import java.util.Scanner;

public class Q20 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ggd = scan.nextInt();
		for (int i = 1; i <= 9 ; i++) {
			System.out.println(ggd + " * " + i + " = " + ggd * i);
		}

	}

}
