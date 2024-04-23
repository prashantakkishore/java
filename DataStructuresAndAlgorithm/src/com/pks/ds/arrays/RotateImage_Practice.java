package com.pks.ds.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/202/
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 */
public class RotateImage_Practice {

    public static void main(String[] args) {
        int[][] arr = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
        System.out.println(Arrays.deepToString(rotate2(arr)).replace("], ", "]\n"));
    }

    // Matrix Transpose https://www.youtube.com/watch?v=SA867FvqHrM
    public static int[][] rotate2(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j  = i + 1; j  < N; j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j  = N/2; j  < N; j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][N-j-1];
                matrix[i][N-j-1] = tmp;
            }
        }
        return matrix;
    }



}
