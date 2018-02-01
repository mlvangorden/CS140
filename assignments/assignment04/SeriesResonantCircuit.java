package assignment04;
import java.util.*;

public class SeriesResonantCircuit extends ResonantCircuit{
  private double resistance;
  private double capacitance;
  private double inductance;

  static private double computeBandwidth(double r, double L){
    if(r == 0.0 || L == 0.0){
      throw new IllegalArgumentException("inputs cannot be zero");
    }
    return r/L;
  }

  static private double computeFrequency(double c, double L){
    if(c == 0 || L == 0){
      throw new IllegalArgumentException("inputs cannot be zero");
    }
    return Math.sqrt(1/(c*L));
  }

  public SeriesResonantCircuit(double r, double c, double l){
    super(computeFrequency(c,l), computeBandwidth(r,l), 1/r);
    resistance = r;
    capacitance = c;
    inductance = l;
  }

  public void display(){
    super.display();
    StringBuilder build = new StringBuilder();
    build.append("\tresistance: ");
    build.append(resistance);
    build.append("\n\tcapacitance: ");
    build.append(capacitance);
    build.append("\n\tinductance: ");
    build.append(inductance);
    build.append("\n");
    System.out.print(build.toString());
  }

}
