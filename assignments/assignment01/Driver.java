package assignment01;

public class Driver{
    public static void main(String[] args){
      Person bob = new Person("Bob", "Smith", 'Q');
      Person bill = new Person("Bill", "Jefferson", 'T');
      Person ben = new Person("Ben", "Miller", 'H');

      Class MIS325 = new Class("Essentials of Programming", "MIS 325", 4, 23804);
      Class MIS425 = new Class("Web Application Development", "MIS 425", 4, 21472);
      Class RUS111 = new Class("Russian for Russian Speakers", "RUSS 111", 4, 29739);

      Class MIS460 = new Class("E-Business", "MIS 460", 4, 24600);
      Class HIS104A = new Class("Modern American Civ", "HIS 104A", 4, 29739);
      Class ECON160 = new Class("Principles of Micro-Economics", "ECON 160", 4, 24496);
      Class ARTH110 = new Class("Introduction to Art History", "ARTH 110", 4, 27436);

      Student sBob = new Student(bob);
      Student sBill = new Student(bill);
      Student sBen = new Student(ben);

      sBill.setClass1(MIS325);
      sBill.setClass2(MIS425);
      sBill.setClass3(RUS111);

      sBen.setClass1(MIS460);
      sBen.setClass2(HIS104A);
      sBen.setClass3(ECON160);
      sBen.setClass4(ARTH110);

      sBill.setQualPoints1(16.0);
      sBill.setQualPoints2(16.0);
      sBill.setQualPoints3(12.0);

      sBen.setQualPoints1(14.8);
      sBen.setQualPoints2(12.0);
      sBen.setQualPoints3(16.0);
      sBen.setQualPoints4(9.2);

      double bobGPA = sBob.computeSemesterGPA();
      double billGPA = sBill.computeSemesterGPA();
      double benGPA = sBen.computeSemesterGPA();

      System.out.printf("Bob's GPA is %.3f\n", bobGPA);
      System.out.printf("Expected: 0.000\n");
      System.out.printf("Bill's GPA is %.3f\n", billGPA);
      System.out.printf("Expected: 3.667\n");
      System.out.printf("Ben's GPA is %.3f\n", benGPA);
      System.out.printf("Expected: 3.250\n");
    }
}
