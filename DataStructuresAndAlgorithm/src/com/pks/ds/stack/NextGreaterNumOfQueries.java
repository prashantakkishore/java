package com.pks.ds.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of n elements and q queries, for each query that has index i, find the next greater element and print its value. If there is no such greater element to its right then print -1.
 * Examples:
 *
 *
 * Input : arr[] = {3, 4, 2, 7, 5, 8, 10, 6}
 *         query indexes = {3, 6, 1}
 * Output: 8 -1 7
 * Explanation :
 * For the 1st query index is 3, element is 7 and
 * the next greater element at its right is 8
 *
 * For the 2nd query index is 6, element is 10 and
 * there is no element greater then 10 at right,
 * so print -1.
 *
 * For the 3rd query index is 1, element is 4 and
 * the next greater element at its right is 7.
 */
// https://www.geeksforgeeks.org/print-next-greater-number-q-queries/
public class NextGreaterNumOfQueries {


    public static void main(String[] args) {
        int[] input = { 63, 98, 23, 54, 12, 7, 20, 27, 64, 100 };
        int[] indexes = {3,6,1};
        nextGreaterElement1(input,indexes);
    }

    public static void nextGreaterElement1(int[] arr,int[] query) {
        int[] result = new int[arr.length];
        Stack<Integer> stacks = new Stack();
        for (int i = 0; i < arr.length; i++) {
            // push index so we can set NGE at right place
            if (stacks.empty()) {
                stacks.push(i);
            }
            else{
                while (!stacks.empty() && arr[i] > arr[stacks.peek()]) {
                    result[stacks.pop()] = arr[i];
                }
                stacks.push(i);
            }
        }

        // For remaining in stack is no greater element
        while (!stacks.empty()) {
            result[stacks.pop()] = -1;
        }
        Arrays.stream(query).forEach(x -> System.out.println(result[x]));
        System.out.println(Arrays.toString(result));
    }
}
