package com.pks.ds.searching;

import java.util.Arrays;

public class ShuffleA1B1 {

	public static void shuffle(int[] arr) {
		int temp;
		int n = arr.length / 2;

		for (int start = n + 1, j = n + 1, done = 0, i; done < 2 * n - 2; done++) {
			if (start == j) {
				start--;
				j--;
			}

			i = j > n ? j - n : j;
			j = j > n ? 2 * i : 2 * i - 1;
			temp = arr[start];
			arr[start] = arr[j];
			arr[j] = temp;

		}
	}

	static void shufle_divide_conquer(int a[], int f, int l) {
		// If only 2 element, return
		if (l - f == 1)
			return;

		// finding mid to divide the array
		int mid = (f + l) / 2;

		// using temp for swapping first half of second array
		int temp = mid + 1;

		// mmid is use for swapping second half for first array
		int mmid = (f + mid) / 2;

		// Swapping the element
		for (int i = mmid + 1; i <= mid; i++) {
			// swap a[i], a[temp++]
			int temp1 = a[i];
			a[i] = a[temp];
			a[temp++] = temp1;
		}

		// Recursively doing for first half and second half
		shufle_divide_conquer(a, f, mid);
		shufle_divide_conquer(a, mid + 1, l);
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26 };
		shuffle(arr);
//		shufle_divide_conquer(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}
}
