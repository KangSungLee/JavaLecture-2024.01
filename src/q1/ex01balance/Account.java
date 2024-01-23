package 연습.ex01balance;

public class Account {
	private int bankbook;

	public Account(int bankbook) {
		this.bankbook = bankbook;
	}
	
	public int getBalance() {
		return bankbook;
	}
	
	public void setBalance(int bankbook) {
		if(bankbook <= 1000000)
			if(bankbook >= 0)
				this.bankbook = bankbook;
	}
	
}