package lab04;

public class RosterTester{
  public static void main(String[] args){
    Roster CS140 = new Roster();
    Student craig = new Student(99, "Craig");
    CS140.addStudent(craig);
    Student bella = new Student(46, "Bella");
    CS140.addStudent(bella);
    Student michael = new Student(27, "Michael");
    CS140.addStudent(michael);
    Student anthony = new Student(69, "Anthony");
    CS140.addStudent(anthony);
    Student mollie = new Student(54, "Mollie");
    CS140.addStudent(mollie);

    System.out.println(CS140.toString());

    CS140.dropStudent("Michael");
    System.out.println(CS140.toString());

    CS140.sortById();
    System.out.println(CS140.toString());

    for(int i = 0; i<CS140.getRoster().size(); i++){
      System.out.println(CS140.getRoster().get(i).getName()+", "+CS140.getRoster().get(i).getId());
    }
  }
}
