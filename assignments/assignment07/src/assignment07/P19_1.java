package assignment07;

//import java.io.PrintWriter;
import java.util.Random;
import java.util.stream.*;

public class P19_1{
	public static void main(String[] args) {
		for(int k = 10; k<100000001; k=k*10) {
			long t1 = System.currentTimeMillis();
			Random generate = new Random();
			LongStream trap = generate.longs(0, k);
			long count = trap.parallel()
					.filter(w -> w%2 != 0)
					.limit(k)
					.count();
			long t2 = System.currentTimeMillis();
			System.out.println(count + ": " + (t2-t1));
		}
	}
}