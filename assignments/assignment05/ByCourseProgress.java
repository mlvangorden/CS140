package assignment05;
import java.util.*;

public class ByCourseProgress implements Comparator<Student>{
  @Override
  public int compare(Student student1, Student student2){
    if(student1.getCourse() == null && student2.getCourse() != null){
      return -1;
    }
    if(student2.getCourse() == null && student1.getCourse() != null){
      return 1;
    }
    if(student1.getCourse() == null && student2.getCourse() == null){
      return student1.getSelf().compareTo(student2.getSelf());
    }

    if(student1.percentRead() != student2.percentRead()){
      return student1.percentRead() - student2.percentRead();
    }
    if(student1.percentCompleted() != student2.percentCompleted()){
      return student1.percentCompleted() - student2.percentCompleted();
    }
    return student1.getSelf().compareTo(student2.getSelf());
  }
}
