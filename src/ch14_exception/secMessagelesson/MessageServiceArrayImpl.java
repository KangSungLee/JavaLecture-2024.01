package ch14_exception.secMessagelesson;


import java.time.LocalDateTime;
import java.util.Scanner;


public class MessageServiceArrayImpl implements MessageService{
	Scanner scan = new Scanner(System.in);
	Message[] messageArray = new Message[100];
	static int index = 0;
	
	public MessageServiceArrayImpl() {
		messageArray[index++] = new Message(1,"안녕하세요","이강성", LocalDateTime.now());
		messageArray[index++] = new Message(2,"안녕하세","선풍기", LocalDateTime.now());
		messageArray[index++] = new Message(3,"안녕하","에어컨", LocalDateTime.now());
		messageArray[index++] = new Message(4,"안녕","노트북", LocalDateTime.now());
		messageArray[index++] = new Message(5,"안","마우스", LocalDateTime.now());
		}


	@Override
	public void messageList() {
		for(Message msg: messageArray) {
			if(msg == null)
				break;
			if(msg.getIsDeleted() != MessageService.DELETED)
				System.out.println(msg);
		}
		
	}

	@Override
	public void messageListByWriter(String writer) {
		for(Message msg: messageArray) {
			if(msg == null)
				break;
			if(msg.getWriter().equals(writer) && msg.getIsDeleted() != MessageService.DELETED)
				System.out.println(msg);
		}
		
	}

	@Override
	public void insertMessage(Message message) {
		int mid = 1 + index;
		message.setMid(mid);
		message.setGenTime(LocalDateTime.now());
		messageArray[index++] = message;
		
	}

	@Override
	public void updateMessage(Message message) {
		for (int i = 0; i <messageArray.length; i++) {
			if (messageArray[i] == null)
				break;
			if (messageArray[i].getMid() == message.getMid()) {
				messageArray[i] = message;
				return;
			}
		}
		
	}

	@Override
	public void deleteMessage(int mid) {
		Message msg = findByMid(mid);
		if (msg != null)
			msg.setIsDeleted(MessageService.DELETED);
		
	}
	@Override
	public  Message findByMid(int mid) {
		for (Message msg: messageArray) {
			if (msg == null)
				break;
			if (mid == msg.getMid())
				return msg;
		}
		return null;
	}

	
}
