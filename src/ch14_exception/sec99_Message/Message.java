package ch14_exception.sec99_Message;

public class Message {
	private int mid; 
	private String content;   
	private String writer;
	private String genTime;
	private int isDeleted;
	
	public Message() { }
	public Message(int mid, String content, String writer, String genTime, int isDeleted) {
		super();
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
	public String getGenTime() {
		return genTime;
	}
	public void setGenTime(String genTime) {
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
		return "Message [mid=" + mid + ", content=" + content + ", writer=" + writer + ", genTime=" + genTime
				+ ", isDeleted=" + isDeleted + "]";
	}
	
	
}
