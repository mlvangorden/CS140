package assignment06;
import java.util.Arrays;

public class Array2Dexamples{
	
	public static int[] rowSums(int[][] arr) {
		int[] retVal = new int[arr.length];
		for(int i = 0; i<arr.length; i++) {
			int temp = 0;
			for(int j = 0; j<arr[i].length; j++) {
				temp += arr[i][j];
			}
			retVal[i] = temp;
		}
		return retVal;
	}
	
	public static int[] columnSums(int[][] arr) {
		int size = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].length > size) size = arr[i].length;
		}
		
		int[] retVal = new int[size];
		for(int i = 0; i<size; i++) {
			int temp = 0;
			for(int j = 0; j<arr.length; j++) {
				if(arr.length>j && arr[j].length>i) temp += arr[j][i];
			}
			retVal[i] = temp;
		}
			
		return retVal;
	}
	
	public static double[] rowAverages(int[][] arr) {
		double[] retVal = new double[arr.length];
		int[] sums = rowSums(arr);
		for(int i = 0; i<arr.length; i++) {
			retVal[i] = (double)sums[i]/(double)arr[i].length;
		}
		return retVal;
	}
	
	public static double[] columnAverages(int[][] arr) {
		int size = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].length > size) size = arr[i].length;
		}
		
		double[] retVal = new double[size];
		for(int i = 0; i<size; i++) {
			int temp = 0;
			int mean = 0;
			for(int j = 0; j<arr.length; j++) {
				if(arr.length>j && arr[j].length>i) {
					temp += arr[j][i];
					mean++;
					}
			}
			retVal[i] = (double)temp/(double)mean;
		}
			
		return retVal;
	}
	
	public static int diagonalSum(int[][] arr) {
		for(int i = 0; i<arr.length; i++) {
			if(arr == null || arr[i] == null || arr.length != arr[i].length) 
				throw new IllegalArgumentException("Must input a square 2D array");
		}
		int retVal = 0;
		for(int i = 0; i<arr.length; i++) {
			retVal += arr[i][i];
		}
		return retVal;
	}
	
	public static int antiDiagonalSum(int[][] arr) {
		for(int i = 0; i<arr.length; i++) {
			if(arr == null || arr[i] == null || arr.length != arr[i].length) 
				throw new IllegalArgumentException("Must input a square 2D array");
		}
		int retVal = 0;
		for(int i = 0; i<arr.length; i++) {
			retVal += arr[i][arr.length-1-i];
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		int[][] test = {{1,7,2,4}, {3,5}, {4,0,2,1,4}};
		System.out.println(Arrays.toString(rowSums(test)));
		System.out.println(Arrays.toString(columnSums(test)));
		System.out.println(Arrays.toString(rowAverages(test)));
		System.out.println(Arrays.toString(columnAverages(test)));
		
		int[][] test1 = {{1,7,2,4}, {3,5,6,1}, {5,5,1,1}, {4,0,2,1,}};
		System.out.println(diagonalSum(test1));
		System.out.println(antiDiagonalSum(test1));
	}
}