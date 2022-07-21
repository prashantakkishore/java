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
        System.out.println(Arrays.deepToString(setMaxZeros(arr)));
    }

    // WRONG ---
    public static int[][] setMaxZeros(int[][] arr){
        int length = arr.length;
        int left, right, up, down = 0;


        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0 && (i == 1 && j == 1)) { // WRONG --- If second condition not there
                    // it will fail as converted zeros will also mark row and column as zero. So we need
                    // to identify which was the original zero and which was converted

                    // loop till 1,1 ->
                    // up - 0 -> J-1 -> 0,I
                    // down - length -1 -> I+1 -> L,J
                    // left - 0 -> I,J -1 -> 0
                    // right - length -1 -> I,J -1 -> L

                    up = i - 1;
                    while (up >= 0) {
                        arr[up--][j] = 0;
                    }
                    down = i + 1;
                    while (down <= length - 1) {
                        arr[down++][j] = 0;
                    }
                    left = j - 1;
                    while (left >= 0) {
                        arr[i][left--] = 0;
                    }
                    right = j + 1;
                    while (right <= length - 1) {
                        arr[i][right++] = 0;
                    }

                }
            }

        }
        return arr;
    }
}
