package com.pks.ds.searching;

import java.util.HashSet;
import java.util.Set;

import com.pks.ds.sorting.SortBase;

public class ArrayHasDuplicates extends SortBase {

	public static void main(String args[]) {
		int[] arr = { 4, 2, 4, 5, 2, 3, 1 };
		isDuplicate_by_negation(arr);
		int[] arr2 = { 80, 20, 30, 10, 90, 60, 0, 70, 40, 20, 10 };
		isDuplicate_by_hashing(arr2);

	}
	/**
	 * Array of n+2 elements
	 * Elements of the array are in range 1 to n
	 * Time Complexity: O(n)
	 * Auxiliary Space: O(1)
	 */
	private static void isDuplicate_by_negation(int[] arr) {

		int i;
		int size = arr.length;
		System.out.println("The repeating elements are : ");

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] > 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}
	}

	/**
	 * Time Complexity: O(n)
	 * Auxiliary Space: O(n)
	 */
	public static void isDuplicate_by_hashing(int arr[]) {
		Set<Integer> dupes = new HashSet<Integer>();
		for (Integer i : arr) {
			if (!dupes.add(i)) {
				System.out.println("Duplicate element in array is : " + i);
			}
		}

	}


}
