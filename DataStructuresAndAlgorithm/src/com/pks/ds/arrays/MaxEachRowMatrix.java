package com.pks.ds.arrays;

import java.util.Arrays;

/**
 * Input :  [1, 2, 3]
         	[1, 4, 9]
         	[76, 34, 21]

Output :
3
9
76

Input : [1, 2, 3, 21]
        [12, 1, 65, 9]
        [1, 56, 34, 2]
Output :
21
65
56

 *
 *
 */

public class MaxEachRowMatrix {
      public static void main(String[] args) {
        int[][] array = {{1,2,3}, {1,4,9}, {76,34,21}};
        int[] output = new int[3];
        for(int i = 0; i< array.length; i++){
            int rowTop = 0;
            for(int j = 0 ; j < array.length ; j ++){
                rowTop = Math.max(rowTop, array[i][j]);
            }
            output[i] = rowTop;
        }
        System.out.println(Arrays.toString(output));
    }
}
