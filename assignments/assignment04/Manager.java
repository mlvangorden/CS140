package assignment04;
import java.util.*;

public class Manager extends Employee{
  private String department;
  private ArrayList<Employee> team = new ArrayList<>();

  public Manager(Person fellow){
    super(fellow);
  }

  public void addToTeam(Employee member){
    team.add(member);
  }

  public void setDepartment(String work){
    department = work;
  }

  public String toString(){
    StringBuilder build = new StringBuilder();
    build.append(super.toString());
    build.append("\n");
    build.append(department);
    build.append("\n");
    for(int i = 0; i<team.size(); i++){
      build.append("\t");
      build.append(team.get(i).toString());
      build.append("\n");
    }
    return build.toString();
  }
}
