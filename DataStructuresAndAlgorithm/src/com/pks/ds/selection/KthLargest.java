package com.pks.ds.selection;

public class KthLargest {

	/**
	 * Logic is of Selection sort. Run outer loop k times .
	 * O(n * k)
	 */
	public static int kthLargest(int[] arr, int k) {

		for (int i = 0; i < k; i++) {
			int max_idx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[max_idx]) {
					max_idx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[max_idx];
			arr[max_idx] = tmp;
		}

		return arr[k-1];
	}

	public static void main(String[] args) {
		int arr[] = { 1,2,3,4,9,6,5 };
		System.out.println(kthLargest(arr, 3));
	}

}
