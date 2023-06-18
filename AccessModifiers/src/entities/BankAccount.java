package entities;

public class BankAccount {
	private int accountNumber;
	private double balance;
	private AccountHolder accountHolder;

	public BankAccount(int accountNumber, double balance, AccountHolder accountHolder) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountHolder = accountHolder;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount, double commission) {
		balance -= amount + commission; 
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", accountHolder="
				+ accountHolder + "]";
	}
	
	

}
