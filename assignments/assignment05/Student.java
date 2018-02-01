package assignment05;
import java.util.*;

public class Student{
  private Person self;
  private Course course;
  private int[] progress;
  private boolean[] completed;

  public Student(Person self){
    this.self = self;
  }

  public Person getSelf(){
    return self;
  }

  public Course getCourse(){
    if(course == null){
      return null;
    }
    return course;
  }

  public void setCourse(Course crs){
    course = crs;
    progress = new int[crs.getNumReadings()];
    completed = new boolean[crs.getNumReadings()];
  }

  public void read(int reading){
    if(!completed[reading]){
      progress[reading] += 1;
    }
    if(progress[reading] == course.getPages(reading)){
      completed[reading] = true;
    }
  }

  public int percentRead(){
    double returnVal = 0.0;
    double totalProgress = 0.0;
    for(int i = 0; i < progress.length; i++){
      totalProgress += progress[i];
    }
    returnVal = totalProgress / (double)course.getTotalPages();
    return (int)Math.round(returnVal*100);
  }

  public int percentCompleted(){
    int counter = 0;
    for(int i = 0; i<completed.length; i++){
      if(completed[i]){
        counter++;
      }
    }
    return (int)Math.round((counter/completed.length)*100);
  }
}
