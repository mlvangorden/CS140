package lab06;

public class CheckingAccount extends BankAccount{
	private int withdrawLimit;
	private int withdrawCount = 0;
	
	public CheckingAccount(double balance, int limit){
		super(balance);
		withdrawLimit = limit;
	}
	
	public int getWithdrawLimit(){
		return withdrawLimit;
	}
	
	public int getWithdrawCount(){
		return withdrawCount;
	}
	
	@Override
	public String toString(){
		StringBuilder build = new StringBuilder();
		build.append(super.toString());
		build.append(" (");
		build.append(withdrawCount);
		build.append("/");
		build.append(withdrawLimit);
		build.append(")");
		return build.toString();
	}
	
	@Override
	public double withdraw(double amount){
		if(withdrawCount<withdrawLimit){
			withdrawCount++;			
			super.withdraw(amount);
		}
		return 0;
	}
}