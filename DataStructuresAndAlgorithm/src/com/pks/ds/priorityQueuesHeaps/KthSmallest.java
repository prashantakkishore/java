package com.pks.ds.priorityQueuesHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

    public static void main(String[] args) {
        int arr[] = {5, 20, 10, 7, 1};
        int K = 3;
        kthSmallest(arr, K);
    }

    private static void kthSmallest(int[] arr, int k) {

        Comparator<Integer> comparator = (a,b) -> {
            int value =  a.compareTo(b);

            // elements are sorted in reverse order
            if (value > 0) {
                return -1;
            }
            else if (value < 0) {
                return 1;
            }
            else {
                return 0;
            }
        };

        PriorityQueue<Integer> queue = new PriorityQueue(comparator);
        for (int j = 0; j < arr.length; j++) {
            queue.add(arr[j]);
            if(queue.size() > k)
                queue.poll();
        }

        System.out.println(k + " K lowest " + queue.poll());


    }


}
