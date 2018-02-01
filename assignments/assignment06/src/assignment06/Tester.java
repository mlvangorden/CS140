package assignment06;

import java.util.ArrayList;
import java.util.Collections;
import assignment06.TriangleClassifier.Triple;
import static assignment06.TriangleClassifier.removeScalene;

public class Tester{
  public static void main(String[] args){
    ArrayList<Triple> test1 = new ArrayList<>();
    test1.add(new Triple(3,4,5));
    test1.add(new Triple(5,6,7));
    test1.add(new Triple(5,5,9));
    test1.add(new Triple(5,5,5));
    test1.add(new Triple(2,4,3));
    test1.add(new Triple(7,7,5));
    System.out.println(test1);
    Collections.sort(test1);
    System.out.println(test1);
    removeScalene(test1);
    System.out.println(test1);
  }
}
