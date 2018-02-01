package assignment05;

public class Course{
  private String courseName;
  private int[] pagesToRead;

  public Course(String courseName){
    this.courseName = courseName;
  }

  public void setNumReadings(int readings){
    pagesToRead = new int[readings];
  }

  public void setPages(int reading, int totalPages){
    pagesToRead[reading] = totalPages;
  }

  public int getNumReadings(){
    return pagesToRead.length;
  }

  public int getPages(int reading){
    return pagesToRead[reading];
  }

  public int getTotalPages(){
    int returnVal = 0;
    for(int i = 0; i<pagesToRead.length; i++){
      returnVal += pagesToRead[i];
    }
    return returnVal;
  }

  public String getCourseName(){
    return courseName;
  }
}
