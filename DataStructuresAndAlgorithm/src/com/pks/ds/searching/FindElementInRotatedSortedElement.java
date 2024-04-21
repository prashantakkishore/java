package com.pks.ds.searching;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * https://www.youtube.com/watch?v=QdVrY3stDD4
 */
public class FindElementInRotatedSortedElement {

    public static void main(String[] args) {
        int nums[] = {3, 4, 5, 1, 2};
        System.out.println(findElement(nums, 4));
    }

    public static int findElement(int[] nums, int target) {
        // 1: First find minimum element (Find pivot)
        // 2 : Set where to search depending on the target element
        // 3 : Do binary search

        // 1: Find minimum. left will have minimum
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // unsorted will have minimum
            if (nums[mid] > nums[right]) { // sorted , so skip this
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // we found minimum which is "left"
        // 2 : Set where to search depending on the target element
        int start = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right])
            left = start;
        else
            right = start;


        // 3 : Do binary search
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }


}
