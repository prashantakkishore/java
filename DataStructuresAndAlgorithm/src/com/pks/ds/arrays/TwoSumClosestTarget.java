package com.pks.ds.arrays;

import java.util.Arrays;

public class TwoSumClosestTarget {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5};
        int target = 10;
        System.out.println(Arrays.toString(twoSumClosest(nums, target)));

        int [] nums1 = {-21, -67, -37, -18, 4, -65};
        int target1 = 0;
        System.out.println(Arrays.toString(twoSumClosest(nums1, target1)));

    }

    public static int[] twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int minDiff = Integer.MAX_VALUE;
        for (int lo = 0, hi = nums.length - 1; lo < hi; ) {
            int sum = nums[lo] + nums[hi];
            int diff = Math.abs(target - sum);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = nums[lo];
                result[1] = nums[hi];
            }
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                break;
            }
        }
        return result;
    }
}
