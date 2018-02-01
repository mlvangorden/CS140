package assignment06;
//import java.lang.Iterable;
import java.util.*;

public class MenuItem implements MComp{
  private String name;
  private String description;
  private boolean vegetarian;
  private double price;

  public MenuItem(String name, String description, boolean vegetarian, double price){
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  @Override
  public String getName(){
    return name;
  }

  @Override
  public String getDescription(){
    return description;
  }

  @Override
  public boolean isVegetarian(){
    return vegetarian;
  }

  @Override
  public double getPrice(){
    return price;
  }

  @Override
  public Iterator<MComp> iterator(){
    return new NullIterator();
  }

  @Override
  public void print(){
    System.out.print("\t"+getName());
    if(isVegetarian()){
      System.out.print("(v)");
    }
    System.out.println(", "+getPrice()+"\n\t\t"+getDescription());
  }
}
