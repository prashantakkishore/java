package com.pks.ds.graph;

/**
 * DFS Not suied for sortest path, Use BFS
 *
 * Given an MxN matrix where each element can either be 0 or 1. We need to find the shortest path between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * mat[ROW][COL]  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
 * {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
 * {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
 * {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
 * {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
 * {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
 * {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
 * {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
 * {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
 * Source = {0, 0};
 * Destination = {3, 4};
 * <p>
 * Output:
 * Shortest Path is 11
 */

public class ShortestPathBinaryMazeDFS {

    static boolean canGo(int[][] mat,
                         int xSrc, int ySrc) {
        return (xSrc >= 0 && xSrc < mat.length && ySrc >= 0
                && ySrc < mat[0].length && mat[xSrc][ySrc] == 1
        );
    }

    static int findShortestPath(int[][] mat, int xSrc, int ySrc,
                                int xDest, int yDest, int min_dist,
                                int dist) {

        if (xSrc == xDest && ySrc == yDest) {
            min_dist = Math.min(dist, min_dist);
            return min_dist;
        }

        mat[xSrc][ySrc] = 0;
        // bottom
        if (canGo(mat, xSrc + 1, ySrc)) {
            min_dist = findShortestPath(mat, xSrc + 1, ySrc, xDest, yDest,
                    min_dist, dist + 1);
        }
        // right
        if (canGo(mat, xSrc, ySrc + 1)) {
            min_dist = findShortestPath(mat, xSrc, ySrc + 1, xDest, yDest,
                    min_dist, dist + 1);
        }
        // top
        if (canGo(mat, xSrc - 1, ySrc)) {
            min_dist = findShortestPath(mat, xSrc - 1, ySrc, xDest, yDest,
                    min_dist, dist + 1);
        }
        // left
        if (canGo(mat, xSrc, ySrc - 1)) {
            min_dist = findShortestPath(mat, xSrc, ySrc - 1, xDest, yDest,
                    min_dist, dist + 1);
        }
        // backtrack: make (xSrc, ySrc) back to 1
        mat[xSrc][ySrc] = 1;
        return min_dist;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };

        int[] src = {0, 0};
        int[] dest = {3, 4};
        int minDist = Integer.MAX_VALUE;
        int dist = findShortestPath(mat, src[0],src[1],dest[0], dest[1],minDist, 0 );
        if (dist != -1)
            System.out.print("Shortest Path is " + dist);
        else
            System.out.print("Shortest Path doesn't exist");
    }
}
