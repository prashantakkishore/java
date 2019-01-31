package com.pks.ds.searching;
/**
 * Input :  [0,0,0,0,0,1,1]
         	[0,0,0,1,1,1,1]
         	[0,0,0,0,0,0,1]
         	[0,0,0,1,1,1,1]
         	[0,0,1,1,1,1,1]
         	[0,1,1,1,1,1,1]
         	[1,1,1,1,1,1,1]
 * Output : 2 row
**/
public class Max0InARowInMatrix {
	
	
	public static int max0Row(int[][] arr, int dim) {

		int row = 0;
		int column = 0;
		int maxCount = 0;
		int maxCountRow = 0;

		while (row <= (dim - 1)) {

			if (arr[row][column] == 0) {
				if (column < (dim - 1)) {
					column++;
				} else
					row++;
				maxCount++;
				maxCountRow = row;
			} else if (arr[row][column] == 1) {
				row++;
			}

		}
		System.out.println("Max count row " + (maxCountRow + 1));
		return maxCount;

	}
	
	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 1, 1, 1, 1, 1 }, 
						{ 0, 0, 0, 1, 1, 1, 1 },
						{ 0, 0, 0, 0, 0, 1, 1 }, 
						{ 0, 0, 0, 0, 0, 1, 1 },
						{ 0, 0, 1, 1, 1, 1, 1 }, 
						{ 0, 0, 0, 0, 0, 0, 1 },
						{ 0, 0, 0, 0, 0, 1, 1 } };
		System.out.println(max0Row(arr, 7));
	}

}
