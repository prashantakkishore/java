package com.pks.ds.recursion;

public class ArraySortedOrNot {

	public static boolean isArraySorted(int[] arr, int index) {
		if (index == 1)
			return true;
		return arr[index - 1] < arr[index - 2] ? false : isArraySorted(arr,
				index - 1);

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(isArraySorted(arr, arr.length)); // true
		
		int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 10 };
		System.out.println(isArraySorted(arr1, arr1.length)); // false
	}

}
