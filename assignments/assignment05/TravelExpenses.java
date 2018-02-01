package assignment05;
import java.util.*;
import java.time.LocalDate;

public interface TravelExpenses{
  double mileage = 0.53;
  static double BREAKFAST_MAX = 8.0;
  static double LUNCH_MAX = 10.0;
  static double DINNER_MAX = 40.0;

  double amountToReimburse();

  default String getDescription(){
    throw new UnsupportedOperationException("Must be implemented by class");
  }

  static void printReport(ArrayList<TravelExpenses> list){
    Collections.sort(list, Comparator.comparing(TravelExpenses::getStartDate).thenComparing(new ExpensesOrder()));
    double temp = 0.0;
    for(TravelExpenses te : list){
      if(te.getStartDate().equals(te.getEndDate())){
        System.out.println("Start Date: "+te.getStartDate());
      }
      else{
        System.out.println("Start Date: "+te.getStartDate()+"\nEnd Date: "+te.getEndDate());
      }
      String s = String.format("$%.2f", te.amountToReimburse());
      System.out.println(te.getDescription()+": "+s);
      temp += te.amountToReimburse();
    }
    System.out.println("Total Expenses: $"+temp+"\n");
  }

  default LocalDate getStartDate() {
    return LocalDate.now();
  }
  default LocalDate getEndDate() {
    return LocalDate.now();
  }
  default int sequenceNo() {
    return Integer.MAX_VALUE;
  }

}
