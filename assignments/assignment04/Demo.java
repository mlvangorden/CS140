package assignment04;
import java.util.*;

public class Demo{
  public static void main(String[] args){
    FlexibleChoiceQuestion rainbow = new FlexibleChoiceQuestion("What are all the colors in the rainbow?");
    rainbow.addChoice("Red");
    rainbow.addChoice("White");
    rainbow.addChoice("Green");
    rainbow.addChoice("Indigo");
    rainbow.addChoice("Brown");
    rainbow.addChoice("Orange");
    rainbow.addChoice("Violet");
    rainbow.addChoice("Black");
    rainbow.addChoice("Blue");
    rainbow.addChoice("Yellow");
    rainbow.addChoice(null);
    rainbow.addAnswer(1);
    rainbow.addAnswer(3);
    rainbow.addAnswer(4);
    rainbow.addAnswer(6);
    rainbow.addAnswer(7);
    rainbow.addAnswer(9);
    rainbow.addAnswer(10);
    rainbow.presentQuestion();
  }
}
