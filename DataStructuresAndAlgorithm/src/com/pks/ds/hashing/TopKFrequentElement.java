package com.pks.ds.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/explore/interview/card/amazon/79/sorting-and-searching/2995/
 * https://www.youtube.com/watch?v=CIDmkhR65RY
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Solution:
 * Avoid sorting / Priprity queue
 * 1 - Map the Priority queue for all elements- O(nlogn)
 * 2 - Map the Priority queue for K elements- O(klogn)
 * 3 - bucket array (As below)
 */

public class TopKFrequentElement {


    public static void main(String[] args) {
        int[] elements = {1,2,5,5,2,3,3,4,5,4,6,5,1,3,2};
        topKFrequent(elements,3);
    }

    // O(n)
    private static void topKFrequent(int[] elements, Integer topN) {
        Map<Integer, Integer> mapping = new HashMap<>();
        // Add one more to map if all elements are same
        ArrayList<ArrayList<Integer>> bucketArray = new ArrayList<>(elements.length  + 1 );
        for (int i = 0; i < elements.length  + 1; i++) {
            bucketArray.add(new ArrayList<>());
        }

        // Find element frequency
        for (int i = 0; i < elements.length; i++) {
            mapping.put(elements[i] , mapping.getOrDefault(elements[i] , 0) + 1);
        }

        // set in bucket array
        for (Integer key: mapping.keySet()){
            int frequency = mapping.get(key);
            if(bucketArray.get(frequency) == null)
                bucketArray.add(frequency, new ArrayList<>());
            bucketArray.get(frequency).add(key);
        }

        // get top from left
        int top = 0;
        for (int i = elements.length ; i >= 0 ; i--) {
            if (bucketArray.get(i) != null) {
                for (Integer l : bucketArray.get(i)) {
                    System.out.println(l);
                    top++;
                }
                if(top == topN){
                    break;
                }
            }
        }
    }
}
