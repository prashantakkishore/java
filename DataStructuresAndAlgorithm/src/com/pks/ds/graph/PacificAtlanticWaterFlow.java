package com.pks.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Solution : Brute force: call dfs/ bfs to all cells. O((m*n)2)
 * Solution 2 : Start from adjacent cells of oceans
 * <p>
 * // TODO - Approach correct - Result wrong
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();

        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[][] pacificReachable = new boolean[numRows][numCols];
        boolean[][] atlanticReachable = new boolean[numRows][numCols];

        // left and top
        for (int i = 0; i < numRows; i++) {
            dfs(i, 0, pacificReachable, matrix);
            dfs(i, numCols - 1, atlanticReachable, matrix);
        }

        // bottom and right
        for (int i = 0; i < numCols; i++) {
            dfs(0, i, pacificReachable, matrix);
            dfs(numRows - 1, i, atlanticReachable, matrix);
        }

        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    public static void dfs(int row, int col, boolean[][] reachable, int[][] matrix) {
        reachable[row][col] = true;
        if (canGo(row, col, row + 1, col, matrix))
            dfs(row + 1, col, reachable, matrix);

        if (canGo(row, col, row - 1, col, matrix))
            dfs(row - 1, col, reachable, matrix);

        if (canGo(row, col, row, col + 1, matrix))
            dfs(row, col + 1, reachable, matrix);

        if (canGo(row, col, row, col - 1, matrix))
            dfs(row, col - 1, reachable, matrix);

    }

    public static boolean canGo(int row, int col, int newRow, int newCol, int[][] matrix) {
        if (newRow > 0 && newRow < matrix.length && newCol > 0 && newCol < matrix[0].length &&
                matrix[row][col] > matrix[newRow][newCol]) {
            return true;
        }
        return false;
    }
}
