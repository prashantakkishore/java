package com.pks.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
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
public class ShortestPathBinaryMazeBFS {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int findShortestPath(int[][] mat, int xSrc, int ySrc, int xDest, int yDest, int dist) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(xSrc, ySrc));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Pair current = queue.remove();
                int x = current.x;
                int y = current.y;

                if (x == xDest && y == yDest) return dist;
                //up
                if (x > 0 && mat[x - 1][y] == 1) {
                    mat[x -1 ][y] = 0;
                    queue.add(new Pair(x - 1, y));
                }
                //down
                if (x < mat.length - 1 && mat[x + 1][y] == 1) {
                    mat[x + 1][y] = 0;
                    queue.add(new Pair(x + 1, y));
                }
                //left
                if (y > 0 && mat[x][y - 1] == 1) {
                    mat[x][y - 1] = 0;
                    queue.add(new Pair(x, y - 1));
                }
                //right
                if (y < mat[0].length - 1 && mat[x][y + 1] == 1) {
                    mat[x][y + 1] = 0;
                    queue.add(new Pair(x, y + 1));
                }
                size--;
            }

            dist++;

        }

        return -1;


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
        int dist = findShortestPath(mat, src[0], src[1], dest[0], dest[1], 0);
        if (dist != -1)
            System.out.print("Shortest Path is " + dist);
        else
            System.out.print("Shortest Path doesn't exist");
    }


}