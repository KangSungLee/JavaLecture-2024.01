package q1.bankInterpace.copy;

public interface AccountServer {
void createAccount(Account1[] accountArray);
	
	void accountList(Account1[] accountArray);
	
	void deposit(Account1[] accountArray);
	
	void withdraw(Account1[] accountArray);
	
	Account1 findAccount(String ano, Account1[] accountArray);
}