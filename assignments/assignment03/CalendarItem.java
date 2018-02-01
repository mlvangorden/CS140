package assignment03;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalendarItem{

  private LocalDateTime start;
  private LocalDateTime end;
  private String title = "";
  private String description = "";
  private String location = "";
  private CalendarItem nextItem;

  public LocalDateTime getStart(){
    return start;
  }

  public void setStart(LocalDateTime begin){
    if(end != null && end.isBefore(begin)){
	   throw new IllegalArgumentException("the end cannot be before start");
    }
    start = begin;
  }

  public LocalDateTime getEnd(){
    return end;
  }

  public void setEnd(LocalDateTime finish){
    if(start != null && start.isAfter(finish)){
	   throw new IllegalArgumentException("the start cannot be after end");
    }
    end = finish;
  }

  public String getTitle(){
    return title;
  }

  public void setTitle(String name){
    title = name;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String describe){
    description = describe;
  }

  public String getLocation(){
    return location;
  }

  public void setLocation(String place){
    location = place;
  }

  public CalendarItem getNextItem(){
    return nextItem;
  }

  public void setNextItem(CalendarItem stuff){
    nextItem = stuff;
  }

  public boolean endsBefore(CalendarItem other){
    return end.isBefore(other.start);
  }

  public boolean startsAfter(CalendarItem other){
    return start.isAfter(other.end);
  }

  public boolean noTimeConflictWith(CalendarItem other) {
	 return endsBefore(other) || startsAfter(other);
  }

  public boolean hasTimeConflictWith(CalendarItem other) {
	 return !noTimeConflictWith(other);
  }

  public String toString() {
	 DateTimeFormatter dayForm =  DateTimeFormatter.ofPattern("MMMM d, yyyy");
	 DateTimeFormatter timeForm =  DateTimeFormatter.ofPattern("h:m a");
	 return start.format(dayForm) +" from " + start.format(timeForm)
			+ " to " + end.format(timeForm) + "\n"
			+ title + " in " + location + "\n"
			+ description;
  }

  public static void main(String[] args) {
	 CalendarItem test1 = new CalendarItem();
	 test1.setDescription("this is just a sample meeting of CS 140");
	 test1.setEnd(LocalDateTime.of(2017,9,11,11,50));
	 test1.setStart(LocalDateTime.of(2017,9,11,10,50));
	 test1.setTitle("CS 140");
	 test1.setLocation("FA 212");

   CalendarItem test2 = new CalendarItem();
   test2.setDescription("this is just a sample meeting of HIS 101");
   test2.setEnd(LocalDateTime.of(2017,9,11,12,30));
   test2.setStart(LocalDateTime.of(2017,9,11,11,30));
   test2.setTitle("HIS 101");
   test2.setLocation("EB 113");

   CalendarItem test3 = new CalendarItem();
   test3.setDescription("this is just a sample meeting of MATH 226");
   test3.setEnd(LocalDateTime.of(2017,9,11,9,30));
   test3.setStart(LocalDateTime.of(2017,9,11,8,00));
   test3.setTitle("MATH 226");
   test3.setLocation("S2 337");

	 System.out.println(test1);
   System.out.println("CS140 has a conflict with HIS 101: "+test1.hasTimeConflictWith(test2));
   System.out.println("CS140 has a conflict with MATH 226: "+test1.hasTimeConflictWith(test3));
  }

}
