package lab04;
import java.util.ArrayList;

public class Roster{
	private ArrayList<Student> classRoster = new ArrayList<>();

	public ArrayList<Student> getRoster(){
		return classRoster;
	}

	public void addStudent(Student s){
		classRoster.add(s);
	}

	public void dropStudent(String name){
		for(int i = 0; i<classRoster.size(); i++){
			if(classRoster.get(i).getName().equals(name)){
				classRoster.remove(i);
				i--;
			}
		}
	}

	public String toString(){
		String classroom = "";
		for(int i = 0; i<classRoster.size(); i++){
				classroom = classroom+classRoster.get(i).getName();
				if(i+1!=classRoster.size()){
					classroom = classroom+", ";
				}
		}
		return "["+classroom+"]";
	}

	public void sortById(){
	 for(int i = 0; i < classRoster.size(); i++){
	      for(int j = 1; j < (classRoster.size()-i); j++){
	              if(classRoster.get(j-1).getId() > classRoster.get(j).getId()){
	                       Student temp = classRoster.get(j-1);
	                       classRoster.set(j-1, classRoster.get(j));
	                       classRoster.set(j, temp);
	              }
	      }
	  }
	}

}
