package com.pks.ds.arrays;

import java.util.*;

public class KSmallestPairsSum {

    public static void main(String[] args) {
        int [] nums1 = {1,1,2};
        int [] nums2 = {1,2,3};
        int k = 3;
        System.out.println(kSmallestPairs2(nums1, nums2, 2));
    }

    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(i -> i.get(0) + i.get(1)));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                minHeap.add(Arrays.asList(nums1[i], nums2[j]));
            }
        }
        List<List<Integer>> result = new ArrayList<>()  ;
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll());
        }

        return result;
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Pair[] pairs = new Pair[nums1.length * nums2.length];
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Pair pair = new Pair(nums1[i], nums2[j]);
                pairs[count++] = pair;
            }
        }
        Arrays.sort(pairs, Comparator.comparing(i -> i.sum));
        List<List<Integer>> result = new ArrayList<>()  ;
        for (int i = 0; i < k; i++) {
            Pair p = pairs[i];
            List<Integer> list = new ArrayList<>();
            list.add(p.num1);
            list.add(p.num2);
            result.add(list);
        }
        return result;
    }

    static class Pair{
        int num1;
        int num2;
        int sum;
        Pair(int num1, int num2){
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }
    }
}
