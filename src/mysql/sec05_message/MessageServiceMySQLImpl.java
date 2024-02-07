package mysql.sec05_message;

import java.util.List;

public class MessageServiceMySQLImpl implements MessageService {
	private MessageDao msgDao = new MessageDao(); 	// 종속적(의존적)
	// ==> @Autowired private Message msgDao;		// 의존성 주입

	@Override
	public Message findByMid(int mid) {
		Message m = msgDao.getMessageByMid(mid);
		return m;
	}

	@Override
	public List<Message> getMessageListAll() {
		List<Message> list = msgDao.getMessageListByWriter("%");
		return list;
	}

	@Override
	public List<Message> getMessageListByWriter(String writer) {
		List<Message> list = msgDao.getMessageListByWriter("%" + writer + "%");
		return list;
	}

	@Override
	public void insertMessage(Message message) {
		msgDao.insertMessage(message);
	}

	@Override
	public void updateMessage(Message message) {
		msgDao.updateMessage(message);
	}

	@Override
	public void deleteMessage(int mid) {
		msgDao.deleteMessage(mid);
	}

	@Override
	public void close() {
		msgDao.close();
	}

}
