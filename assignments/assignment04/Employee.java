package assignment04;
import java.util.*;

public class Employee{
  private Person guy;
  private double salary;

  public Employee(Person emp){
    guy = emp;
  }

  public void setSalary(double money){
    salary = money;
  }

  public String toString(){
    StringBuilder build = new StringBuilder();
    build.append(guy.getFirst());
    build.append(" ");
    build.append(guy.getMiddle());
    build.append(". ");
    build.append(guy.getLast());
    build.append(", $");
    build.append(salary);
    return build.toString();
  }
}
