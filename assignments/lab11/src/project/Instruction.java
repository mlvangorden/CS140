package project;
import java.util.*;

public class Instruction{
	byte opcode;
	int arg;
	public static Map<String, Integer> opcodes = new TreeMap<>();
	public static Map<Integer, String> mnemonics = new TreeMap<>();
	static {
		opcodes.put("NOP", 0);
		opcodes.put("NOT", 1);
		opcodes.put("HALT", 2);
		opcodes.put("LOD", 3);
		opcodes.put("STO", 4);
		opcodes.put("ADD", 5);
		opcodes.put("SUB", 6);
		opcodes.put("MUL", 7);
		opcodes.put("DIV", 8);
		opcodes.put("AND", 9);
		opcodes.put("JUMP", 10);
		opcodes.put("JMPZ", 11);
		opcodes.put("CMPL", 12);
		opcodes.put("CMPZ", 13);
		
		for(String str : opcodes.keySet()) 
			mnemonics.put(opcodes.get(str), str);
	}
	
	public Instruction(byte opcode, int arg){
		this.opcode = opcode;
		this.arg = arg;
	}
	
	public static boolean noArgument(Instruction instr){
		if(instr.opcode < 24) return true;
		return false;
	}
	
	static int numOnes(int k){
		int count = 0;
		String temp = Integer.toUnsignedString(k,2);
		for(int i = 0; i<temp.length(); i++){
			if(temp.charAt(i) == '1') count++;
		}
		return count;
	}
	
	static void checkParity(Instruction param){
		if(numOnes(param.opcode) % 2 != 0)
			throw new ParityCheckException("This instruction is corrupted");
	}
}