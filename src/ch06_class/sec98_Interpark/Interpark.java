package ch06_class.sec98_Interpark;

public class Interpark {
	private int rank;
	private String title;	
	private String author;	
	private String translator;
	private String company;
	private int price;
	
	
	public Interpark() { }
	public Interpark(int rank, String title, String author, String translator, String company, int price) {
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.company = company;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Interpark [rank=" + rank + ", title=" + title + ", author=" + author + ", translator=" + translator
				+ ", company=" + company + ", price=" + price + "]";
	}
	
	
	
}
