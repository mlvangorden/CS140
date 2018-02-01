package project;

public class Test{
	public static void main(String[] args){
		Instruction test1 = new Instruction((byte)0b10101010, 0);
		Instruction test2 = new Instruction((byte)0b10010010, 0);
		Instruction test3 = new Instruction((byte)0b01111000, 0);
		try{
			Instruction.checkParity(test1);
			System.out.println("Test1 executed successfully!");
		}catch(ParityCheckException e){
			System.out.println("Test1 failed...");
		}
		
		try{
			Instruction.checkParity(test2);
			System.out.println("Test2 executed successfully!");
		}catch(ParityCheckException e){
			System.out.println("Test2 failed...");
		}
		
		try{
			Instruction.checkParity(test3);
			System.out.println("Test3 executed successfully!");
		}catch(ParityCheckException e){
			System.out.println("Test3 failed...");
		}
		
	}
}