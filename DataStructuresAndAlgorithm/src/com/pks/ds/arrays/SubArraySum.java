package com.pks.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Kadan's algo
 */
public class SubArraySum {

    public static void main(String[] args) {
        int [] arr = new int []{4,2,2,7,1,2,8,10};
        int targetSum = 8;
        System.out.println(sum2(arr, targetSum));

    }

    public static int sum2(int[] arr, int target){

        Map<Integer, Integer> mapping = new HashMap<>();
        mapping.put(0,1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (mapping.containsKey(sum - target))
                ans += mapping.get(sum - target);

            mapping.put(sum, mapping.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }


    // O(n2)
    public static int sum(int[] arr, int k){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum == k){
                    count ++;
                }
            }
        }
        return count;
    }
}
