package assignment01;

public class Student{

  private Class class1 = Class.DUMMY_CLASS;
  private Class class2 = Class.DUMMY_CLASS;
  private Class class3 = Class.DUMMY_CLASS;
  private Class class4 = Class.DUMMY_CLASS;
  private Person self;

  public Student(Person aSelf) {
    self = aSelf;
  }

  public void setQualPoints1(double qPoints){
    class1.setQualPoints(qPoints);
  }
  public void setQualPoints2(double qPoints){
    class2.setQualPoints(qPoints);
  }
  public void setQualPoints3(double qPoints){
    class3.setQualPoints(qPoints);
  }
  public void setQualPoints4(double qPoints){
    class4.setQualPoints(qPoints);
  }

  public String getName(){
    return self.getFirst()+" "+self.getMiddle()+". "+self.getLast();
  }

  public Class getClass1(){
    return class1;
  }

  public void setClass1(Class aClass1){
    class1 = aClass1;
  }

  public Class getClass2(){
    return class2;
  }

  public void setClass2(Class aClass2){
    class2 = aClass2;
  }

  public Class getClass3(){
    return class3;
  }

  public void setClass3(Class aClass3){
    class3 = aClass3;
  }

  public Class getClass4(){
    return class4;
  }

  public void setClass4(Class aClass4){
    class4 = aClass4;
  }

  public double computeSemesterGPA(){
    double gpa = 0.0;
    double totalPoints = class1.getQualPoints() + class2.getQualPoints() + class3.getQualPoints() + class4.getQualPoints();
    double totalCredits = class1.getCredit() + class2.getCredit() + class3.getCredit() + class4.getCredit();
    if (totalCredits > 0){
      gpa = totalPoints / totalCredits;
    }
    return gpa;
  }

}
