package com.pks.ds.searching;

import java.util.Arrays;

/**
 * Can use counting sort too.
 * Input : 	[ 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 ]
 * Output : [ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 ]
 */
public class Separate0And1InArray {

	public static void separate0And1(int[] arr) {

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			while (arr[left] == 0)
				left++;
			while (arr[right] == 1)
				right--;

			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;

		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
		separate0And1(arr);
		System.out.println(Arrays.toString(arr));

	}

}
