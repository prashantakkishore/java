package com.pks.ds.dp;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 *  Use dynamic programming with memoization
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(numberOfWays(8));
    }

    public static int numberOfWays(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1]; // no value on 0th index
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
