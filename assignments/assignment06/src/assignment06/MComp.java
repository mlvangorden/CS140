package assignment06;
import java.lang.Iterable;

public interface MComp extends Iterable<MComp>{
  default void add(MComp mComp){
    throw new UnsupportedOperationException("Must be implemented by class.");
  }
  default void remove(MComp mComp){
    throw new UnsupportedOperationException("Must be implemented by class.");
  }
  default MComp getChild(int i){
    throw new UnsupportedOperationException("Must be implemented by class.");
  }
  default String getName(){
    throw new UnsupportedOperationException("Must be implemented by class.");
  }
  default String getDescription(){
    throw new UnsupportedOperationException("Must be implemented by class.");
  }
  default double getPrice(){
    throw new UnsupportedOperationException("Must be implemented by class.");
  }
  default boolean isVegetarian(){
    throw new UnsupportedOperationException("Must be implemented by class.");
  }
  default void print(){
    throw new UnsupportedOperationException("Must be implemented by class.");
  }
  
}
