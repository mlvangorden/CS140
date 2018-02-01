package assignment04;
import java.util.ArrayList;
import java.util.*;

public class FlexibleChoiceQuestion extends ChoiceQuestion{

  private Set<String> answers = new HashSet<String>();

  public FlexibleChoiceQuestion(String qText){
    super(qText);
  }

  public void addChoice(String choice, boolean correct){
    throw new UnsupportedOperationException("Use the one-argument version");
  }

  public void addChoice(String choice){
    super.addChoice(choice, false);
  }

  public void addAnswer(int i){
    if(i<=0){
      throw new IllegalArgumentException("Answers must be numbered from 1");
    }
    answers.add(""+i);
  }

  public boolean checkAnswer(String response){
    String[] parts = response.trim().split("\\s+");
    Set<String> responses = new HashSet<String>(Arrays.asList(parts));
    if(responses.size() != parts.length){
      System.out.println("You have repeated answers");
    }
    if(responses.equals(answers)){
      return true;
    }
    int tempsize = responses.size();
    responses.removeAll(answers);
    if(responses.size() == 0){
      System.out.println("You're answers were correct, but you missed some");
      return false;
    }
    if(responses.size() < tempsize){
      System.out.println("You have some correct answers and some incorrect answers");
      return false;
    }
    System.out.println("All of your answers were incorrect");
    return false;
  }

  public void presentQuestion(){
    super.display();
    System.out.println("Your answer (separate multiple answers with a space): ");
    Scanner in = new Scanner(System.in);
    String response = in.nextLine();
    System.out.println(checkAnswer(response));
  }
}
