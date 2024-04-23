package com.pks.ds.arrays.dimension;

/**
 * https://leetcode.com/explore/interview/card/microsoft/47/sorting-and-searching/154/
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(matrix, target));
    }

    boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = searchPotentialRow(matrix, target);
        if (rowIdx != -1)
            return binarySearchOverRow(rowIdx, matrix, target);
        return false;
    }

    private int searchPotentialRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int idx = matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][idx]) {
                return mid;
            } else if (matrix[mid][0] < target) low = mid + 1;
            else if (matrix[mid][0] > target) high = mid - 1;
        }
        return -1;
    }

    private boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {
        int low = 0;
        int high = matrix[rowIdx].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[rowIdx][mid] == target) {
                return true;
            } else if (matrix[rowIdx][mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
