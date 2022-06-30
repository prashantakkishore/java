package com.pks.ds.arrays;

import java.util.PriorityQueue;

public class SecondLargest {


    public static void main(String[] args) {
        int [] arr = {6, 8, 2 , 4 , 3 , 1, 5, 7};
        //System.out.println(findSecondLargest(arr) );

        findSecondLargestPQ(arr);
    }

    private static void findSecondLargestPQ(int[] arr) {

        PriorityQueue pq = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > 2){
                pq.remove();
            }
        }

        System.out.println("Second highest " + pq.remove());
        System.out.println("Highest " + pq.remove());


    }


}
