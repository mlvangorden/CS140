package assignment05;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Lodging implements TravelExpenses{
  private LocalDate startDate;
  private LocalDate endDate;
  private String lodgingName;
  private int numberOfNights;
  private double costOfStay;

  public Lodging(double costOfStay, String lodgingName, LocalDate startDate, LocalDate endDate){
    this.costOfStay = costOfStay;
    this.lodgingName = lodgingName;
    this.startDate = startDate;
    this.endDate = endDate;
    numberOfNights = (int)ChronoUnit.DAYS.between(startDate, endDate);
  }

  @Override
  public double amountToReimburse(){
    return costOfStay;
  }

  @Override
  public String getDescription(){
    StringBuilder build = new StringBuilder();
    build.append("Stayed at ");
    build.append(lodgingName);
    build.append(" for ");
    build.append(numberOfNights);
    build.append(" nights from ");
    build.append(startDate);
    build.append(" to ");
    build.append(endDate);
    build.append(".");
    return build.toString();
  }

  @Override
  public LocalDate getStartDate(){
    return startDate;
  }

  @Override
  public LocalDate getEndDate(){
    return endDate;
  }
}
