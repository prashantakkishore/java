package com.pks.ds.searching;

/**
 * 1 - get sum of numbers sum = n*(n+1)/2 2 - 
 * substract all number sum from sum , will get missing
 *
 */
public class FindAMissingNumber {

	/**
	 * 1 - get sum of numbers sum = n*(n+1)/2 2 - substract all number sum from
	 * sum , will get missing.
	 * 
	 * Below added 1 in formula as 1 element is missing.
	 */
	public static int missingNum_sum(int a[], int n) {
		int i, total;
		total = (n + 1) * (n + 2) / 2;
		for (i = 0; i < n; i++)
			total -= a[i];
		return total;
	}

	// Function to find missing number
	public static int missingNum_xor(int a[], int n) {
		int x1 = a[0];
		int x2 = 1;

		/*
		 * For xor of all the elements in array
		 */
		for (int i = 1; i < n; i++)
			x1 = x1 ^ a[i];

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (int i = 2; i <= n + 1; i++)
			x2 = x2 ^ i;

		return (x1 ^ x2);
	}

	public static void main(String args[]) {
		int a[] = { 1, 2, 3, 5, 6 };
		int miss = missingNum_sum(a, 5);
		System.out.println(miss);
		System.out.println(missingNum_xor(a, 5));

	}

}
