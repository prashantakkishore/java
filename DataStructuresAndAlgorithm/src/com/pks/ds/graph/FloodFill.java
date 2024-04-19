package com.pks.ds.graph;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flood-fill/
 * Go left, right, top , bottom and fill new color
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        print(image);
        floodFill( 1, 1, 2, image);
        print(image);
    }

    public static void print(int[][] image){
        System.out.println(Arrays.deepToString(image));
    }

    public static int[][] floodFill(int sr, int sc, int newColor, int[][] image) {
        int prevColor = image[sr][sc];
        floodFillDFS(sr, sc, prevColor, newColor, image);
        System.out.println();

        return image;

    }

    public static void floodFillDFS(int sr, int sc, int prevColor, int newColor, int[][] image) {

        if (canNotGo(sr, sc, prevColor, image))
            return;

        image[sr][sc] = newColor;
        
        // left
        floodFillDFS(sr, sc - 1, prevColor, newColor, image);
        // right
        floodFillDFS(sr, sc + 1, prevColor, newColor, image);
        // top
        floodFillDFS(sr - 1, sc, prevColor, newColor, image);
        // bottom
        floodFillDFS(sr + 1, sc, prevColor, newColor, image);
    }

    private static boolean canNotGo(int sr, int sc, int prevColor, int[][] image) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != prevColor) {
            return true;
        } else {
            return false;
        }
    }
}
