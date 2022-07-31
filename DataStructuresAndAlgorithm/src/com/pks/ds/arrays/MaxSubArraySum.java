package com.pks.ds.arrays;

public class MaxSubArraySum {

	public static void main(String[] args) {
		int arr[] = { -2, -5, -6, -2, -3, -1, -5, -6 };
		int max_sum = maxSubArraySum(arr);

		System.out.println("Maximum contiguous sum is " + max_sum);
	}

	public static int maxSubArraySum(int a[]) {

		int size = a.length;
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i = 0; i < size; i++) {
			currSum = currSum + a[i];
			if (maxSum < currSum)
				maxSum = currSum;
			if (currSum < 0)
				currSum = 0;
		}
		return maxSum;
	}

}
