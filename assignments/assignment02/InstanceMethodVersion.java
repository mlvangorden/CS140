package assignment02;

public class InstanceMethodVersion{
  private String string;
  public InstanceMethodVersion(String str) {
	string = str;
  }

  public int countSpaces(){
    int count = -1;
    if(string != null){
       count = 0;
       for (int i = 0; i<string.length(); i++){
         if (string.charAt(i) == ' '){
           count++;
         }
       }
    }
    return count;
  }
  // counts the spaces in the field string

  public int countSpaces2(){
    int count = 0;
    if(string != null){
      char[] arr = string.toCharArray();
      for (int i = 0; i<arr.length; i++){
        if (arr[i] == ' '){
          count++;
        }
      }
    }
    return count;
  }
  // counts the spaces in the field string

  public String withoutExtraSpaces(){
    String returnVal = null;
    if(string != null) {
      returnVal = string.trim();
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
   // returns a copy of the field string without the extra spaces

  public String first(){
    String returnVal = null;
    if(string != null) {
    returnVal = string.trim();
    int i = returnVal.indexOf(' ');
      if (i >= 0){
        returnVal = returnVal.substring(0, i);
      }
  }
  return returnVal;
  }
  // returns the first word in the field string

  public String rest(){
    String returnVal = null;
    if(string != null) {
      returnVal = string.trim();
      int i = returnVal.indexOf(' ');
        if (i >= 0){
          returnVal = returnVal.substring(i+1).trim();
        }
      }
    return returnVal;
  }
  // returns the remainder of the field string removing the first word

  public String[] splitOnSpaces(){

    if (string == null){
      return null;
    }
    else{
      InstanceMethodVersion temp = new InstanceMethodVersion(withoutExtraSpaces());
      int len = temp.countSpaces();
      String[] returnVal = null;
      if(len >= 0) {
        if(string.trim().length() == 0){
          return returnVal;
        }
        else{
          returnVal = new String[len+1];
        }
      }
      temp = new InstanceMethodVersion(string.trim());
      for(int i = 0; i<returnVal.length; i++){
        returnVal[i] = temp.first();
        temp = new InstanceMethodVersion(temp.rest());
      }
      return returnVal;
    }

  }
  // returns an array of the words in the field string

  public int[] strLengths(){
    int[] returnVal = null;
    String[] words = splitOnSpaces();
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
  // returns an array of the lengths of the words in the field string
}
