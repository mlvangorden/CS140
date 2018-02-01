package lab03;

public class ArrayPractice{
  /**
 * Determines the average of the elements in a given array.
 * @param array the array to inspect
 * @return 0 if the array is empty
 *         the average otherwise
 * @throws IllegalArgumentException if array is null
 */
public static double average(int[] array) {
  if(array == null){
    throw new IllegalArgumentException("You cannot pass a null array.");
  }
  if(array.length == 0){
      return 0;
  }
  else{
    int total = 0;
    for (int i = 0; i<array.length; i++){
      total += array[i];
    }
    return total/array.length;
  }
}

/**
 * Computes an array which only contains the elements stored at even indices of
 * a given array.
 * e.g. evenIndicesOnly({1,2,4,8,16}) should return {1,4,16},
 * the integers at zeroth, second, and fourth indices
 * @param array the array to extract all odd elements from
 * @return the empty array if the array is empty
 *         the null array if the array is null
 *         otherwise an array holding the elements located at even indices of the given
 *         array
 */
public static int[] evenIndicesOnly(int[] array) {
  if(array == null){
    return null;
  }
  if(array.length == 0){
    return array;
  }
  else{
    int count = 0;
    for(int i = 0; i<array.length; i++){
      if (i%2 == 0){
        count++;
      }
    }
    int[] evenArray = new int[count];
    int j = 0;
    for(int i = 0; i<array.length; i++){
      if(i%2 == 0){
        evenArray[j] = array[i];
        j++;
      }
    }
    return evenArray;
  }
}

/**
 * Determines if an array's elements are in strictly increasing order.
 * The array {1, 2, 3, 4, 5} is in increasing order while
 * the array {1, 2, 2, 4, 5} is not in increasing order as 2 == 2.
 * A null or empty array is by default in increasing order.
 * @param array the array to inspect
 * @return true  if the array's elements are in increasing order,
 *               or the array is null or empty
 *         false otherwise
 */
public static boolean isIncreasing(int[] array) {
  if (array == null || array.length == 0){
    return true;
  }
  else{
    boolean increase = true;
    for(int i = 1; i<array.length; i++){
      if(increase){
        if(array[i]<=array[i-1]){
          increase = false;
        }
      }
    }
    return increase;
  }
}

/**
 * Computes the reverse an array.
 * The reverse of a null array is null.
 * The reverse of an empty array is the empty array.
 * Do NOT use reverseInPlace in the implementation of reverse
 * @param array the array whose elements are to be reversed
 * @return an array holding the contents of array in reverse order
 */
public static int[] reverse(int[] array) {
  if(array == null){
    return null;
  }
  if(array.length == 0){
    return array;
  }
  else{
    int[] rev = new int[array.length];
    int j = array.length-1;
    for (int i = 0; i<array.length; i++){
      rev[i] = array[j];
      j --;
    }
    return rev;
  }
}

/**
 * Computes an array that is all the elements of arr1 in the order they appear,
 * followed by the elements of arr2 in the order they appear.
 * An empty array should contribute no elements to the concatenated
 * array.
 * e.g. concatenate({6, 3, 8}, {10, 1, 7}) should return {6, 3, 8, 10, 1, 7}
 * @param arr1 the first array
 * @param arr2 the second array
 * @return an array that is all the elements of arr1 in order,
 *         followed by the elements of arr2 in order.
 * @throws IllegalArgumentException if arr1 or arr2 is null
 */
public static int[] concatenate(int[] arr1, int[] arr2) {
  if(arr1 == null || arr2 == null){
    throw new IllegalArgumentException("Neither of the arrays passed may be null.");
  }
  int[] conArray = new int[arr1.length+arr2.length];
  for(int i = 0; i<arr1.length; i++){
    conArray[i] = arr1[i];
  }
  int j = 0;
  for(int i = arr1.length; i<conArray.length; i++){
    conArray[i] = arr2[j];
    j++;
  }
  return conArray;
}

/**
 * Computes an array that is all the elements of arr1 in the order they appear,
 * followed by the elements of arr2 in the reverse order they appear
 * An empty array should contribute no elements to the resulting
 * array.
 * e.g. endToEnd({6, 3, 8}, {10, 1, 7}) should return {6, 3, 8, 7, 1, 10}
 * HINT: this method can use other methods in this class to assist it.
 *       ideally, this method is one short line of code.
 * @param arr1 the first array
 * @param arr2 the second array
 * @return an array that is all the elements of arr1 in order,
 * followed by the elements of arr2 in reverse order
 * @throws IllegalArgumentException if arr1 or arr2 is null
 */
public static int[] endToEnd(int[] arr1, int[] arr2) {
  return concatenate(arr1, reverse(arr2));
}

/**
 * Reverses the given array in-place.
 * Zero credit if another array is made.
 * The reverse of a null array is null.
 * The reverse of an empty array is the empty array.
 * Do NOT use reverse in the implementation of reverseInPlace
 * HINT: since we cannot make another array, we will have to swap certain
 *       elements one-by-one.
 * @param array the array to reverse
 */
public static void reverseInPlace(int[] array) {
  if(array == null || array.length == 0){
  }
  else{
      for(int i = 0; i<array.length/2; i++){
        int hold = array[i];
        array[i] = array[array.length-i-1];
        array[array.length-i-1] = hold;
      }
  }
}
}
