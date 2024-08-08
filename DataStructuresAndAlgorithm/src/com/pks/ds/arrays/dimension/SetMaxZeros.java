package com.pks.ds.arrays.dimension;

import java.util.Arrays;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 *
 *  Input :  [1, 1, 1]
 *           [1, 0, 1]
 *           [1, 1, 1]
 *
 *  Output :  [1, 0, 1]
 *           [0, 0, 0]
 *           [1, 0, 1]
 */
public class SetMaxZeros {

    public static void main(String[] args) {
        int[][] arr = {{1,1,1}, {1,0,1}, {1,1,1}};
        System.out.println(Arrays.deepToString(setMaxZerosExtraSpace(arr)));
    }

    // Space O(N) + O(M)
    // Time O(2*(N*M))
    public static int[][] setMaxZerosExtraSpace(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        boolean zeroRows[] = new boolean[rows];
        boolean zeroCols[] = new boolean[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0){
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zeroRows[i] || zeroRows[j]){
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    // Space O(1)
    // Time O(2*(N*M))
    public static int[][] setMaxZeros(int[][] arr){

        return arr;
    }
}
