package com.pks.ds.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water/solution/
 * https://www.geeksforgeeks.org/trapping-rain-water/
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = { 0,1,0,2,1,0,1,3,2,1,2,1 };
        trap(height);
    }

    public static void trap(int[] height) {
        int [] leftMax = new int[height.length];
        int [] rightMax = new int[height.length];
        int [] waterTrap = new int[height.length];

        for (int i = 0; i < height.length; i++) {

            // left max
            leftMax[i] = height[i];
            for (int j = 0; j <= i; j++) {
                leftMax[i] = Math.max(leftMax[i], height[j]);
            }

            rightMax[i] = height[i];
            // right max
            for (int j = i + 1; j < height.length; j++) {
                rightMax[i] = Math.max(rightMax[i], height[j]);
            }



        }
        for (int j = 0; j < height.length; j++) {
            waterTrap[j] = Math.min(leftMax[j], rightMax[j]) - height[j];
        }

        int sum = Arrays.stream(waterTrap).sum();

        System.out.println(Arrays.toString(waterTrap));
        System.out.println(sum);
    }
}
