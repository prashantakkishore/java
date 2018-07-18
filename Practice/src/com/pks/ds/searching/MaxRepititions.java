package com.pks.ds.searching;

public class MaxRepititions {
	/**
	 * Moore’s Voting Algorithm
	 * @param arr
	 * @return
	 */
	public static int maxRepititionsNum(int[] arr) {

		int count = 0;
		int maxRepititionsNum = 0;

		for (int i = 0; i < arr.length; i++) {

			if (count == 0) {
				maxRepititionsNum = arr[i];
				count++;
			} else if (maxRepititionsNum == arr[i]) {
				count++;
			} else {
				count--;
			}
		}

		return maxRepititionsNum;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 5, 6, 1, 1, 2, 2, 1, 1, 1, 1, 7, 1, 1 };
		System.out.println(maxRepititionsNum(arr));
	}
}
