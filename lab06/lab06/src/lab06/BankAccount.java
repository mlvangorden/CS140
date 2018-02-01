package lab06;

public class BankAccount{
	private double balance;
	private int idNum;
	private static int numAccounts = 0;
	
	public BankAccount(double balance){
		if(balance <= 0){
			throw new IllegalArgumentException("Balance cannot be negative");
		}
		this.balance = balance;
		idNum = numAccounts;
		numAccounts++;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public int getIdNum(){
		return idNum;
	}
	
	static void reset(){
		numAccounts = 0;
	}
	
	@Override
	public String toString() {
    	StringBuilder build = new StringBuilder();
    	build.append("Acct. #");
    	build.append(idNum);
    	build.append(" has $");
    	build.append(balance);
    	return build.toString();
	}
	
	public void deposit(double amount){
		balance += amount;
	}
	
	public double withdraw(double amount){
		if(amount > balance){
			double retVal = balance;
			balance = 0;
			return retVal;
		}
		balance -= amount;
		return amount;
	}
}