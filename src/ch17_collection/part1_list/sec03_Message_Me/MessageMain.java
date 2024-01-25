package ch17_collection.part1_list.sec03_Message_Me;

import java.util.Scanner;

public class MessageMain {
	private static MessageService messageService = new MessageServiceListImpl();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String witer = null, content = null;
		Message message = new Message();
		int mid = 0;
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println("1.메시지 목록| 2.작성자 메시지 찾기 | 3.메시지 작성 | 4.메시지 수정 | 5.메시지 삭제 | 6.프로그램 종료");
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.print("선택> ");
			int selectNo = Integer.parseInt(scan.nextLine());
			switch (selectNo) {
			case 1:
				System.out.println("--------");
				System.out.println("메시지 목록");
				System.out.println("--------");
				messageService.getMessageListAll();
				break;
			case 2:
				System.out.println("작성자> ");
				String writer = scan.nextLine();
				messageService.getMessageListByWriter(writer);
				break;
			case 3:
				System.out.println("작성자> ");
				writer = scan.nextLine();
				System.out.println("메시지 내용> ");
				content = scan.nextLine();
				message = new Message(content, writer);
				messageService.insertMessage(message);
				break;
			case 4:
				System.out.println("--------");
				System.out.println("메시지 수정");
				System.out.println("--------");
				System.out.println("몇번째 메시지> ");
				mid = Integer.parseInt(scan.nextLine());
				message = messageService.findByMid(mid);
				System.out.print("작성자 이름(" + message.getWriter() + ")> ");
				writer = scan.nextLine();
				System.out.print("메세지 내용(" + message.getContent() + ")> ");
				content = scan.nextLine();
				message.setWriter(writer);
				message.setContent(content);
				messageService.updateMessage(message);
				break;
			case 5:
				System.out.println("몇번째 메시지> ");
				mid = Integer.parseInt(scan.nextLine());
				messageService.deleteMessage(mid);
				break;
			case 6:
				run = false;
				break;
			default:
				System.out.println("Warning: 1 ~ 6 사이의 숫자만 입력하세요.");
			}
		}
		System.out.println("프로그램 종료");
		scan.close();
	}

}