package exam02;

public class Sum implements BinaryFunction {
	
	@Override
	public int apply(int a, int b) {
		return a+b;
	}
}