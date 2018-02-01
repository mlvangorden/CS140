package assignment04;
import java.util.*;

public class Test{
  public static void main(String[] args){
    //testing manager with team of 2
    Person manA = new Person("Jim", "Hawkins", 'T');
    Person empA1 = new Person("Sally", "Miller", 'H');
    Person empA2 = new Person("Greg", "Fuller", 'P');
    Manager manX = new Manager(manA);
    Employee empX1 = new Employee(empA1);
    Employee empX2 = new Employee(empA2);
    manX.setDepartment("Business Administration");
    manX.setSalary(7500.00);
    empX1.setSalary(6000.00);
    empX2.setSalary(5500.00);
    manX.addToTeam(empX1);
    manX.addToTeam(empX2);
    System.out.println(manX);

    //testing manager with team of 3
    Person manB = new Person("Lauren", "Bailey", 'M');
    Person empB1 = new Person("Robert", "Smith", 'B');
    Person empB2 = new Person("Victor", "Grey", 'C');
    Person empB3 = new Person("Angela", "Van Dyke", 'F');
    Manager manY = new Manager(manB);
    Employee empY1 = new Employee(empB1);
    Employee empY2 = new Employee(empB2);
    Employee empY3 = new Employee(empB3);
    manY.setDepartment("Accounting");
    manY.setSalary(12000.00);
    empY1.setSalary(8000.00);
    empY2.setSalary(6666.66);
    empY3.setSalary(4500.00);
    manY.addToTeam(empY1);
    manY.addToTeam(empY2);
    manY.addToTeam(empY3);
    System.out.println(manY);

    //testing ResonantCircuit
    ResonantCircuit r1 = new ResonantCircuit(85, 0.16, 0.03);
    r1.display();

    //testing ParallelResonantCircuit
    ResonantCircuit r2 = new ParallelResonantCircuit(30, 0.01, 0.42);
    r2.display();

    //testing SeriesResonantCircuit
    ResonantCircuit r3 = new SeriesResonantCircuit(55, 0.25, 0.08);
    r3.display();

    //testing example from piazza.com
    System.out.println("\nThis is the example given on piazza as a ParallelResonantCircuit...");
    ResonantCircuit r4 = new ParallelResonantCircuit(70, 0.05, 0.07);
    r4.display();
    System.out.println("(Notice how the output is the same as on piazza)\n");
    System.out.println("Now let's try the same test, but as a SeriesResonantCircuit...");
    ResonantCircuit r5 = new SeriesResonantCircuit(70, 0.05, 0.07);
    r5.display();
    System.out.println("(Notice how the frequency stays the same, but the bandwidth is about 1000, and the gain is different)");
  }
}
