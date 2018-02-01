package assignment05;
import java.time.LocalDate;
import java.util.*;

public class Tester1{
  public static void main(String[] args){
    ArrayList<TravelExpenses> testA = new ArrayList<>();
    Meal mealA1 = new Meal(MealType.BREAKFAST, 9.85, LocalDate.of(2017, 8, 16));
    Meal mealA2 = new Meal(MealType.LUNCH, 11.69, LocalDate.of(2017, 8, 16));
    Meal mealA3 = new Meal(MealType.DINNER, 20.53, LocalDate.of(2017, 8, 16));
    Meal mealA4 = new Meal(MealType.BREAKFAST, 8.33, LocalDate.of(2017, 8, 17));
    Lodging lodgingA = new Lodging(74.99, "Nice Hotel Suites", LocalDate.of(2017, 8, 16), LocalDate.of(2017, 8, 17));
    TravelByOwnCar travelA = new TravelByOwnCar(LocalDate.of(2017, 8, 15), LocalDate.of(2017, 8, 17));
    travelA.addMiles(256.75);
    testA.add(mealA3);
    TravelExpenses.printReport(testA);
    testA.add(mealA1);
    TravelExpenses.printReport(testA);
    testA.add(lodgingA);
    TravelExpenses.printReport(testA);
    testA.add(mealA4);
    TravelExpenses.printReport(testA);
    testA.add(travelA);
    TravelExpenses.printReport(testA);
    testA.add(mealA2);
    TravelExpenses.printReport(testA);

    ArrayList<TravelExpenses> testB = new ArrayList<>();
    Meal mealB1 = new Meal(MealType.DINNER, 10.15, LocalDate.of(2017, 7, 7));
    Meal mealB2 = new Meal(MealType.BREAKFAST, 5.47, LocalDate.of(2017, 7, 8));
    Meal mealB3 = new Meal(MealType.DINNER, 14.23, LocalDate.of(2017, 7, 8));
    Meal mealB4 = new Meal(MealType.LUNCH, 11.56, LocalDate.of(2017, 7, 9));
    Lodging lodgingB = new Lodging(47.82, "Holiday Outt", LocalDate.of(2017, 7, 7), LocalDate.of(2017, 7, 9));
    TravelByAir travelB1 = new TravelByAir(565.99, "Gamma Airlines", LocalDate.of(2017, 7, 6), LocalDate.of(2017, 7, 7));
    TravelByRail travelB2 = new TravelByRail(50.00, "Paradise Line", LocalDate.of(2017, 7, 9), LocalDate.of(2017, 7, 10));
    testB.add(lodgingB);
    TravelExpenses.printReport(testB);
    testB.add(mealB3);
    TravelExpenses.printReport(testB);
    testB.add(mealB1);
    TravelExpenses.printReport(testB);
    testB.add(travelB2);
    TravelExpenses.printReport(testB);
    testB.add(mealB4);
    TravelExpenses.printReport(testB);
    testB.add(travelB1);
    TravelExpenses.printReport(testB);
    testB.add(mealB2);
    TravelExpenses.printReport(testB);

    ArrayList<TravelExpenses> testC = new ArrayList<>();
    Meal mealC1 = new Meal(MealType.BREAKFAST, 2.34, LocalDate.of(2017, 6, 26));
    Meal mealC2 = new Meal(MealType.LUNCH, 15.67, LocalDate.of(2017, 6, 26));
    Meal mealC3 = new Meal(MealType.BREAKFAST, 8.90, LocalDate.of(2017, 6, 27));
    Meal mealC4 = new Meal(MealType.DINNER, 21.23, LocalDate.of(2017, 6, 27));
    Lodging lodgingC = new Lodging(47.82, "Cheap Motels", LocalDate.of(2017, 6, 25), LocalDate.of(2017, 6, 28));
    TravelByBus travelC1 = new TravelByBus(565.90, "Magic School Bus", LocalDate.of(2017, 6, 25), LocalDate.of(2017, 6, 25));
    TravelByRentalCar travelC2 = new TravelByRentalCar(129.94, "Blockbuster for Cars", LocalDate.of(2017, 6, 28), LocalDate.of(2017, 6, 30));
    travelC2.addFuel(32.50, 86.26);
    testC.add(mealC2);
    TravelExpenses.printReport(testC);
    testC.add(travelC2);
    TravelExpenses.printReport(testC);
    testC.add(mealC3);
    TravelExpenses.printReport(testC);
    testC.add(lodgingC);
    TravelExpenses.printReport(testC);
    testC.add(mealC1);
    TravelExpenses.printReport(testC);
    testC.add(mealC4);
    TravelExpenses.printReport(testC);
    testC.add(travelC1);
    TravelExpenses.printReport(testC);

  }
}
