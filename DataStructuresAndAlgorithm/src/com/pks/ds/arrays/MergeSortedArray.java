package com.pks.ds.arrays;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should
 * be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 7, 0, 0, 0};
        int totalNum1 = 3;
        int[] nums2 = {1, 5, 6};
        int totalNum2 = 3;
        mergeCompareEnd(nums1, totalNum1, nums2, totalNum2);
    }

    // O(m+n)
    // uses extra array to copy nums1
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        int p1 = 0;
        int p2 = 0;
        int num1Index = 0;

        while (p2 != n && p1 != m) {
            if (nums1Copy[p1] < nums2[p2]) {
                nums1[num1Index++] = nums1Copy[p1++];
            } else {
                nums1[num1Index++] = nums2[p2++];
            }
        }

        // One of the array finished, copy rest of the other array into to final nums array
        if (p1 == m) {
            for (int i = p2; i < nums2.length; i++) {
                nums1[num1Index++] = nums2[i];
            }
        } else {
            for (int i = p1; i < nums1.length; i++) {
                nums1[num1Index++] = nums1[i];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }

    // O(m+n)
    // No extra space
    // Ideal -- start comparing from end
    public static void mergeCompareEnd(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m-1;
        int p2 = n-1;
        int num1Index = m+n-1;

        while (p2 >= 0 && p1 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[num1Index--] = nums1[p1--];
            } else {
                nums1[num1Index--] = nums2[p2--];
            }
        }

        // One of the array finished, copy rest of the other array into to final nums array
        if (p1 < 0) {
            for (int i = p2; i >= 0; i--) {
                nums1[num1Index--] = nums2[i];
            }
        } else {
            for (int i = p1; i >= 0; i--) {
                nums1[num1Index--] = nums1[i];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }
}
