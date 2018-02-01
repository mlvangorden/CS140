package assignment02;
import java.util.Arrays;
import java.util.Optional;

public class Utilities02{

  public static int countNulls(Object[] array){
    int count = 0;
    if (array == null){
      return 0;
    }
    else{
    if (array.length != 0){
      for (int i = 0; i<array.length; i++){
        if (array[i] == null){
          count++;
        }
      }
    }
    return count;
    }
  }

  public static int countSpaces(String str){
    int count = -1;
    if(str != null){
	     count = 0;
       for (int i = 0; i<str.length(); i++){
         if (str.charAt(i) == ' '){
           count++;
         }
       }
    }
    return count;
  }

  public static int countSpaces2(String str){
    int count = 0;
    if(str != null){
      char[] arr = str.toCharArray();
      for (int i = 0; i<arr.length; i++){
        if (arr[i] == ' '){
          count++;
        }
      }
    }
    return count;
  }

  public static String first(String str){
    String returnVal = null;
    if(str != null) {
// set returnVal to str.trim(), which removes all leading and trailing space
// set i to be returnVal.indexOf(' ')
// if i >= 0, meaning there are more than one words in str, change returnVal to
// returnVal.substring(0,i)
    returnVal = str.trim();
    int i = returnVal.indexOf(' ');
      if (i >= 0){
        returnVal = returnVal.substring(0, i);
      }
  }
  return returnVal;
  }

  public static String rest(String str){
    String returnVal = null;
    if(str != null) {
      returnVal = str.trim();
      int i = returnVal.indexOf(' ');
        if (i >= 0){
          returnVal = returnVal.substring(i+1).trim();
        }
      }
    return returnVal;
  }

  public static String withoutExtraSpaces(String str){
    String returnVal = null;
    if(str != null) {
//assign returnVal to str.trim() and the ints len1 and len2 to 0
//in a do { ... } while(len2 < len1);
//execute set len1 to the length of returnVal, change returnVal to returnVal.replace("  ", " ")
//and set len2 to the length of the new returnVal
      returnVal = str.trim();
      int len1 = 1;
      int len2 = 0;
      while(len2 < len1){
        len1 = returnVal.length();
        returnVal = returnVal.replace("  ", " ");
        len2 = returnVal.length();
      }
    }
    return returnVal;
  }

  public static String[] splitOnSpaces(String str){
    if (str == null){
      return null;
    }
    else{
      int len = countSpaces(withoutExtraSpaces(str));
//if len is not 0, len + 1 is exactly the number of words in str
//if len is 0, there is a bit more work--depends if there is one word or no word

      String[] returnVal = null;
      if(len >= 0) {
        if(str.trim().length() == 0){
          return returnVal;
        }
        else{
          returnVal = new String[len+1];
        }

//in the case str.trim() has length 0, the return value is {}, the empty array
//otherwise change returnVal to an array of length len+1
//in a for loop set returnVal[i] to first(str) and change str to rest(str)
      }
      String str1 = str;
      for(int i = 0; i<returnVal.length; i++){
        returnVal[i] = first(str1);
        str1 = rest(str1);
      }
      return returnVal;
    }
  }

  public static int[] strLengths(String str){
    int[] returnVal = null;
    String[] words = splitOnSpaces(str);
    if(words.length == 0){
      return returnVal;
    }
    else{
      returnVal = new int[words.length];
      for(int i = 0; i<words.length; i++){
        returnVal[i] = words[i].length();
      }
      return returnVal;
    }
  }

  public static Optional<String[]> splitOnSpaces1(String str){
    String[] returnVal = null;
    String str1 = str;
    if (str1 != null && str1.trim().length() > 0) {
      returnVal = new String[Utilities02.splitOnSpaces(str1).length];
      int index = 0;
      while(index < returnVal.length){
        returnVal[index] = first(str1);
        str1 = rest(str1);
        index += 1;
      }
      returnVal = java.util.Arrays.copyOf(returnVal, index);

      //set returnVal to be an array of length str.length()
      //introduce index = 0
      // while the length of str in non-zero set returnVal[index] to first(str), set str equal to rest(str)
      // and add 1 to index
      // After the while loop truncate the array using returnVal = Arrays.copyOf(returnVal, index);
    return Optional.of(returnVal);
    }
    else return Optional.empty();
  }

}
