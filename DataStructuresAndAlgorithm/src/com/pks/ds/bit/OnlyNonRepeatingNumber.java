package com.pks.ds.bit;

/**
 * Find the only non- repeating number in an array where every element repeats twice
 * Solution : XOR
 * 1 - XOR or same num is 0
 * 2 - XOR of number with 0 is the number
 */
public class OnlyNonRepeatingNumber {

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 4, 3, 5, 1, 3, 2};
        System.out.println(findNonRepeating(arr));
    }

    private static int findNonRepeating(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }
}
