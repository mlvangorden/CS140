package assignment07;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.LongStream;

public class P19_3{
	public static boolean palindrome(long n) {
		String pal = ""+n;
		return pal.equals(new StringBuilder(pal).reverse().toString());
	}
	
	public static boolean prime(long n) {
		if(n<2) return false;
		if(n%2 == 0) return false;
		if(n%3 == 0) return false;
		long k = 1;
		while(n >= (6*k-1)*(6*k-1)) {
			if(n%(6*k-1) == 0) return false;
			if(n%(6*k+1) == 0) return false;
			k++;
		}
		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		try (PrintWriter output = new PrintWriter("test4.txt")) {
			LongStream.iterate(1, n -> n+1)
				.filter(P19_3::prime)
				.filter(P19_3::palindrome)
				.limit(500)
				.forEach(output::println);
		}
	}
}