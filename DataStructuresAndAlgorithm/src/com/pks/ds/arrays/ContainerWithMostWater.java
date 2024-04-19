package com.pks.ds.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int [] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaContainerWater2(arr));
    }

    // O(n)
    public static int maxAreaContainerWater2(int [] arr) {
        int maxArea = 0;
        int left = 0;
        int right = arr.length -1;
       while(left < right) {
           int areaSoFar = (right - left) * Math.min(arr[left], arr[right]);
           maxArea = Math.max(areaSoFar, maxArea);
           if (arr[left] < arr[right])
               left++;
           else
               right--;
       }
        return maxArea;
    }

    // O(n2)
    public static int maxAreaContainerWater(int [] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                int areaSoFar = (j - i) * Math.min(arr[i], arr[j]);
                maxArea = Math.max(areaSoFar, maxArea);
            }
        }
        return maxArea;
    }

}
