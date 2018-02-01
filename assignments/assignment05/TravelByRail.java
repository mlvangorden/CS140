package assignment05;
import java.time.LocalDate;

public class TravelByRail implements TravelExpenses{
  private LocalDate outboundStartDate;
  private LocalDate inboundEndDate;
  private String railLines;
  private double totalCost;

  public TravelByRail(double totalCost, String railLines, LocalDate outboundStartDate, LocalDate inboundEndDate){
    this.totalCost = totalCost;
    this.railLines = railLines;
    this.outboundStartDate = outboundStartDate;
    this.inboundEndDate = inboundEndDate;
  }

  @Override
  public double amountToReimburse(){
    return totalCost;
  }

  @Override
  public String getDescription(){
    return "Travel with "+railLines+" departed on "+outboundStartDate+" and arrived on "+inboundEndDate+".";
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
    return 2;
  }
}
