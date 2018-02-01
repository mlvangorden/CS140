package lab03;
import java.util.Arrays;

public class ArrayTester{
	public static void main(String[] args){
		if (args.length == 1){
			ArrayFromFile test = new ArrayFromFile(args[0]);
			System.out.println("Expected result: [20, 8, 13, 46, 7]");
			System.out.println("Result: "+test);
			test.removeOddElements();
			System.out.println("Expected result: [20, 8, 46]");
			System.out.println("Result: "+test);
		}
		else{
			throw new IllegalArgumentException("This program requires exactly one argument.");
		}
		int[] array = new int[5];
		System.out.println(Arrays.toString(array));
		int n = 0;
		for (int i : array) {
    	i = n;
    	n++; // shorthand to increment by 1
		}
		System.out.println(Arrays.toString(array));

		String[] rous = new String[]{"one", "two", "three", "four"};
		for (String i : rous) {
			System.out.print(i+i.length()+" ");
		}
		System.out.println();

	}
}
