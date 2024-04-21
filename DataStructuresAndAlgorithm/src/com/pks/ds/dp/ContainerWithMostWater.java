package com.pks.ds.dp;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {


    // O(n2)
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int localArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(localArea, maxArea);
            }
        }
        return maxArea;
    }
    // Best O(n)
    public static int maxAreaTwoPointer(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int localArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(localArea, maxArea);
            if (height[left] < height[right])
                left++;
            else right++;
        }
        return maxArea;
    }
}
