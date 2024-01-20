package 연습.ex02BankApplication;

import java.util.Scanner;

public class Main {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	private static int count = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.계좌생성| 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");

	}

	// 계좌생성하기
	private static void createAccount() {
		System.out.println("------");
		System.out.println("계좌생성");
		System.out.println("------");

		System.out.print("계좌번호: ");
		String ano = scanner.next();
		
		System.out.print("계좌주: ");
		String owner = scanner.next();

		System.out.print("초기입금액: ");
		int balance = scanner.nextInt();

		accountArray[count++] = new Account(ano, owner, balance);
		
		System.out.println("결과: 계좌가 생성되었습니다.");
	

	}

	// 계좌목록보기
	private static void accountList() {
		System.out.println("------");
		System.out.println("계좌목록");
		System.out.println("------");

		for (int i = 0; i <= count; i++) {
			System.out.println(accountArray[i].getAno() + " " + accountArray[i].getOwner() + " " + accountArray[i].getBalance());
		}
		
	}

	// 예금하기
	private static void deposit() {
		System.out.println("---");
        System.out.println("예금");
        System.out.println("---");
        
        System.out.println("계좌번호: ");
        String ano = scanner.next();
        System.out.println("예금액: ");
        int cash = scanner.nextInt();
        
        int balance = dealAccount(ano).getBalance() + cash;
        dealAccount(ano).setBalance(balance);
        System.out.println(ano + "계좌에" + cash + "원 입금되어,");
        System.out.println("총" + balance + "원 되었습니다.");
        
	}


	// 출금하기
	private static void withdraw() {
		System.out.println("---");
        System.out.println("출금");
        System.out.println("---");
        
        System.out.println("계좌번호: ");
        String ano = scanner.next();
        System.out.println("출금액: ");
        int cash = scanner.nextInt();
        
        int balance = dealAccount(ano).getBalance() - cash;
        dealAccount(ano).setBalance(balance);
        System.out.println(ano + "계좌에" + cash + "원 출금하여,");
        System.out.println("총" + balance + "원 되었습니다.");

	}
	private static Account dealAccount (String ano) {
		for (int i = 0; i <= count; i++) {
			if (accountArray[i].getAno().equals(ano))
				return accountArray[i];
			else
				System.out.println("없는 계좌입니다.");
		}
		return null ;
	}
	
}
