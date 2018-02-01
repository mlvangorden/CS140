package lab04;
import java.util.ArrayList;

public class ArrayListPractice{
	private ArrayList<Integer> arrList = new ArrayList<>();

	public int intRemoveAll(int e){
		int count = 0;
		for(int i = 0; i<arrList.size(); i++){
			if(arrList.get(i) == e){
				arrList.remove(i);
				count++;
			}
		}
		return count;
	}

	public boolean isEqual(ArrayList<Integer>  other){
		boolean flag = true;
		if(arrList.size() == other.size()){
			for(int i = 0; i<arrList.size(); i++){
				if(arrList.get(i) != other.get(i)){
					flag = false;
				}
			}
		}
		else{
			flag = false;
		}
		return flag;
	}

	public void appendArray(int[] arr){
		if(arr == null){
			throw new IllegalArgumentException("You may not append a null array onto arrList.");
		}
		for(int i = 0; i<arr.length; i++){
			arrList.add(arr[i]);
		}
	}

	public ArrayList<Integer> sumElementWise(ArrayList<Integer> other){
		if(other == null){
			throw new IllegalArgumentException("You cannot add a null ArrayList to arrList.");
		}
		ArrayList<Integer> wise = new ArrayList<>();
		int count = 0;
		if(other.size() < arrList.size()){
			for(int i = 0; i<other.size(); i++){
				wise.add(other.get(i)+arrList.get(i));
				count++;
			}
			for(int i = count; i<arrList.size(); i++){
				wise.add(arrList.get(i));
			}
		}
		if(arrList.size() < other.size()){
			for(int i = 0; i<arrList.size(); i++){
				wise.add(other.get(i)+arrList.get(i));
				count++;
			}
			for(int i = count; i<other.size(); i++){
				wise.add(other.get(i));
			}
		}
		else{
			for(int i = 0; i<arrList.size(); i++){
				wise.add(other.get(i)+arrList.get(i));
			}
		}
		return wise;
	}

	public ArrayList<Integer> getArrList(){
		return arrList;
	}

	public static void main(String[] args){
		ArrayListPractice test1 = new ArrayListPractice();
		ArrayListPractice test2 = new ArrayListPractice();
		int[] appendix = {1,2,3};
		//testing appendArray()
		test1.appendArray(appendix);
		test2.appendArray(appendix);
		System.out.println("Expected result: [1, 2, 3]");
		System.out.println("Result: "+test1.getArrList());
		//testing isEqual()
		System.out.println("Expected result: true");
		System.out.println(test1.isEqual(test2.getArrList()));
		test2.appendArray(appendix);
		System.out.println("Expected result: false");
		System.out.println(test1.isEqual(test2.getArrList()));
		//testing sumElementWise()
		System.out.println("Expected result: [2, 4, 6, 1, 2, 3]");
		System.out.println(test1.sumElementWise(test2.getArrList()));
		//testing intRemoveAll()
		test2.intRemoveAll(1);
		System.out.println("Expected result: [2, 3, 2, 3]");
		System.out.println("Result: "+test2.getArrList());
	}

}
