package assignment05;
import java.time.LocalDate;

public class TravelByBus implements TravelExpenses{
  private LocalDate outboundStartDate;
  private LocalDate inboundEndDate;
  private String busLines;
  private double totalCost;

  public TravelByBus(double totalCost, String busLines, LocalDate outboundStartDate, LocalDate inboundEndDate){
    this.totalCost = totalCost;
    this.busLines = busLines;
    this.outboundStartDate = outboundStartDate;
    this.inboundEndDate = inboundEndDate;
  }

  @Override
  public double amountToReimburse(){
    return totalCost;
  }

  @Override
  public String getDescription(){
    return "Travel with "+busLines+" departed on "+outboundStartDate+" and arrived on "+inboundEndDate+".";
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
    return 3;
  }
}
