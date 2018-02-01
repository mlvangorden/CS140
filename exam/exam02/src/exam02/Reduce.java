package exam02;

import java.util.ArrayList;

public class Reduce {
	
	public static int reduce(ArrayList<Integer> list, int baseVal, BinaryFunction func) {
		int retVal = baseVal;
		for(int el : list) {
			retVal = func.apply(retVal, el);
		}
		return retVal;
	}
}
