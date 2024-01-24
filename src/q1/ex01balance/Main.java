package q1.ex01balance;

import java.util.Scanner;

import ch06_class.sec04_tmoney.Tmoney;

public class Main {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("입출금액>" );
//		int cash = scan.nextInt();
//		scan.close();
		
		Account account = new Account(0);
		
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(2000000);
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(300000);
		System.out.println("현재 잔고: " + account.getBalance());
	}

}
