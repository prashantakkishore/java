package com.pks.ds.arrays;

import java.util.Arrays;

/**
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1,1,1,1,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int maxPastOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                maxOnes++;
            } else {
                maxPastOnes = Math.max(maxOnes, maxPastOnes);
                maxOnes = 0;
            }
        }
        int maxConsecutiveOnes = Math.max(maxOnes, maxPastOnes);
        System.out.println(maxConsecutiveOnes);
        System.out.println(Arrays.toString(nums));
        return maxConsecutiveOnes;
    }
}
