package BAEKJOON;

import java.util.Scanner;

public class Q19 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		int sum = 0, dice1 = scan.nextInt(), dice2 = scan.nextInt(), dice3 = scan.nextInt();
		
		if (dice1 == dice2 && dice1 == dice3) {
			sum += 10000 + dice1 * 1000;
		} else if(dice1 == dice2 || dice1 == dice3) {
			sum += 1000 + dice1 * 100;
		} else if(dice2 == dice3) {
			sum += 1000 + dice2 * 100;
		} else if(dice1 > dice2 && dice1 > dice3) {
			sum += dice1 * 100;
		} else if(dice2 > dice1 && dice2 > dice3) {
			sum += dice2 * 100;
		} else {
			sum += dice3 * 100;
		}
		System.out.println(sum);
	}

}
