package assignment07;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.stream.Stream;

public class P19_2{
	public static boolean palindrome(BigInteger n) {
		String pal = ""+n;
		return pal.equals(new StringBuilder(pal).reverse().toString());
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		try (PrintWriter output = new PrintWriter("test3.txt")) {
			Stream.iterate(BigInteger.ONE, n -> BigInteger.ONE.add(n))
					.map(n -> n.multiply(n))
					.filter(P19_2::palindrome)
					.limit(90)
					.forEach(output::println);
		}
	}
}