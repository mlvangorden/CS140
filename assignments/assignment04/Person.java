package assignment04;

public class Person {

  private String first;
  private String last;
  private char middle;

  public Person(String firstName, String lastName, char middleInitial) {
    first = firstName;
    last = lastName;
    middle = middleInitial;
  }

  public String getFirst() {
    return first;
  }
  public String getLast() {
    return last;
  }
  public char getMiddle() {
    return middle;
  }
}
