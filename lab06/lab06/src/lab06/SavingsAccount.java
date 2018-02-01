package lab06;

public class SavingsAccount extends BankAccount{
	private double rate;
	
	public SavingsAccount(double balance, double rate){
		super(balance);
		this.rate = rate;
	}
	
	@Override
	public void deposit(double amount){
		super.deposit(amount+(rate*amount));
	}

	public double getRate(){
		return rate;
	}
	
	@Override
	public String toString(){
		StringBuilder build = new StringBuilder();
		build.append(super.toString());
		build.append(" @ ");
		build.append(rate);
		build.append("%");
		return build.toString();
	}
}