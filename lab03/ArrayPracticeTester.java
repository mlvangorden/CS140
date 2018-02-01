package lab03;
import java.util.Arrays;
import static lab03.ArrayPractice.*;

public class ArrayPracticeTester{
  public static void test(String expected, int[] actual) {
    System.out.println("Expected: " + expected + ", received: " + Arrays.toString(actual));
  }

  public static void test(int[] expected, int[] actual) {
    System.out.println("Expected: " + Arrays.toString(expected) + ", received: " + Arrays.toString(actual));
    }

  public static void test(boolean expected, boolean actual) {
    System.out.println("Expected: " + expected + ", received: " + actual);
  }

  public static void test(String expected, double actual) {
    System.out.println("Expected: " + expected + ", received: " + actual);
  }

  public static void main(String[] args){
    int[] simple = {1, 2, 3, 4, 5, 6};
    int[] reversed = {6, 5, 4, 3, 2, 1};
    test(reversed, reverse(simple));
    test(simple, reverse(reversed));
    test("null", reverse(null));
    test("[]", reverse(new int[0]));
    test(true, isIncreasing(simple));
    test(false, isIncreasing(reversed));
    test(true, isIncreasing(null));
    test(true, isIncreasing(new int[0]));
    test("3.5", average(simple));
    test("0.0", average(new int[0]));
    test("[1, 3, 5]", evenIndicesOnly(simple));
    test("[6, 4, 2]", evenIndicesOnly(reversed));
    test("[]", evenIndicesOnly(new int[0]));
    test("null", evenIndicesOnly(null));
    test("[1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1]", concatenate(simple, reversed));
    test("[]", concatenate(new int[0], new int[0]));
    test("[1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6]", endToEnd(simple, reversed));
    test("[]", endToEnd(new int[0], new int[0]));
    int[] test1 = null;
    reverseInPlace(test1);
    test("null", test1);
    int[] test2 = new int[0];
    reverseInPlace(test2);
    test("[]", test2);
    reverseInPlace(simple);
    test(reversed, simple);

    try {
      concatenate(null, null);
      System.out.println("test failed - exception not thrown");
    }
    catch(IllegalArgumentException e) {
      System.out.println("caught the expected illegal argument exception");
    }
    try {
      endToEnd(null, null);
      System.out.println("test failed - exception not thrown");
    }
    catch(IllegalArgumentException e) {
      System.out.println("caught the expected illegal argument exception");
    }

    try {
      average(null);
      System.out.println("test failed - exception not thrown");
    }
    catch(IllegalArgumentException e) {
      System.out.println("caught the expected illegal argument exception");
    }


  }

}
