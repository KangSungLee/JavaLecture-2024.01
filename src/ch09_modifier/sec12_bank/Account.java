package ch09_modifier.sec12_bank;

public class Account {
	private String ano;
	private String ower;
	private int balance;
	
	public Account(String ano, String ower, int balance) {
		this.ano = ano;
		this.ower = ower;
		this.balance = balance;
	}
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwer() {
		return ower;
	}
	public void setOwer(String ower) {
		this.ower = ower;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
