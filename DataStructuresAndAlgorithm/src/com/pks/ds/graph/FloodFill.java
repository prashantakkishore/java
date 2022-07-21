package com.pks.ds.graph;

/**
 * https://leetcode.com/problems/flood-fill/
 * Go left, right, top , bottom and fill new color
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill( 1, 1, 2, image);
    }


    public static int[][] floodFill(int sr, int sc, int newColor, int[][] image) {

        int totalRow = image.length; // 3
        int totalColumn = image[0].length; // 3
        int prevColor = image[sr][sc];
        floodFillDFS(sr, sc, totalRow, totalColumn, prevColor, newColor, image);
        System.out.println();

        return image;

    }


    public static void floodFillDFS(int sr, int sc, int totalRow, int totalColumn, int prevColor, int newColor, int[][] image) {
        image[sr][sc] = newColor;
        // left
        if (canGo(sr, sc - 1, totalRow, totalColumn, prevColor, image))
            floodFillDFS(sr, sc - 1, totalRow, totalColumn, prevColor, newColor, image);
        //right
        if (canGo(sr, sc + 1, totalRow, totalColumn, prevColor, image))
            floodFillDFS(sr, sc + 1, totalRow, totalColumn, prevColor, newColor, image);
        //top
        if (canGo(sr - 1, sc, totalRow, totalColumn, prevColor, image))
            floodFillDFS(sr - 1, sc, totalRow, totalColumn, prevColor, newColor, image);
        //bottom
        if (canGo(sr + 1, sc, totalRow, totalColumn, prevColor, image))
            floodFillDFS(sr + 1, sc, totalRow, totalColumn, prevColor, newColor, image);
    }

    private static boolean canGo(int sr, int sc, int totalRow, int totalColumn, int prevColor, int[][] image) {
        if (sr >= 0 && sr <= totalRow - 1 && sc >= 0 && sc <= totalColumn - 1 && image[sr][sc] == prevColor) {
            return true;
        } else {
            return false;
        }
    }
}
