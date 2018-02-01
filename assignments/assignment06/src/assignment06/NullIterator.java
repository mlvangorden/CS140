package assignment06;
//import java.lang.Iterable;
import java.util.*;

public class NullIterator implements Iterator<MComp>{
  @Override
  public MComp next(){
    return null;
  }

  @Override
  public boolean hasNext(){
    return false;
  }

  @Override
  public void remove(){
    throw new UnsupportedOperationException();
  }
}
