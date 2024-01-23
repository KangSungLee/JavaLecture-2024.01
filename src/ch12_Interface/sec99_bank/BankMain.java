package ch12_Interface.sec99_bank;

import java.util.Scanner;

public class BankMain {
	private static Account[] accountArray = new Account[100];
	private static Scanner scan = new Scanner(System.in);
	private static AccountService as = new AccountSerbice();
	

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.계좌생성| 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scan.nextLine());
			switch (selectNo) {
			case 1:
				as.createAccount(accountArray);
				break;
			case 2:
				as.accountList(accountArray);
				break;
			case 3:
				as.deposit(accountArray);
				break;
			case 4:
				as.withdraw(accountArray);
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("Warning: 1 ~ 5 사이의 숫자만 입력하세요.");
			}
		}
		System.out.println("프로그램 종료");
	}
}