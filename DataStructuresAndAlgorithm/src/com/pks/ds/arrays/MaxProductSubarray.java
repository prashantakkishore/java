package com.pks.ds.arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaxProductSubarray {

    public static void main(String[] args) {
        int [] arr = {2,3,-2,4};
        System.out.println(maxProductSubArray(arr));
    }

    private static int maxProductSubArray(int[] arr) {

        int minSoFar = arr[0];
        int maxSoFar = arr[0];
        int maxOverall = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int tmpMaxSoFar = maxSoFar;
            // Take min and max both to consider positive vs negative numbers
            // Min of negative can give max value if multiplied by a negative
            maxSoFar = Math.max(Math.max(arr[i] , tmpMaxSoFar * arr[i]),  minSoFar * arr[i]);
            minSoFar = Math.min(Math.min(arr[i] , tmpMaxSoFar * arr[i]),  minSoFar * arr[i]);
            maxOverall = Math.max(maxOverall, maxSoFar);
        }

        return maxOverall;
    }


}
