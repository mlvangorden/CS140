package assignment01;

public class Class {

  private String name;
  private String number;
  private int credit;
  private int crn;
  private double qualPoints;

  public Class(String aName, String aNumber, int aNumCredits, int aCrn) {
    name = aName;
    number = aNumber;
    credit = aNumCredits;
    crn = aCrn;
  }

  public static final Class DUMMY_CLASS = new Class("Dummy", "000", 0, 0);

  public String getName() {
    return name;
  }
  public String getNumber() {
    return number;
  }
  public int getCredit() {
    return credit;
  }
  public int getCrn() {
    return crn;
  }
  public double getQualPoints() {
    return qualPoints;
  }

  public void setQualPoints(double qPoints){
     qualPoints = qPoints;
  }

}
