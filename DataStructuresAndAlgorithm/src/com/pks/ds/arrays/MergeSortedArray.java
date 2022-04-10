package com.pks.ds.arrays;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should
 * be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int totalNum1 = 3;
        int[] nums2 = {2, 5, 6};
        int totalNum2 = 3;
        merge(nums1,totalNum1, nums2, totalNum2);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

       int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        int p1 = 0;
        int p2 = 0;
        int num1Index = 0;

        while(p2!=n-1 && p1!=m-1){
            if(nums1Copy[p1] < nums2[p2]){
                nums1[num1Index++] = nums1Copy[p1++];
            } else {
                nums1[num1Index++] = nums2[p2++];
            }
        }




        System.out.println(Arrays.toString(nums1));
    }
}
