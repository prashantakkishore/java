package com.pks.ds.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Many qus from this -
 *  1 - Find second smallest/ largest from array
 *  2 - Find the largest pair sum in an unsorted array
 */
public class FindSecondLargest {

    public static void main(String[] args) {
        int [] arr = {6, 8, 2 , 4 , 3 , 1, 5, 7};
        //System.out.println(findSecondLargest(arr) );

        findSecondLargestPQ(arr);
    }

    public static int  findSecondLargest(int [] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("Max 2 sum " + (largest + secondLargest));
        return secondLargest;

    }

    public static void  findSecondLargestPQ(int [] arr){
        // default min , smaller will be removed.
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
