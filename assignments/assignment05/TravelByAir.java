package assignment05;
import java.time.LocalDate;

public class TravelByAir implements TravelExpenses{
  private LocalDate outboundStartDate;
  private LocalDate inboundEndDate;
  private String airlines;
  private double totalCost;

  public TravelByAir(double totalCost, String airlines, LocalDate outboundStartDate, LocalDate inboundEndDate){
    this.totalCost = totalCost;
    this.airlines = airlines;
    this.outboundStartDate = outboundStartDate;
    this.inboundEndDate = inboundEndDate;
  }

  @Override
  public double amountToReimburse(){
    return totalCost;
  }

  @Override
  public String getDescription(){
    return "Flight with "+airlines+" departed on "+outboundStartDate+" and landed on "+inboundEndDate+".";
  }

  @Override
  public LocalDate getStartDate(){
    return outboundStartDate;
  }

  @Override
  public LocalDate getEndDate(){
    return inboundEndDate;
  }

  @Override
  public int sequenceNo() {
    return 1;
  }
}
