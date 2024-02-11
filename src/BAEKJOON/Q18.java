package BAEKJOON;

import java.util.Scanner;

public class Q18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int hour = scan.nextInt(), min = scan.nextInt(), kTime = scan.nextInt();
		if (min + kTime >= 60) {
			int num = (min + kTime) / 60;
			hour += num;
			min += kTime - 60 * num;
			if (hour >= 24) {
				hour -= 24;
			}
		} else {
			min += kTime;
		}
		System.out.println(hour + " " + min);
		
	}

}
