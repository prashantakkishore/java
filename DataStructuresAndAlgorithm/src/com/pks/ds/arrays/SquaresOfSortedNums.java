package com.pks.ds.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted
 * in non-decreasing order.
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Hint: Compare nums without sign
 */
public class SquaresOfSortedNums {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] resultArray = new int[nums.length];
        int resultArrayIndex = nums.length - 1;
        while (left < right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                resultArray[resultArrayIndex--] = nums[right] * nums[right];
                right--;
            } else {
                resultArray[resultArrayIndex--] = nums[left] * nums[left];
                left++;
            }
        }

        return resultArray;
    }

}
