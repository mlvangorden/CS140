package lab06;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankTester {
	ArrayList<BankAccount> accounts = new ArrayList<>();
	ArrayList<Object> objects = new ArrayList<>();
	//we can initialize some objects to be used in later tests
	//using the Before keyword ensures this method is called before
	//the test methods are called

	//Please note that this method is rerun before the start of each test,
	//which means the BankAccounts will have their numId's increased
	//each time the account is called.

	//we will fix this issue by adding an @After method, which is run
	//after each test ends
	@Before
	public void initialize(){
		BankAccount test1 = new BankAccount(500.00);
		BankAccount test2 = new SavingsAccount(600.00, .12);
		BankAccount test3 = new CheckingAccount(700.00, 20);
		BankAccount test4 = new BankAccount(750.00);
		BankAccount test5 = new SavingsAccount(800.00, .20);
		BankAccount test6 = new CheckingAccount(400.00, 12);
		accounts.add(test1);
		accounts.add(test2);
		accounts.add(test3);
		accounts.add(test4);
		accounts.add(test5);
		accounts.add(test6);

		objects.add(";-P");
		objects.add(27);
		objects.add(test5);
		objects.add("");
		objects.add(false);
		objects.add(1.23456789);
		objects.add(accounts);


		boolean[] arr = new boolean[5];
		arr[0] = true;
		arr[1] = false;
		arr[2] = true;
		arr[3] = false;
		arr[4] = false;
		objects.add(arr);
	}

	@After
	public void resetIdNum(){
		BankAccount.reset();
		if(accounts != null)accounts.clear();
	}


	//the @Test is necessary, without it the test will not be run
	@Test
	public void testBankAccDeposit() {
		BankAccount bacc = new BankAccount(700.00);
		bacc.deposit(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see
			//if the expected and actual value are close enough to equaling one another
			assertEquals(800.00, bacc.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it
		//and print the error message out, then throw the AssertionError
		//so that the test still fails.
		catch(AssertionError e){
			System.out.println("BankAccount's deposit() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	public void testCheckingAccWithdraw(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see
			//if the expected and actual value are close enough to equaling one another
			assertEquals(700.00, checking.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it
		//and print the error message out, then throw the AssertionError
		//so that the test still fails.
		catch(AssertionError e){
			System.out.println("CheckingAccount's withdraw() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	public void testCheckingAccGetWithdrawCount(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two integers, we don't need a third argument
			//since ints can be checked for equality
			assertEquals(3, checking.getWithdrawCount());
		}
		//here if there is an assertion error, we can catch it
		//and print the error message out, then throw the AssertionError
		//so that the test still fails.
		catch(AssertionError e){
			System.out.println("CheckingAccount's getWithdrawCount() method failed: " + e.getMessage());
			System.out.println("Make sure you adjust the withdrawCount in your CheckingAccount's withdraw() method!");
			throw e;
		}
	}

	@Test
	public void testBankAccWithdraw(){
		BankAccount qwerty = new BankAccount(500.00);
		qwerty.withdraw(400.00);
		assertEquals(100.00, qwerty.getBalance(), 1e-6);
	}

	@Test
	public void testSavingsAcctDeposit(){
		SavingsAccount bop = new SavingsAccount(1000.00, 0.1);
		bop.deposit(10.00);
		assertEquals(1011.00, bop.getBalance(), 1e-6);
	}

	@Test
	public void testBankAccWithdrawOverload(){
		BankAccount trip = new BankAccount(20.00);
		assertEquals(20.00, trip.withdraw(1000.00), 1e-6);
	}

	@Test
	public void testCheckingAccWithdrawOverload(){
		CheckingAccount skull = new CheckingAccount(1000.00, 3);
		for(int i = 0; i<5; i++) skull.withdraw(100.00);
		assertEquals(0, skull.withdraw(100.00), 1e-6);
	}
	//TODO: Add some of your own additional tests. Keep each test in a separate test function.
	//This isolates testing a single method or case to a single testing method. Otherwise,
	//if you try to do too much testing in one tester method, you could throw an error
	//for a test and never find the errors of the other tests you put in that method.
	@Test
	public void dynamicDispatchPrinting(){
		System.out.println(accounts);
		System.out.println(objects);
	}

	@Test
	public void testingDepositBehavior() {
		for(BankAccount element : accounts) {
			element.deposit(10.00);
		}
		assertEquals(accounts.get(0).getBalance(), 510.00);
		assertEquals(accounts.get(1).getBalance(), 611.20);
		assertEquals(accounts.get(2).getBalance(), 710.00);
		assertEquals(accounts.get(3).getBalance(), 760.00);
		assertEquals(accounts.get(4).getBalance(), 812.00);
		assertEquals(accounts.get(5).getBalance(), 410.00);
	}
	
	@Test
	public void testingWithdrawBehavior(){
		for(int i = 0; i < 15; i++){
			for(int j = 0; j<accounts.size(); j++){
				accounts.get(j).withdraw(10.00);
			}
			System.out.println(accounts);
		}
	}

}
