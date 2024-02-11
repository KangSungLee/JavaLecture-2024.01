package BAEKJOON;

import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int hour = scan.nextInt(), min = scan.nextInt();
		if (min < 45) {
			hour -= 1;
			min = min - 45 + 60;
			if (hour < 0) {
				hour = 23;
			}
		} else {
			min = min - 45;
		}
		System.out.println(hour + " " + min);
	}

}
