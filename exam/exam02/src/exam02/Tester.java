package exam02;

import java.util.Arrays;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class Tester {
	private static final double DELTA = 1e-6;
	
    @Test
    public void testCollatz() {
    	//288 = 7 + 22 + 11 + 34 + 17 + 52 + 26 + 13 + 40 
	// + 20 + 10 + 5 + 16 + 8 + 4 + 2 + 1
        assertEquals(288, Recursion.collatz(7));
    }

    @Test
    public void testCount() {
        assertEquals(5,
                     Recursion.count(new ArrayList<>(Arrays.asList(3, 10, 2, 3,
                                                                        4, 1, 3, 5, 3, 11, 6, 3)), 3));
    }

    @Test
    public void testFunctions() {
        Sum sum = new Sum();
        assertEquals(30, sum.apply(10, 20));
        Modulo mod = new Modulo(4);
        //(10 + 20) % 4 = 30 % 4 = 2
        assertEquals(2, mod.apply(10,20));
        Multiply mul = new Multiply();
        assertEquals(-21, mul.apply(-3, 7));
    }

    @Test
    public void testReduce() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 2, 3,
                4, 1, 6, 11, 6));
        //base value for multiplication is 1
        //1*10*2*3*4*1*6*11*6 = 95040
        assertEquals(95040, Reduce.reduce(list, 1, new Multiply()));
        //base value for addition is 0
        //0+10+2+3+4+1+6+11+6 = 43
        assertEquals(43, Reduce.reduce(list, 0, new Sum()));
        //base value for modulo is 0
        //43 % 6 = 1
        assertEquals(1, Reduce.reduce(list, 0, new Modulo(6)));
    }
    
    @Test
	public void testQ3() {
        double[] nums = {3, 2.5, 1, -4, 8};
        Summer s = new Summer(nums);
        assertEquals(10.5, s.measure(), DELTA);
        assertEquals(5, s.value());
        Averager a = new Averager(nums);
        assertEquals(2.1, a.measure(), DELTA);
    }
}