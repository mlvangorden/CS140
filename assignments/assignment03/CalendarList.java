package assignment03;
import java.time.LocalDateTime;
import java.util.Optional;

public class CalendarList {
  private CalendarItem first;
  private CalendarItem next;

  public void setFirst(CalendarItem item){
    first = item;
  }

  public void setNext(){
    CalendarItem temp = first;
    LocalDateTime now = LocalDateTime.now();
    while(temp.getNextItem() != null){
      if(temp.getStart().isEqual(now) || temp.getStart().isAfter(now)){
        next = temp;
        return;
      }
      else{
        temp = temp.getNextItem();
      }
    }
  }

  public void resetFirst(){
    setNext();
    first = next;
  }

  public Optional<CalendarItem> findConflict(CalendarItem newItem){
    CalendarItem temp = first;
    while(temp.getNextItem() != null){
      if(temp.hasTimeConflictWith(newItem)){
        return Optional.of(temp);
      }
      else{
        temp = temp.getNextItem();
      }
    }
    return Optional.empty();
  }

  private void insert(CalendarItem newItem){
    if(first.equals(null)){
      first = newItem;
      return;
    }
    if(newItem.endsBefore(first)){
      newItem.setNextItem(first);
      first = newItem;
    }
    else{
      CalendarItem temp = first;
      while(temp.getNextItem() != null){
        if(newItem.endsBefore(temp.getNextItem())){
          newItem.setNextItem(temp.getNextItem());
          temp.setNextItem(newItem);
          return;
        }
        else{
          temp = temp.getNextItem();
        }
      }
    }
  }

  public void insertItem(CalendarItem newItem){
    LocalDateTime now = LocalDateTime.now();
    if(newItem.getEnd().isBefore(now)){
      throw new IllegalArgumentException("It is too late for that appointment.");
    }
    if(newItem.getStart().isBefore(now)){
      throw new IllegalArgumentException("That appointment is currently underway... Run!");
    }
    Optional<CalendarItem> temp = findConflict(newItem);
    if(temp.isPresent()) {
	     throw new IllegalArgumentException("You have a conflict: " + findConflict(newItem));
     }
    insert(newItem);
  }

  void testingInsert(CalendarItem newItem){
    Optional<CalendarItem> temp = findConflict(newItem);
    if(temp.isPresent()) {
       throw new IllegalArgumentException("You have a conflict: " + findConflict(newItem));
     }
    insert(newItem);
  }

  public void printNext(){
    System.out.println("Next Appointment:");
    System.out.println(next.toString()+"\n");
  }

  public void printCalendar(){
    CalendarItem temp = first;
    int count = 1;
    System.out.println("Entire Schedule:");
    while(temp != null){
      System.out.println(count+") "+temp.toString()+"\n");
      count++;
      temp = temp.getNextItem();
    }
    System.out.println();
  }

}
