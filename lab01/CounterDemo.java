package lab01;

public class CounterDemo {
	public static void main(String[] arg) {
		Counter tally = new Counter();
		tally.click();
		tally.click();
		int result = tally.getValue();
		System.out.print("result: ");
		System.out.println(result);
	}
}
