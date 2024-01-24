package ch14_exception.sec99_Message;

import java.util.Scanner;

public class MessageServiceArrayImpl implements MessageService {
	Scanner scan = new Scanner(System.in);
	Message[] messageArray = new Message[100];
	static int index = 5;
	
	public MessageServiceArrayImpl() {
	messageArray[0] = new Message(1,"안녕하세요","이강성","15:00",0);
	messageArray[1] = new Message(2,"안녕하세","선풍기","15:01",0);
	messageArray[2] = new Message(3,"안녕하","에어컨","15:02",0);
	messageArray[3] = new Message(4,"안녕","노트북","15:03",0);
	messageArray[4] = new Message(5,"안","마우스","15:04",0);
	}
	
	@Override
	public void messageList() {
		for (int i = 0; i < index; i++) {
			Message msg = messageArray[i];
			if (msg.getIsDeleted() == MessageService.DELETED) 
				continue;
			System.out.println(msg.getMid() + "번째 메시지: " + msg.getContent() + " 작성자: " + msg.getWriter() + msg.getGenTime());
			}
		
	}

	@Override
	public void messageListByWriter(String writer) {
		for (int i = 0; i < index; i++) {
			Message msg = messageArray[i];
			if (msg.getIsDeleted() == MessageService.DELETED) 
				continue;
			System.out.println(" 작성자: " + msg.getWriter());
		}
		
	}

	@Override
	public void insertMessage(Message message) {
		int mid = index+1;
		System.out.println("메시지 내용> ");
		String content = scan.nextLine();
		System.out.println("작성자> ");
		String writer = scan.nextLine();
		System.out.println("시간> ");
		String genTime = scan.nextLine();
		messageArray[index++] = new Message(mid, content,writer,genTime,0);
	}

	@Override
	public void updateMessage(Message message) {
		System.out.println("몇번째 메시지를 수정하시겠습니까> ");
		int mid = Integer.parseInt(scan.next());
		
		if(mid == findByMid(mid).getMid()) {
			System.out.println(findByMid(mid).getContent());
			System.out.println("수정할 내용을 작성하세요> ");
			String content = scan.next();
			findByMid(mid).setContent(content);
		}
	}

	@Override
	public void deleteMessage(int mid) {
		System.out.println("삭제할 메시지의 번호를 적으세요> ");
		mid = Integer.parseInt(scan.next());
		Message message = findByMid(mid);
		message.setIsDeleted(MessageService.DELETED);
		
	
	}

	@Override
	public Message findByMid(int mid) {
		for (int i = 0; i <= messageArray.length; i++)
			if(mid == messageArray[i].getMid()) {
				return messageArray[i];
			} 
		return null;
	}
}
