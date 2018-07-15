package com.pks.ds.sorting;

/**
 * Avg: O(n*n)
 * Worst: O(n*n)
 * Repeatedly swapping the adjacent elements if they are in wrong order.
 *
 */

public class BubbleSort extends SortBase {

	public static void sort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	/**
	 * If input is already sorted or partially sorted the iterations can be minimized
	 * @param arr
	 */
	public static void sort_Optimized(int arr[]) {
		int n = arr.length;
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++) {
			swapped = false;
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j] and arr[j+1]
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			// IF no two elements were
			// swapped by inner loop, then break
			if (swapped == false)
				break;
		}
	}

	public static void main(String args[]) {

		int arr[] = { 1,2,3,4,9,6,5 };
		//sort(arr);
		sort_Optimized(arr);
		print(arr);
	}
}
