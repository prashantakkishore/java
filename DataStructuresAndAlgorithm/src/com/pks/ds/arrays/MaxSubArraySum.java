package com.pks.ds.arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
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
