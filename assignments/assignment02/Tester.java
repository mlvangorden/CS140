package assignment02;
import java.util.Arrays;
import java.util.Optional;

public class Tester{
  public static void main(String[] args){

//testing countNulls
    System.out.println("Expected value: 0");
    System.out.println(Utilities02.countNulls(null));
    Object[] test1 = {};
    System.out.println("Expected value: 0");
    System.out.println(Utilities02.countNulls(test1));
    System.out.println("Expected value: 3");
    System.out.println(Utilities02.countNulls(new Integer[]{null, 3, null, null, 77}));
    System.out.println();

//testing countSpaces
    System.out.println("Expected value: -1");
    System.out.println(Utilities02.countSpaces(null));
    System.out.println("Expected value: 0");
    System.out.println(Utilities02.countSpaces(""));
    System.out.println("Expected value: 0");
    System.out.println(Utilities02.countSpaces("fourwordsalluppercase"));
    System.out.println("Expected value: 3");
    System.out.println(Utilities02.countSpaces("ONE WORD, ALL LOWERCASE"));
    System.out.println();

//testing countSpaces2
    System.out.println("Expected value: 0");
    System.out.println(Utilities02.countSpaces2(null));
    System.out.println("Expected value: 0");
    System.out.println(Utilities02.countSpaces2(""));
    System.out.println("Expected value: 0");
    System.out.println(Utilities02.countSpaces2("fourwordsalluppercase"));
    System.out.println("Expected value: 3");
    System.out.println(Utilities02.countSpaces2("ONE WORD, ALL LOWERCASE"));
    System.out.println();

//testing first
    System.out.println("Expected value: null");
    System.out.println(Utilities02.first(null));
    System.out.println("Expected value: ");
    System.out.println(Utilities02.first(""));
    System.out.println("Expected value: ");
    System.out.println(Utilities02.first("   "));
    System.out.println("Expected value: fourwordsalluppercase");
    System.out.println(Utilities02.first("   fourwordsalluppercase     "));
    System.out.println("Expected value: fourwordsalluppercase");
    System.out.println(Utilities02.first("fourwordsalluppercase"));
    System.out.println("Expected value: One");
    System.out.println(Utilities02.first("  One word, all lowercase   "));
    System.out.println("Expected value: One");
    System.out.println(Utilities02.first("One word, all lowercase"));
    System.out.println();

//testing rest
    System.out.println("Expected value: null");
    System.out.println(Utilities02.rest(null));
    System.out.println("Expected value: ");
    System.out.println(Utilities02.rest(""));
    System.out.println("Expected value: ");
    System.out.println(Utilities02.rest("   "));
    System.out.println("Expected value: fourwordsalluppercase");
    System.out.println(Utilities02.rest("   fourwordsalluppercase     "));
    System.out.println("Expected value: fourwordsalluppercase");
    System.out.println(Utilities02.rest("fourwordsalluppercase"));
    System.out.println("Expected value: word, all lowercase");
    System.out.println(Utilities02.rest("  One word, all lowercase   "));
    System.out.println("Expected value: word, all lowercase");
    System.out.println(Utilities02.rest("One word, all lowercase"));
    System.out.println();

//testing withoutExtraSpaces
    System.out.println("Expected value: One word, all lowercase");
    System.out.println(Utilities02.withoutExtraSpaces("One      word,    all     lowercase"));
    System.out.println("Expected value: Only one space between each word");
    System.out.println(Utilities02.withoutExtraSpaces("Only   one     space   between   each     word"));
    System.out.println("Expected value: Coding is so much fun!");
    System.out.println(Utilities02.withoutExtraSpaces("Coding     is  so   much    fun!"));
    System.out.println();

//testing splitOnSpaces
    System.out.println("Expected value: null");
    System.out.println(Utilities02.splitOnSpaces(null));
    System.out.println("Expected value: null");
    System.out.println(Utilities02.splitOnSpaces(""));
    System.out.println("Expected value: [They're] [making] [me] [do] [this...]");
    String test2[] = Utilities02.splitOnSpaces("They're making me do this...");
    System.out.println("[" + test2[0] + "] " + "[" + test2[1] + "] " + "[" + test2[2] + "] " + "[" + test2[3] + "] " + "[" + test2[4] + "]");
    System.out.println();

//testing splitOnSpaces1
    System.out.println("Expected value: Optional.empty");
    System.out.println(Utilities02.splitOnSpaces1(null));
    System.out.println("Expected value: Optional.empty");
    System.out.println(Utilities02.splitOnSpaces1(""));
    System.out.println("Expected value: [They're] [making] [me] [do] [this...]");
    Optional<String[]> test3 = Utilities02.splitOnSpaces1("They're making me do this...");
    if(test3.isPresent()){
      String[] result = test3.get();
      System.out.println("[" + result[0] + "] " + "[" + result[1] + "] " + "[" + result[2] + "] " + "[" + result[3] + "] " + "[" + result[4] + "]");
    }
    System.out.println();


//testing strLengths
    int test4[] = Utilities02.strLengths("Coding is so much fun!");
    System.out.println("Expected value: [6] [2] [2] [4] [4]");
    System.out.println("[" + test4[0] + "] " + "[" + test4[1] + "] " + "[" + test4[2] + "] " + "[" + test4[3] + "] " + "[" + test4[4] + "]");
    System.out.println();

//testing InstanceMethodVersion
    InstanceMethodVersion test5 = new InstanceMethodVersion("They're making me do this...");
    InstanceMethodVersion test6 = new InstanceMethodVersion("    One     word,     all    lowercase     ");
    System.out.println("Expected result: 4");
    System.out.println(test5.countSpaces());
    System.out.println("Expected result: 4");
    System.out.println(test5.countSpaces2());
    System.out.println("Expected result: One word, all lowercase");
    System.out.println(test6.withoutExtraSpaces());
    System.out.println("Expected result: They're");
    System.out.println(test5.first());
    System.out.println("Expected result: making me do this...");
    System.out.println(test5.rest());
    System.out.println("Expected result: [They're, making, me, do, this...]");
    System.out.println(Arrays.toString(test5.splitOnSpaces()));
    System.out.println("Expected result: [7, 6, 2, 2, 6]");
    System.out.println(Arrays.toString(test5.strLengths()));
    System.out.println();
    System.out.println("Thank you, come again.");
    System.out.println();
  }
}
