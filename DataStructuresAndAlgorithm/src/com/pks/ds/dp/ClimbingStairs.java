package com.pks.ds.dp;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    // Recursion - O(2^n) Brute Force
    // Space complexity : O(n) The depth of recursion tree can go upto nn.
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    // Recursion - O(2^n) Brute Force
    // Space complexity : O(n) The depth of recursion tree can go upto nn.
    public int climb_Stairs(int i, int n) {
        // out of bound case
        if (i > n) {
            return 0;
        }
        // found , reached at top
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    // Recursion with Memoization - O(n). Size of recursion tree can go upto n.
    // Space complexity : O(n). The depth of recursion tree can go upto nn.
    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    // dp solution
    // time O(n)
    // space O(n)
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Fibonacci Number
    // time O(n)
    // space O(1)
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
