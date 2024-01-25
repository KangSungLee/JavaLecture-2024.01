package ch17_collection.part1_list.sec03_Message_Me;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageServiceListImpl implements MessageService {
	static int index = 0;
	static List<Message> list = new ArrayList<>();

	@Override
	public Message findByMid(int mid) {
		for (Message msg : list) {
			if (msg == null)
				break;
			if (mid == msg.getMid())
				return msg;
		}
		return null;
	}

	@Override
	public List<Message> getMessageListAll() {
		list.forEach(x -> System.out.println(x));	// x: 인풋 ->: 리턴
		return null;
	}

	@Override
	public List<Message> getMessageListByWriter(String writer) {
		for (Message m : list) {
			if (m == null)
				break;
			if (m.getWriter().equals(writer) && m.getIsDeleted() != MessageService.DELERED)
				System.out.println(m);	// != not 낫의 개념
		}
		return null;
	}

	@Override
	public void insertMessage(Message message) {
		message.setMid(1+index++);
		message.setModTime(LocalDateTime.now());
		list.add(message);

	}

	@Override
	public void updateMessage(Message message) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMid() == message.getMid()) {
				list.set(i, message);
				message.setModTime(LocalDateTime.now());
				return;
			}
		}

	}

	@Override
	public void deleteMessage(int mid) {
		Message msg = findByMid(mid);
		if (msg != null)
			list.remove(msg);
	}

}
