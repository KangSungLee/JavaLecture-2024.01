package 연습.ex01balance;

public class Accont {
	private int bankbook;

	public Accont(int bankbook) {
		this.bankbook = bankbook;
	}
	
	public int getBalance() {
		return bankbook;
	}
	
	public void setBalance(int bankbook) {
		this.bankbook += bankbook;
	}
}
