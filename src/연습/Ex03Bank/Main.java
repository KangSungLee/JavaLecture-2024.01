package 연습.Ex03Bank;

import java.util.Scanner;

import 연습.ex02BankApplication.Account;

public class Main {
	private static Account1[] accountArray = new Account1[100];
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
	System.out.println("-----");
	System.out.println("계좌생성");
	System.out.println("-----");
	
	System.out.println("계좌번호");
	String ano = scanner.next();
	
	System.out.println("예금주");
	String owner = scanner.next();
	
	System.out.println("초기금액");
	int balance = scanner.nextInt();
	
	accountArray[count++] = new Account1(ano, owner, balance);
	System.out.println("계좌가 생성되었습니다.");
	scanner.next();
	}

	// 계좌목록보기
	private static void accountList() {
		System.out.println("-----");
		System.out.println("계좌목록");
		System.out.println("-----");
		
		for (int i = 0; i <= count; i++) {
			System.out.println(accountArray[i].getAno() +" "+ accountArray[i].getOwner()+" "+accountArray[i].getBalance());
			scanner.next();
			return;
		}
		
	}

	// 예금하기
	private static void deposit() {
		
        
	}


	// 출금하기
	private static void withdraw() {
		
	}
	// 계좌번호를 확인하는 함수 생성
		
}
