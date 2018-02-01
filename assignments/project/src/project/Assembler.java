package project;
import java.util.*;

public interface Assembler {
	Set<String> noArgument = new TreeSet<String>(Arrays.asList("HALT", "NOP", "NOT", "DATA"));
	
	int assemble(String inputFileName, String outputFileName, StringBuilder error);
	
	class DataPair{
		protected int address;
		protected int value;
		
		public DataPair(int address, int value){
			this.address = address;
			this.value = value;
		}
		
		public String toString() {
			return "DataPair (" + address + ", " + value + ")";
		}
	}
}
