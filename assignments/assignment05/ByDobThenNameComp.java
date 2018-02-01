package assignment05;
import java.time.LocalDate;
import java.util.*;

public class ByDobThenNameComp implements Comparator<Person>{

  @Override
  public int compare(Person person1, Person person2){
    if(person1.getDateOfBirth().compareTo(person2.getDateOfBirth()) == 0){
      return person1.getDateOfBirth().compareTo(person2.getDateOfBirth());
    }
    return person1.compareTo(person2);
  }

  public static Comparator<Person> byDOB () {
    return Comparator.comparing(Person::getDateOfBirth);
  }

  public static Comparator<Person> byDOBandName () {
    return byDOB().thenComparing(Comparator.naturalOrder());
  }
}
