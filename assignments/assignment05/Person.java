package assignment05;
import java.time.LocalDate;
import java.util.*;

public class Person implements Comparable<Person>{
  private String lastName;
  private String firstNames;
  private LocalDate dateOfBirth;

  public Person(String lastName, String firstNames, LocalDate dateOfBirth){
    this.lastName = lastName;
    this.firstNames = firstNames;
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString(){
    return firstNames+" "+lastName+" was born on "+dateOfBirth;
  }

  @Override
  public int compareTo(Person other){
    return (lastName + firstNames).compareToIgnoreCase(other.lastName + other.firstNames);
  }

  public LocalDate getDateOfBirth(){
    return dateOfBirth;
  }

  public static Comparator<Person> byDOB () {
    return Comparator.comparing(Person::getDateOfBirth);
  }
  public static Comparator<Person> byDOBandName () {
    return byDOB().thenComparing(Comparator.naturalOrder());
  }

}
