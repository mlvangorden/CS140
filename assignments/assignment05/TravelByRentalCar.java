package assignment05;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class TravelByRentalCar implements TravelExpenses{
  private double totalRentalCost;
  private double fuelCost;
  private double fuelUsed;
  private int numberOfDaysRented;
  private String rentalCompany;
  private LocalDate startDate;
  private LocalDate endDate;

  public TravelByRentalCar(double totalRentalCost, String rentalCompany, LocalDate startDate, LocalDate endDate){
    this.totalRentalCost = totalRentalCost;
    this.rentalCompany = rentalCompany;
    this.startDate = startDate;
    this.endDate = endDate;
    numberOfDaysRented = (int)ChronoUnit.DAYS.between(startDate, endDate);
  }

  public void addFuel(double numGallons, double cost){
      fuelUsed += numGallons;
      fuelCost += cost;
  }

  @Override
  public String getDescription(){
    StringBuilder build = new StringBuilder();
    build.append("It is a rental car from ");
    build.append(rentalCompany);
    build.append(" for ");
    build.append(numberOfDaysRented);
    build.append(" days\nfrom ");
    build.append(startDate);
    build.append(" to ");
    build.append(endDate);
    build.append(", ");
    build.append(Math.round(fuelUsed));
    build.append(" gallons of fuel used.");
    return build.toString();
  }

  @Override
  public double amountToReimburse(){
    return totalRentalCost + fuelCost;
  }

  @Override
  public LocalDate getStartDate(){
    return startDate;
  }

  @Override
  public LocalDate getEndDate(){
    return endDate;
  }

  @Override
  public int sequenceNo() {
    return 4;
  }

}
