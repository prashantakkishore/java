package com.pks.ds.sorting.problems;

public class ArraySortedOrNot {

	public static int sortedOrNot(int[] arr, int n) {
		if (n == 1)
			return 1;
		return arr[n - 1] < arr[n - 2] ? 0 : sortedOrNot(arr, n - 1);

	}
	
	
	public static void main(String[] args) {
		int arr[] = { 1, 5, 9, 10, 15, 8 };
		System.out.println(sortedOrNot(arr, arr.length ));
		
	}
}
