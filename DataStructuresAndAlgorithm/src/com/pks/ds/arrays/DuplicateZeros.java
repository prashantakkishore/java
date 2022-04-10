package com.pks.ds.arrays;

import java.util.Arrays;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return anything from your function.
 *
 * Input:  [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 *
 * Input:   [8,4,5,0,0,0,0,7]
 * Output: [8,4,5,0,-,-,-,-]
 */

public class DuplicateZeros {

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(nums);
    }

    public static void duplicateZeros(int[] nums) {
        int possibleDups = 0;
        int length = nums.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length - possibleDups; left++) {

            // Count the zeros
            if (nums[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length - possibleDups) {
                    // For this zero we just copy it without duplication.
                    nums[length] = 0;
                    length -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (nums[i] == 0) {
                nums[i + possibleDups] = 0;
                possibleDups--;
                nums[i + possibleDups] = 0;
            } else {
                nums[i + possibleDups] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
