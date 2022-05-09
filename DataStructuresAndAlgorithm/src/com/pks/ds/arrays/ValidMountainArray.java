package com.pks.ds.arrays;

public class ValidMountainArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,8,7,6,5,4,6,9};
        System.out.println(validMountainArray(nums));
    }
    public static boolean validMountainArray(int[] nums) {
        int i = 0;
        int N = nums.length-1;
        while (i< N && nums[i] < nums[i+1]) {
            i++;
        }
        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        while (i< N && nums[i] > nums[i+1]) {
            i++;
        }

        return nums.length == i +1 ? true: false;

    }
}
