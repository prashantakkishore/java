package com.pks.ds.searching;
/**
 * All numbers appears even number of times except one, find that number 
 * occurs odd number of times.
 */
public class OddOccuranceOfANumber {

	public static int oddAppearingNumber(int[] arr) {

		int x1 = arr[0];
		int n = arr.length;
		for (int i = 1; i < n; i++)
			x1 = x1 ^ arr[i];

		return x1;

	}

	public static void main(String[] args) {
		int[] arr = { 80, 20, 30, 10, 90, 60, 60, 90, 30, 20, 80 };
		int num = oddAppearingNumber(arr);
		System.out.println(num);
	}

}
