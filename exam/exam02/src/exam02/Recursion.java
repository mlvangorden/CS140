package exam02;

import java.util.ArrayList;

public class Recursion{
	public static int collatz(int n) {
		if(n == 1) return 1;
		if(n%2 == 0) return n + collatz(n/2);
		return n + collatz((3*n)+1);
	}
	
	public static int count(ArrayList<Integer> list, int n) {
		if(list.size() == 1) {
			if(list.get(0) == n) return 1;
			return 0;
		}
		if(list.get(0) == n) {
			list.remove(0);
			return 1 + count(list, n);
		}
		list.remove(0);
		return count(list, n);
	}
}