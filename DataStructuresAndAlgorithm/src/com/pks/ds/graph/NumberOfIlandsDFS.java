package com.pks.ds.graph;

public class NumberOfIlandsDFS {


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 5, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(matrix[2][1]);
//        countIlands(matrix);

    }

    private static void countIlands(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int ilands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(matrix[i][j] == 1){
                    ilands++;
                    dfs(matrix, i, j, row, column);
                }
            }
        }
        System.out.println("Ilands "+ ilands);

    }

    private static void dfs(int[][] matrix, int currRow, int currColumn, int totalRow, int totalColumn) {

        matrix[currRow][currColumn] = 0;

        //left
        if (needsCheck(matrix, currRow, currColumn -1 , totalRow, totalColumn))
            dfs(matrix, currRow, currColumn -1 , totalRow, totalColumn);
        //right
        if (needsCheck(matrix, currRow, currColumn +1 , totalRow, totalColumn))
            dfs(matrix, currRow, currColumn +1 , totalRow, totalColumn);
        //top
        if (needsCheck(matrix, currRow -1, currColumn , totalRow, totalColumn))
            dfs(matrix, currRow -1 , currColumn , totalRow, totalColumn);
        //bottom
        if (needsCheck(matrix, currRow +1, currColumn , totalRow, totalColumn))
            dfs(matrix, currRow +1 , currColumn , totalRow, totalColumn);

    }

    private static boolean needsCheck(int[][] matrix, int currRow, int currColumn, int totalRow, int totalColumn){
        // no outof bound, and value is 1
        if(currRow >= 0 && currRow < totalRow && currColumn >= 0 && currColumn < totalColumn && matrix[currRow][currColumn] == 1)
            return true;
        return false;
    }


}
