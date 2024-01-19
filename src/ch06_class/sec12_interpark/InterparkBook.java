package ch06_class.sec12_interpark;

public class InterparkBook {
	private int rank;
	private String title;
	private String author;
	private String translator;
	private String company;
	private int price;
	
	public InterparkBook() { }
	public InterparkBook(int rank, String title, String author, String translator, String company, int price) {
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.company = company;
		this.price = price;
	}
	@Override
	public String toString() {
		return "InterparkBook [rank=" + rank + ", title=" + title + ", author=" + author 
				+ ((translator == null) ? "" : ", translator=" + translator)	// null이면 표시안해줌
				+ ", company=" + company 
				+ ", price=" + String.format("%,d", price) + "]";	// %,d 천단위 ,를 표시해줌
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
