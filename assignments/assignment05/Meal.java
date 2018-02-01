package assignment05;
import java.time.LocalDate;

public class Meal implements TravelExpenses{
  private MealType mealType;
  double amountPaid;
  LocalDate mealDate;

  public Meal(MealType mealType, double amountPaid, LocalDate mealDate){
    this.mealType = mealType;
    this.amountPaid = amountPaid;
    this.mealDate = mealDate;
  }

  public MealType getMealType(){
    return mealType;
  }

  @Override
  public double amountToReimburse(){
    return Math.max(amountPaid, mealType.getMax());
  }

  @Override
  public String getDescription(){
    return mealType+" on "+mealDate;
  }

  @Override
  public LocalDate getStartDate(){
    return mealDate;
  }

  @Override
  public LocalDate getEndDate(){
    return mealDate;
  }

}
