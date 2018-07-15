package com.pks.ds.sorting.problems;

import com.pks.ds.sorting.SortBase;

/**
 * Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1} 
 * Outpou : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 *
 */
public class SortArrayOf012 extends SortBase {

	public static void sort(int[] arr) {

		int lo = 0;
		int hi = arr.length - 1;
		int mid = 0;

		while (mid <= hi) {

			switch (arr[mid]) {

			case 0:
				int temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;
				mid++;
				lo++;
				break;

			case 1:
				mid++;
				break;

			case 2:
				int temp1 = arr[hi];
				arr[hi] = arr[mid];
				arr[mid] = temp1;
				hi--;
				break;

			}

		}

	}

	public static int[] counting_sort(int[] arr) {

		int count_arr[] = new int[3]; // For 0 1 and 2

		for (int i = 0; i < arr.length; i++) {
			++count_arr[arr[i]];
		}

		for (int j = 1; j < count_arr.length; j++) {
			count_arr[j] = count_arr[j - 1] + count_arr[j]; // sum count array
		}

		int output_arr[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			output_arr[count_arr[arr[i]] - 1] = arr[i];
			count_arr[arr[i]]--;
		}

		return output_arr;

	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		sort(arr);
		print(arr);
		print(counting_sort(arr));

	}

}
