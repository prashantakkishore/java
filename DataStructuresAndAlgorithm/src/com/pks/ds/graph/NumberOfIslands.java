package com.pks.ds.graph;

/**
 * https://www.geeksforgeeks.org/count-number-islands-every-island-separated-line/
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        // Size of given matrix is m X n
        int m = 6;
        int n = 3;
        int mat[][] = {{'O', 'O', 'O'},
                {'X', 'X', 'O'},
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'O', 'O', 'X'},
                {'X', 'X', 'O'}
        };
        System.out.println("Number of rectangular islands is: "
                + countIslands(mat, m, n));
    }

    // This function takes a matrix of 'X' and 'O'
    // and returns the number of rectangular islands
    // of 'X' where no two islands are row-wise or
    // column-wise adjacent, the islands may be diagonally
    // adjacent
    // O(MN)
    static int countIslands(int mat[][], int m, int n) {
        int ilands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X')
                    if ((i == 0 || mat[i-1][j] == 'O') &&  (j == 0 || mat[i][j-1] == 'O')) {
                        ilands++;
                    }

            }

        }
        return ilands;
    }






}
