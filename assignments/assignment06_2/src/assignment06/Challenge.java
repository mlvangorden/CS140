package assignment06;

public class Challenge{
	private int[][] array;
	int[] colSums;
	int[] rowSums;
	int diagSum;
	int antidiagSum;
	
	public Challenge(int[][] array, int[] colSums, int[] rowSums, int diagSum, int antidiagSum) {
		this.array = array;
		this.colSums = colSums;
		this.rowSums = rowSums;
		this.diagSum = diagSum;
		this.antidiagSum = antidiagSum;
	}
	
	public String view(int[][] arr) {
		StringBuilder build = new StringBuilder();
		build.append(" \t \t \t \t");
		build.append(antidiagSum+"\n");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				build.append(arr[i][j]+"\t");
			}
			build.append(rowSums[i]+"\n");
		}
		for(int i = 0; i<colSums.length; i++) {
			build.append(colSums[i]+"\t");
		}
		build.append(diagSum+"\n");
		
		return build.toString();
	}
	
	public int countZeros(int[][] arr) {
		int retVal = 0;
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				if(arr[i][j] == 0) retVal++;
			}
		}
		return retVal;
	}
	
	class Pair{
		int row; int col;
		public Pair(int x, int y) {
			row = x;
			col = y;
		}
	}
	
	public Pair nextZero(int[][] arr) {
		if(countZeros(arr) > 0) {
			for(int i = 0; i<arr.length; i++) {
				for(int j = 0; j<arr[i].length; j++) {
					if(arr[i][j] == 0) {
						return new Pair(i, j);
					}
				}
			}
		}
		return new Pair(0, 0);
	}
	
	public boolean feasible(int[][] arr) {
		if(Array2Dexamples.antiDiagonalSum(arr) > antidiagSum) return false;
		if(Array2Dexamples.diagonalSum(arr) > diagSum) return false;
		for(int i = 0; i < rowSums.length; i++) {
			if(Array2Dexamples.rowSums(arr)[i] > rowSums[i]) return false;
		}
		for(int i = 0; i < colSums.length; i++) {
			if(Array2Dexamples.columnSums(arr)[i] > colSums[i]) return false;
		}
		
		return true;
	}
	
	public boolean solved(int[][] arr) {
		if(Array2Dexamples.antiDiagonalSum(arr) != antidiagSum) return false;
		if(Array2Dexamples.diagonalSum(arr) != diagSum) return false;
		for(int i = 0; i < rowSums.length; i++) {
			if(Array2Dexamples.rowSums(arr)[i] != rowSums[i]) return false;
		}
		for(int i = 0; i < colSums.length; i++) {
			if(Array2Dexamples.columnSums(arr)[i] != colSums[i]) return false;
		}
		
		return true;
	}
	
	private int[][] duplicate(int[][] arr){
		int[][] retVal = new int[4][4];
		for(int i = 0; i<retVal.length; i++) {
			for(int j = 0; j<retVal[i].length; j++) {
				retVal[i][j] = arr[i][j];
			}
		}
		return retVal;
	}
	
	public void solve(int[][] arr) {
		if(countZeros(arr) > 0) {
			Pair p = nextZero(arr);
			for(int i = 1; i<10; i++) {
				arr[p.row][p.col] = i;
				if(countZeros(arr) == 0 && solved(arr)) System.out.println("\nSOLUTION\n"+view(arr));
				if(countZeros(arr) > 0 && feasible(arr)) solve(duplicate(arr));
			}
		}
	}
	
	public static void main(String[] args) {
		Challenge puzzle = new Challenge(new int[][]{{2,0,0,0},{0,0,0,1},{0,5,0,0},{0,0,6,0}},
				new int[]{8,9,15,28}, new int[]{15,11,17,17}, 14, 20);
		System.out.println(puzzle.view(puzzle.array));
		puzzle.solve(puzzle.duplicate(puzzle.array));
	}
}