package com.pks.ds.arrays;

import java.util.Arrays;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * <p>
 * After doing so, return the array.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 */
public class ReplaceGreatestToRight {

    public static void main(String[] args) {
        int[] nums = {17, 18, 5, 4, 6, 1};
        greatestToRight_1(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void greatestToRight_1(int arr[]) {
        int size = arr.length;

        // Initialize the next greatest element
        int maxFromRight = arr[size - 1];

        // The next greatest element for the rightmost
        // element is always -1
        arr[size - 1] = -1;

        // Replace all other elements with the next greatest
        for (int i = size - 2; i >= 0; i--) {
            // Store the current element (needed later for
            // updating the next greatest element)
            int temp = arr[i];

            // Replace current element with the next greatest
            arr[i] = maxFromRight;

            // Update the greatest element, if needed
            if (maxFromRight < temp)
                maxFromRight = temp;
        }
    }

    // O(n*n) Bad
    public static void greatestToRight(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = max(i + 1, nums);
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int max(int startIndex, int[] nums) {
        int max = 0;
        if (startIndex == nums.length)
            return -1;
        for (int i = startIndex; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
