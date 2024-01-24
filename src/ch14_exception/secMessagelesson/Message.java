package ch14_exception.secMessagelesson;

import java.time.LocalDateTime;

public class Message {
	private int mid; 
	private String content;   
	private String writer;
	private LocalDateTime genTime;	// LocalDateTime 현재시간?
	private int isDeleted;
	
	public Message() { }
	// for Insert
	public Message(String content, String writer) {
		super();
		this.content = content;
		this.writer = writer;
	}
	// for Update
	public Message(int mid, String content, String writer) {
		super();
		this.mid = mid;
		this.content = content;
		this.writer = writer;
	}
	// for Read
	public Message(int mid, String content, String writer, LocalDateTime genTime) {
		super();
		this.mid = mid;
		this.content = content;
		this.writer = writer;
		this.genTime = genTime;
	}
	// 관리용?
	public Message(int mid, String content, String writer, LocalDateTime genTime, int isDeleted) {
		this.mid = mid;
		this.content = content;
		this.writer = writer;
		this.genTime = genTime;
		this.isDeleted = isDeleted;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public LocalDateTime getGenTime() {
		return genTime;
	}

	public void setGenTime(LocalDateTime genTime) {
		this.genTime = genTime;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return String.format("%d %s %s %s", mid, content, writer, 
				genTime.toString().replaceAll("T", " ").substring(0, 16));
//		return "Message [mid=" + mid + ", content=" + content + ", writer=" + writer + ", genTime=" + genTime
//				+ ", isDeleted=" + isDeleted + "]";
	}
		
	
}
