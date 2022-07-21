package com.pks.ds.math;

public class PrintPrime1ToN {

    public static void main(String[] args) {
        int N = 100;
        //check for every number from 1 to N
        for (int i = 1; i <= N; i++) {
            //check if current number is prime
            if (isPrime3(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // O(N^2) Check 1 - N
    static boolean isPrime1(int n) {
        //since 0 and 1 is not prime return false.
        if (n == 1 || n == 0) return false;

        //Run a loop from 2 to n-1
        for (int i = 2; i < n; i++) {
            // if the number is divisible by i, then n is not a prime number.
            if (n % i == 0) return false;
        }
        //otherwise, n is prime number.
        return true;
    }

    /**
     * For checking if a number is prime or not do we really need to iterate
     * through all the number form 2 to n-1? We already know that a number ‘n’
     * cannot be divided by any number greater than ‘n/2’. So, according to this
     * logic we only need to iterate through 2 to n/2 since number greater than n/2 cannot divide n.
     */
    // O(N^2) Check 1 - N/2
    static boolean isPrime2(int n) {
        //since 0 and 1 is not prime return false.
        if (n == 1 || n == 0) return false;

        //Run a loop from 2 to n-1
        for (int i = 2; i < n/ 2; i++) {
            // if the number is divisible by i, then n is not a prime number.
            if (n % i == 0) return false;
        }
        //otherwise, n is prime number.
        return true;
    }

    /**
     * If a number ‘n’ is not divided by any number less than or equals to the square
     * root of n then, it will not be divided by any other number greater than the square
     * root of n. So, we only need to check up to the square root of n.
     */
    // O(N^(3/2)) Check 1 - sqroot(N)
    static boolean isPrime3(int n) {
        //since 0 and 1 is not prime return false.
        if (n == 1 || n == 0) return false;

        //Run a loop from 2 to n-1
        for (int i = 2; i * i < n; i++) {
            // if the number is divisible by i, then n is not a prime number.
            if (n % i == 0) return false;
        }
        //otherwise, n is prime number.
        return true;
    }
}
