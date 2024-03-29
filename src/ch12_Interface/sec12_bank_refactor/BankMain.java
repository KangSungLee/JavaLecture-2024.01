package ch12_Interface.sec12_bank_refactor;

import java.util.Scanner;

public class BankMain {
	private static Scanner scan = new Scanner(System.in);
	private static AccountService accountService = new AccountServiceArrayImpl();
//	private static AccountService accountService = new AccountServiceMySQLImp();
//	private static AccountService accountService = new AccountServiceFileImpl();
// 	@Autowired private static AccountService accountService;	자동변환시킬때

	public static void main(String[] args) {
		boolean run = true;
	
		while (run) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1.계좌생성| 2.계좌목록 | 3.예금 | 4.출금 | 5.삭제 6.종료");
			System.out.println("--------------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scan.nextLine());
			switch (selectNo) {
			case 1:
				accountService.createAccount();
				break;
			case 2:
				accountService.accountList();
				break;
			case 3:
				accountService.deposit();
				break;
			case 4:
				accountService.withdraw();
				break;
			case 5:
				accountService.delete();
				break;
			case 6:
				run = false;
				break;
			default:
				System.out.println("Warning: 1 ~ 6 사이의 숫자만 입력하세요.");
			}
		}
		System.out.println("프로그램 종료");
	}
}