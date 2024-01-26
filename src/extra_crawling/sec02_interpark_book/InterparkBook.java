package extra_crawling.sec02_interpark_book;

public class InterparkBook {
	private int rank;
	private String title;
	private String autor;
	private String company;
	private int price;
	
	public InterparkBook() { }
	public InterparkBook(int rank, String title, String autor, String company, int price) {
		this.rank = rank;
		this.title = title;
		this.autor = autor;
		this.company = company;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("%2d %s | %s | %s | %,d", rank, title, autor, company, price);
//		return "InterparkBook [rank=" + rank + ", title=" + title + ", autor=" + autor + ", company=" + company
//				+ ", price=" + price + "]";
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
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
