package assignment04;
import java.util.*;

public class ParallelResonantCircuit extends ResonantCircuit{
  private double resistance;
  private double capacitance;
  private double inductance;

  static private double computeBandwidth(double r, double c){
    if(r == 0.0 || c == 0.0){
      throw new IllegalArgumentException("inputs cannot be zero");
    }
    return 1/(r*c);
  }

  static private double computeFrequency(double c, double L){
    if(c == 0 || L == 0){
      throw new IllegalArgumentException("inputs cannot be zero");
    }
    return Math.sqrt(1/(c*L));
  }

  public ParallelResonantCircuit(double r, double c, double l){
    super(computeFrequency(c,l), computeBandwidth(r,c), r);
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
