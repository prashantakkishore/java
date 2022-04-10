package com.pks.ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * **Only one valid answer exists.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] num = {3, 2, 4};
        int target = 6;
        //bruteForce(num,target);
        //mapSolutionTwoPass(num,target);
        mapSolutionOnePass(num, target);
    }

    //O(n2)
    public static void bruteForce(int[] num, int target) {
        int[] output = new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (i != j && num[i] + num[j] == target) {
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        System.out.println(Arrays.toString(output));
    }

    //O(n)
    public static void mapSolutionTwoPass(int[] num, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], i);
        }
        for (int i = 0; i < num.length; i++) {
            int complement = target - num[i];
            if (map.containsKey(complement)) {
                output[0] = i;
                output[1] = map.get(complement);
            }
        }
        System.out.println(Arrays.toString(output));
    }

    //O(n)
    //Best
    public static void mapSolutionOnePass(int[] num, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int complement = target - num[i];
            if (map.containsKey(complement)) {
                output[0] = i;
                output[1] = map.get(complement);
            }
            map.put(num[i], i);
        }
        System.out.println(Arrays.toString(output));
    }
}
