package q1.ex02BankApplication;

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
		String ano = scanner.next();	// 생성할 계좌번호를 ano 란 요소에 입력
		
		System.out.print("계좌주: ");
		String owner = scanner.next();	// 생성할 계좌에 주를 owner 란 요소에 입력

		System.out.print("초기입금액: ");
		int balance = scanner.nextInt();	// 생성할 계좌에 초기 금액을 balance 란 요소에 입력

		accountArray[count++] = new Account(ano, owner, balance);	// count 로 몇번째 계좌인지 순번을 정하고
														// new Account(ano, owner, balance); 위 요소들을 클래스로 생성
		System.out.println("결과: 계좌가 생성되었습니다.");
		scanner.next();
	}

	// 계좌목록보기
	private static void accountList() {
		System.out.println("------");
		System.out.println("계좌목록");
		System.out.println("------");

		for (int i = 0; i <= count; i++) {	// count 가 현재 만들어진 계좌의 갯수이니 그만큼 반복
			System.out.println(accountArray[i].getAno() + " " + accountArray[i].getOwner() + " " + accountArray[i].getBalance());
			
			//  accountArray[i].getAno() getOwner() getBalance() 로 만들어진 계좌의 번호와 예금주 현재 금액을 출력
		}
		
	}

	// 예금하기
	private static void deposit() {
		System.out.println("---");
        System.out.println("예금");
        System.out.println("---");
        
        System.out.println("계좌번호: ");
        String ano = scanner.next();	// 예금할 계좌번호를 ano 란 요소에 저장
        System.out.println("예금액: ");
        int cash = scanner.nextInt();	// 예금할 금액을 cash 란 요소에 저장
        
        int balance = dealAccount(ano).getBalance() + cash;		//dealAccount(ano)란 함수를 생성하여 입력한 ano의 값이랑 맞는지 확인 후 맞으면 그 계좌의 getBalance()을 불러와 cash와 더한다 
        dealAccount(ano).setBalance(balance);	// 다시 ano란 계좌와 동일한지 확인후 setBalance() class에 Balance값을 바꾼다 위에 계산한 balance 값으로
        System.out.println(ano + "계좌에" + cash + "원 입금되어,");
        System.out.println("총" + balance + "원 되었습니다.");
        scanner.next();
        
	}


	// 출금하기
	private static void withdraw() {
		System.out.println("---");
        System.out.println("출금");
        System.out.println("---");
        
        System.out.println("계좌번호: ");
        String ano = scanner.next();	// 출금할 계좌번호를 ano 란 요소에 저장
        System.out.println("출금액: ");
        int cash = scanner.nextInt();	// 출금할 금액을 cash 란 요소에 저장
        	
        int balance = dealAccount(ano).getBalance() - cash;	//dealAccount(ano)란 함수를 생성하여 입력한 ano의 값이랑 맞는지 확인 후 맞으면 그 계좌의 getBalance()을 불러와 cash를 뺀다.
        dealAccount(ano).setBalance(balance);	// 다시 ano란 계좌와 동일한지 확인후 setBalance() class에 Balance값을 바꾼다 위에 계산한 balance 값으로
        System.out.println(ano + "계좌에" + cash + "원 출금하여,");
        System.out.println("총" + balance + "원 되었습니다.");
        scanner.next();
	}
	// 계좌번호를 확인하는 함수 생성
	private static Account dealAccount (String ano) {	//Account 클래스에 dealAccount (String ano) 스트링 ano를 찾는 함수 
		for (int i = 0; i <= count; i++) {	// count는 현재 만들어진 계좌의 갯수만큼 반복한다
			if (accountArray[i].getAno().equals(ano))	// accountArray[i] 몇번째 만들어진 계좌가 .getAno() 현재 만들어진 계좌번호중 .equals(ano) 대입한 ano의 값과 같으면 참
				return accountArray[i];	// 위에 값이 참인 accountArray[i] i번째 계좌를 값을 갖고 이 함수가 시작된곳으로 돌아간다
			else
				System.out.println("없는 계좌입니다.");
		}
		return null ;
	}
	
}
