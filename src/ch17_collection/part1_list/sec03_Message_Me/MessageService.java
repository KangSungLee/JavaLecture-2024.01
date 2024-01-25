package ch17_collection.part1_list.sec03_Message_Me;

import java.util.List;

public interface MessageService {
	int DELERED = 1;
	
	Message findByMid(int mid);
	// mid값 찾기 함수
	
	List<Message> getMessageListAll();
	// 전부다 리스트로 출력

	List<Message> getMessageListByWriter(String writer);
	// writer 값으로 메시지 찾기

	void insertMessage(Message message);
	// 메세지 작성

	void updateMessage(Message message);
	// 메세지 수정

	void deleteMessage(int mid);
	// 메세지 삭제
	
}
