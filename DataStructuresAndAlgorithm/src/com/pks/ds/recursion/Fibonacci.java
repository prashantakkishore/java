package com.pks.ds.recursion;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fibonacciRecursiveWithMemoization(10, new int[11]));
        System.out.println(fibonacciRecursive(10));
        System.out.println(fibonacciIterative(10));
    }

    // O(2^n) exponential
    private static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // O(n)
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        int nth = 1;
        for (int i = 2; i <= n; i++) {
            nth = first + second;
            first = second;
            second = nth;
        }
        return nth;
    }

    // Better than recursion
    private static int fibonacciRecursiveWithMemoization(int n, int [] cache) {
        if (n <= 1) {
            return n;
        }
        if (cache[n] == 0) {
            cache[n] = fibonacciRecursiveWithMemoization(n - 1, cache) + fibonacciRecursiveWithMemoization(n - 2, cache);
        }
        return cache[n];
    }

}
