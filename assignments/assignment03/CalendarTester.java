package assignment03;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalendarTester{

  public static void main(String[] args){
    CalendarItem test1 = new CalendarItem();
    test1.setDescription("This should disappear after resetFirst()");
    test1.setEnd(LocalDateTime.of(2000,9,25,9,30));
    test1.setStart(LocalDateTime.of(2000,9,25,8,00));
    test1.setTitle("Something in the past");
    test1.setLocation("Anywhere");

    CalendarItem test2 = new CalendarItem();
    test2.setDescription("Discrete Mathematics");
    test2.setEnd(LocalDateTime.of(2017,9,25,9,30));
    test2.setStart(LocalDateTime.of(2017,9,25,8,00));
    test2.setTitle("MATH 314");
    test2.setLocation("SW 202");
    test1.setNextItem(test2);

    CalendarItem test3 = new CalendarItem();
    test3.setDescription("Programming with Objects");
    test3.setEnd(LocalDateTime.of(2017,9,25,11,50));
    test3.setStart(LocalDateTime.of(2017,9,25,10,50));
    test3.setTitle("CS 140");
    test3.setLocation("FA 212");
    test2.setNextItem(test3);

    CalendarItem test4 = new CalendarItem();
    test4.setDescription("Shakespeare - Discussion");
    test4.setEnd(LocalDateTime.of(2017,9,25,10,40));
    test4.setStart(LocalDateTime.of(2017,9,25,9,40));
    test4.setTitle("ENG 245 - A01");
    test4.setLocation("SW 115");

    CalendarItem test5 = new CalendarItem();
    test5.setDescription("This ends before now");
    test5.setEnd(LocalDateTime.of(2000,1,1,00,00));
    test5.setStart(LocalDateTime.of(2000,1,1,00,00));
    test5.setTitle("TOO LATE");
    test5.setLocation("Error");

    CalendarItem test6 = new CalendarItem();
    test6.setDescription("This starts before now, but is still happening");
    test6.setStart(LocalDateTime.of(2000,1,1,00,00));
    test6.setEnd(LocalDateTime.of(2999,12,31,23,59));
    test6.setTitle("CURRENTLY UNDERWAY");
    test6.setLocation("Error");

    //creates a new CalendarList
    CalendarList schedule = new CalendarList();

    //sets first of schedule to my list of tests
    schedule.setFirst(test1);
    schedule.printCalendar();

    //drops first, which happened in the year 2000
    schedule.resetFirst();

    //inserts a class in the middle of my schedule
    schedule.insertItem(test4);
    schedule.printCalendar();

    //tests printNext()
    schedule.printNext();

    //tests IllegalArgumentException when inserting an appointment that ends before now
    try{
      schedule.insertItem(test5);
    }
    catch(IllegalArgumentException e){
      System.out.println("It is too late for that appointment.");
    }

    //tests IllegalArgumentException when inserting an appointment that is currently happening
    try{
      schedule.insertItem(test6);
    }
    catch(IllegalArgumentException e){
      System.out.println("That appointment is currently underway... Run!");
    }

    //tests IllegalArgumentException when inserting an appointment that has a conflict
    try{
      schedule.insertItem(test4);
    }
    catch(IllegalArgumentException e){
      System.out.println("You have a conflict: "+test4.getTitle()+"\n");
    }

    //tests testingInsert()
    schedule.testingInsert(test1);
    schedule.printCalendar();
  }
}
