package q1.Ex03Bank;

public class Account1 {
		private String ano;
		private String owner;
		private int balance;
		
		
		public Account1() { }
		public Account1(String ano, String owner, int balance) {
			super();
			this.ano = ano;
			this.owner = owner;
			this.balance = balance;
			
		}
		


		public String getAno() {
			return ano;
		}
		public void setAno(String ano) {
			this.ano = ano;
		}
		public String getOwner() {
			return owner;
		}
		public void setOwner(String owner) {
			this.owner = owner;
		}
		public int getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}
		
		
		@Override
		public String toString() {
			return "Account1 [계좌번호" + ano + ", 예금주" + owner + ", 통장잔액=" + balance + "]";
		}
		
	}

