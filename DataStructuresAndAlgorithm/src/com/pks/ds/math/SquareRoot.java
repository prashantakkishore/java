package com.pks.ds.math;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(sqRoot(11));
    }

    // O(√ n)
    public static int sqRoot(Integer num) {
        int i = 1;
        while (i * i <= num) {
            i++;
        }
        return i - 1;
    }

    // O(log n)
    public static int sqRootBinarySearch(int x) {
        // Base Cases
        if (x == 0 || x == 1)
            return x;


        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = x, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            // If x is a perfect square
            if (mid * mid == x)
                return (int) mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            } else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return (int) ans;
    }
}
