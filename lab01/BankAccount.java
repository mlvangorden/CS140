package lab01;

public class BankAccount {
	private double balance;
	private final double MIN_BALANCE = 25.0;
	public BankAccount() {
		balance = 0;
	}
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	public void deposit(double amount) {
		balance = balance + amount;
	}
	public double withdraw(double amount) {
		double returnAmount = 0.0;
		if(amount + MIN_BALANCE <= balance) {
			balance = balance - amount;
			returnAmount = amount;
		}
		return returnAmount;
	}
	public double getBalance() {
		return balance;
	}
}
