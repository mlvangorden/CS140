package assignment04;
import java.util.*;

public class ResonantCircuit{
  private double frequency;
  private double bandwidth;
  private double gain;

  public ResonantCircuit(double f, double b, double g){
    frequency = f;
    bandwidth = b;
    gain = g;
  }

  public double getGain(){
    return gain;
  }

  public void display(){
    StringBuilder build = new StringBuilder();
    build.append("Resonant Circuit Characteristics:\n\tfrequency: ");
    build.append(frequency);
    build.append("\n\tbandwidth: ");
    build.append(bandwidth);
    build.append("\n\tgain: ");
    build.append(gain);
    build.append("\n");
    System.out.print(build.toString());
  }
}
