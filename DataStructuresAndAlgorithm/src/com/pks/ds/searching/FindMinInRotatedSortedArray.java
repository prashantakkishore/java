package com.pks.ds.searching;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * https://www.youtube.com/watch?v=QdVrY3stDD4
 */
public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        int nums[] = {5,1,2,3,4};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] arr) {
        int left = 0, mid = 0;
        int right = arr.length - 1;

        // idea is to find increasing subarray, there will always one, left or right
        while (left < right) {
            mid = (left + right) / 2;
            // this means right side is shorted, so discard right array
            if (arr[mid] <= arr[right])
                right = mid;
            // this means left side is shorted, so discard left array
            else
                left = mid + 1;
        }

        return arr[left];
    }
}
