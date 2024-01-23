package ch14_exception.sec99_Message;

import java.util.Scanner;

public class MessageMain {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		MessageService messageServiceArrayImpl = new MessageServiceArrayImpl();
		Message message = new Message();
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("1.메시지 목록| 2.메시지 작성자 목록 | 3.메시지 작성 | 4.메시지 수정 | 5.메시지 삭제 | 6.프로그램 종료");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scan.nextLine());
			switch (selectNo) {
			case 1:
				System.out.println("--------");
				System.out.println("메시지 목록");
				System.out.println("--------");
				messageServiceArrayImpl.messageList();
				break;
			case 2:
				System.out.println("-------------");
				System.out.println("메시지 작성자 목록");
				System.out.println("-------------");
				String writer = new Message().getWriter();
				messageServiceArrayImpl.messageListByWriter(writer);
				break;
			case 3:
				System.out.println("-------------");
				System.out.println("메시지 작성");
				System.out.println("-------------");
				messageServiceArrayImpl.insertMessage(message);
				break;
			case 4:
				System.out.println("-------------");
				System.out.println("메시지 수정");
				System.out.println("-------------");
				messageServiceArrayImpl.updateMessage(message);
				break;
			case 5:
				System.out.println("-------------");
				System.out.println("메시지 삭제");
				System.out.println("-------------");
				int mid = new Message().getMid();
				messageServiceArrayImpl.deleteMessage(mid);
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
