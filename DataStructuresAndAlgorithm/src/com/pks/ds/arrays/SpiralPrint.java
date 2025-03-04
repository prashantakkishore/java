package com.pks.ds.arrays;

public class SpiralPrint {


    public static void spiralPrint2(int arr[][]) {

        int T, B, L, R, dir;
        T = 0;
        B = arr.length - 1;
        L = 0;
        R = arr[0].length - 1;
        dir = 0;
        int i;

        while (T <= B && L <= R) {
            if (dir == 0) {
                for (i = L; i <= R; i++)
                    System.out.print(arr[T][i] + " ");
                T++;
            } else if (dir == 1) {
                for (i = T; i <= B; i++)
                    System.out.print(arr[i][R] + " ");
                R--;
            } else if (dir == 2) {
                for (i = R; i >= L; i--)
                    System.out.print(arr[B][i] + " ");
                B--;
            } else if (dir == 3) {
                for (i = B; i >= T; i--)
                    System.out.print(arr[i][L] + " ");
                L++;
            }
            // Repeat dir after 4 times
            dir = (dir + 1) % 4;
        }
    }


    static void spiralPrint(int m, int n, int a[][]) {
        int i, k = 0, l = 0;
        /*
         * k - starting row index m - ending row index l - starting column index
         * n - ending column index i - iterator
         */

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

    // driver program
    public static void main(String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}};
        //spiralPrint(R, C, a);
		spiralPrint2(a);
    }
}
