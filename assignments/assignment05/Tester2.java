package assignment05;
import java.util.*;
import java.time.LocalDate;

public class Tester2{
  public static void main(String[] args){
    Person guy = new Person("Roman", "Michael", LocalDate.of(1983, 1, 1));
    Person gal = new Person("Wells", "Stella", LocalDate.of(1984, 8, 7));
    Course course1 = new Course("Ancient Greek History");
    course1.setNumReadings(5);
    course1.setPages(0, 3);
    course1.setPages(1, 10);
    course1.setPages(2, 6);
    course1.setPages(3, 3);
    course1.setPages(4, 7);
    Course course2 = new Course("Shakespeare");
    course2.setNumReadings(2);
    course2.setPages(0, 20);
    course2.setPages(1, 31);
    Student student1 = new Student(guy);
    Student student2 = new Student(gal);

    ByDobThenNameComp comp1 = new ByDobThenNameComp();
    System.out.println("Based on date of birth and name alone, the second student is greater.");
    System.out.println("Expected Result: (-)");
    System.out.println("Actual Result: "+comp1.compare(guy, gal)+"\n");

    ByCourseProgress comp2 = new ByCourseProgress();

    student1.setCourse(course1);
    System.out.println("After giving only Student1 a course, he is now greater.");
    System.out.println("Expected Result: (+)");
    System.out.println("Actual Result: "+comp2.compare(student1, student2)+"\n");
    student2.setCourse(course2);
    System.out.println("After giving Student2 a course, she is greater again.");
    System.out.println("Expected Result: (-)");
    System.out.println("Actual Result: "+comp2.compare(student1, student2)+"\n");
    for(int i = 0; i<10; i++){
      student1.read(0);
      student1.read(1);
      student1.read(3);
    }
    System.out.println("After Student1 makes some progress on his reading, he is greater.");
    System.out.println("Expected Result: (+)");
    System.out.println("Actual Result: "+comp2.compare(student1, student2)+"\n");
    for(int i = 0; i<10; i++){
      student2.read(0);
    }
    System.out.println("Student2 makes some progress, but not enough, so Student1 is still greater by a smaller amount.");
    System.out.println("Expected Result: (+)");
    System.out.println("Actual Result: "+comp2.compare(student1, student2)+"\n");
    for(int i = 0; i<50; i++){
      student2.read(0);
      student2.read(1);
    }
    System.out.println("Student2 finished her entire reading before Student1, so she's greater again.");
    System.out.println("Expected Result: (-)");
    System.out.println("Actual Result: "+comp2.compare(student1, student2)+"\n");
    for(int i = 0; i<10; i++){
      student1.read(2);
      student1.read(4);
    }
    System.out.println("Student1 finished his assignment, so the difference between them goes back to the original.");
    System.out.println("Expected Result: (-)");
    System.out.println("Actual Result: "+comp2.compare(student1, student2)+"\n");
  }
}
